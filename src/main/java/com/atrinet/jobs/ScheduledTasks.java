package com.atrinet.jobs;

import com.atrinet.service.AtrServiceConManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rasth on 1/24/2016.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    AtrServiceConManager atrServiceConManager;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        atrServiceConManager.connect();
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}