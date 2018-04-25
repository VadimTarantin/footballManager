package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.entity.Task;
import com.football.manager.util.ParsersMapping;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskProcessingManager extends BaseProcessor {

    List<Task> tasks;
    ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;

    public TaskProcessingManager(List<Task> tasks,
                                 ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos) {
        this.tasks = tasks;
        this.businessTaskDtos = businessTaskDtos;
    }

    @Override
    protected void init() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                log.info("Interrupt during init method. Will be break");
                break;
            }

            synchronized (tasks) {
                if (!tasks.isEmpty()) {
                    break;
                }
            }
        }
    }

    @Override
    protected void doWork() throws InterruptedException {
        TripleTask tripleTask = null;
        if (!tasks.isEmpty()) {
            synchronized (tasks) {
                tripleTask = unionThreeTasks();
            }
            if (tripleTask != null) {
                createBusinessTask(tripleTask);
            }
        } else {
            throw new InterruptedException("Processing tasks -> BusinessTaskDto was finished");
        }
    }

    private void createBusinessTask(TripleTask tripleTask) throws InterruptedException {
        Task wide = tripleTask.getTaskByType(ParsersMapping.WIDE_TABLE_TEAM.getType());
        Task form = tripleTask.getTaskByType(ParsersMapping.FORM_TABLE_TEAM.getType());
        Task overUnder = tripleTask.getTaskByType(ParsersMapping.OVER_UNDER_TABLE_TEAM.getType());
        if (wide != null && form != null && overUnder != null) {
            businessTaskDtos.offer(new BusinessTaskDto(wide, form, overUnder), TIMEOUT, TimeUnit.MILLISECONDS);
        } else {
            log.warn("Created TripleTask is invalid: first={}, second={}, third={}", wide, form, overUnder);
        }
    }

    private TripleTask unionThreeTasks() {
        Task first = tasks.remove(0);
        Task second = null;
        Task third = null;
        for (Task task : tasks) {
            if (first.fromSameEvent(task)) {
                second = task;
                tasks.remove(task);
                break;
            }
        }

        for (Task task : tasks) {
            if (first.fromSameEvent(task)) {
                third = task;
                tasks.remove(task);
                break;
            }
        }

        if (first != null && second != null && third != null) {
            return new TripleTask(first, second, third);
        }
        log.warn("Cannot create Business task because there are not three tasks by one even in database. Task ={}", first);
        return null;
    }

    private class TripleTask {
        private Task first;
        private Task second;
        private Task third;

        public TripleTask(Task first, Task second, Task third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        private Task getTaskByType(String type) {
            if (type == null) {
                return null;
            }
            Task result = null;
            if (first != null && type.equals(first.getType())) {
                result = first;
                first = null;
            } else if (second != null && type.equals(second.getType())) {
                result = second;
                second = null;
            } else if (third != null && type.equals(third.getType())) {
                result = third;
                third = null;
            }
            return result;
        }

    }

}