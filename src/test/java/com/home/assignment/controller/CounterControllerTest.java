package com.home.assignment.controller;

import com.home.assignment.service.CounterService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ranjitapurwar on 5/24/18.
 */
public class CounterControllerTest {

    @Mock
    CounterService counterService;

    CounterController counterController;

    @Before
    public void startup() {
        MockitoAnnotations.initMocks(this);
        counterController = new CounterController();
        counterController.setCounterService(this.counterService);
    }

    @Test(expected= WebApplicationException.class)
    public void shouldThrowWebApplicationExceptionIfCountLessThanZero(){
        counterController.incrementCounter(-1l);
    }

    @Test
    public void shouldReturnAValidCount(){
        when(counterService.getNextCount(0l)).thenReturn(1l);
        Response response = counterController.incrementCounter(0l);
        assertEquals(200, response.getStatus());
        assertEquals(1l, response.getEntity());
        verify(counterService).getNextCount(anyLong());
    }

    @After
    public void teardown() {
        counterController = null;
    }
}
