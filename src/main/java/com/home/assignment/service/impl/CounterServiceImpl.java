package com.home.assignment.service.impl;

import com.home.assignment.service.CounterService;

/**
 * Created by ranjitapurwar on 5/29/18.
 */
public class CounterServiceImpl implements CounterService{

    public CounterServiceImpl() {

    }

    public long getNextCount(long currentCount){
        return currentCount == 0 ? 1l : currentCount * 2;
    }
}
