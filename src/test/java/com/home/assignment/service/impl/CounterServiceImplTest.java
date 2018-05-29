package com.home.assignment.service.impl;

import com.home.assignment.controller.CounterController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * Created by ranjitapurwar on 5/29/18.
 */
public class CounterServiceImplTest {

    CounterServiceImpl counterServiceImpl;

    @Before
    public void startup() {
        counterServiceImpl = new CounterServiceImpl();
    }

    @Test
    public void shouldReturnOneIfCurrentCountIsZero(){
        long retVal = counterServiceImpl.getNextCount(0l);
        assertEquals(retVal, 1l);
    }

    @Test
    public void shouldReturnTwiceTheCountIfCurrentCountIsNotZero(){
        long retValue = counterServiceImpl.getNextCount(4l);
        assertEquals(retValue, 8l);
    }


    @After
    public void teardown() {
        counterServiceImpl = null;
    }
}
