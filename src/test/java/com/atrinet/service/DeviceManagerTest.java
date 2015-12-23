package com.atrinet.service;

import com.atrinet.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by John on 8/22/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class)
public class DeviceManagerTest {

    @Autowired
    DeviceManager deviceManager;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetDevices() throws Exception {

    }

    @Test
    public void testAddDevice() throws Exception {

    }

    @Test
    public void testUpdateDevice() throws Exception {

    }
}