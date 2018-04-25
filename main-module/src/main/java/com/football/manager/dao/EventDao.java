package com.football.manager.dao;

import com.football.manager.entity.Event;

import java.util.List;

public interface EventDao {
    Integer add(Event event);
    Event getEventByName(String name);
    Event getEventById(int id);
    boolean existsWithSuchName(String name);
    List<Event> getAll();
}