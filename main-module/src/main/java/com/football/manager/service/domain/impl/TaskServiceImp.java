package com.football.manager.service.domain.impl;

import com.football.manager.dao.EventDao;
import com.football.manager.dao.TaskDao;
import com.football.manager.dto.input.InputDataForTaskFromForm;
import com.football.manager.entity.Event;
import com.football.manager.entity.Task;
import com.football.manager.service.domain.TaskService;
import com.football.manager.service.domain.exception.TaskServiceException;
import com.football.manager.util.ParsersMapping;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TaskServiceImp implements TaskService {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private EventDao eventDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void addTask(InputDataForTaskFromForm inputData) {
        String eventName = inputData.getEventName();
        if (eventDao.existsWithSuchName(eventName)) {
            log.warn("Attempt to insert new task for existing event name {}", eventName);
            throw new TaskServiceException("Event with name " + eventName + " already exists!");
        }

        Event event = new Event(eventName);
        Integer eventId = eventDao.add(event);
        Integer sessionId = inputData.getSessionId();
        Integer roundId = inputData.getRoundId();
        Integer competitionId = inputData.getCompetitionId();

        Task task = new Task(sessionId, roundId, competitionId, eventId);
        taskDao.add(createTasks(task));
    }

    private List<Task> createTasks(Task first) {
        List<Task> result = new ArrayList<>(Arrays.asList(first, copy(first), copy(first)));

        List<Integer> parserIds = ParsersMapping.getParserIds();
        if (result.size() != parserIds.size()) {
            log.warn("Amount creating tasks ({}) doesn't equal amount parsers! ({})",
                    result.size(), parserIds.size());
        }

        Iterator<Integer> iterator = parserIds.iterator();
        for (Task task : result) {
            if (iterator.hasNext()) {
                Integer parserId = iterator.next();
                task.setParserId(parserId);
                task.setType(ParsersMapping.getType(parserId));
            } else {
                log.warn("Task creation was interrupted due parsers have been ended!");
                break;
            }
        }
        log.info("New tasks were created: {}", result);
        return result;
    }

    private Task copy(Task task) {
        return new Task(task.getSessionId(), task.getRoundId(), task.getCompetitionId(), task.getEventId());
    }

}