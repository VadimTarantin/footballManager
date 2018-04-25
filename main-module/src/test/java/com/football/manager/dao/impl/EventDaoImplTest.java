package com.football.manager.dao.impl;

import com.football.manager.dao.EventDao;
import com.football.manager.dao.exception.EventDaoException;
import com.football.manager.dao.exception.NoSuchEntityException;
import com.football.manager.entity.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class EventDaoImplTest {

    @Autowired
    private EventDao eventDao;

    @Test
    public void testAddWhenInsertNonExistingEvenShouldOk() {
        eventDao.add(new Event("Not existing"));
    }

    @Test(expected = EventDaoException.class)
    public void testAddWhenInsertExistingEventShouldThrowsEventDaoException() {
        eventDao.add(new Event("England championship"));
    }

    @Test
    public void testExistsWithSuchNameWhenExistingShouldTrue() {
        boolean result = eventDao.existsWithSuchName("England championship");

        assertTrue(result);
    }

    @Test
    public void testExistsWithSuchNameWhenNotExistingShouldFalse() {
        boolean result = eventDao.existsWithSuchName("One more not existing");

        assertFalse(result);
    }

    @Test
    public void testGetByNameWhenExistingEvenShouldReturnEvent() {
        Event result = eventDao.getEventByName("England championship");

        assertNotNull(result);
        assertEquals(result.getName(), "England championship");
    }

    @Test (expected = NoSuchEntityException.class)
    public void testGetByNameWhenNotExistingEvenShouldThrownNoSuchEntityException() {
        Event result = eventDao.getEventByName("Abc");
    }

    @Test
    public void testGetAllEventShouldReturnListOfEvents() {
        List<Event> result = eventDao.getAll();

        assertTrue(result.size() == 2);
    }

}