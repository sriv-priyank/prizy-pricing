package com.prizy.product.controller;

import com.prizy.product.service.JobsService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobsControllerTest {

    @InjectMocks
    private JobsController jobsController;

    @Mock
    private JobsService jobsService;
}
