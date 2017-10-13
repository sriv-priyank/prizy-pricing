package com.prizy.product.service.impl;

import com.prizy.common.exception.ApiException;
import com.prizy.common.exception.BadRequestException;
import com.prizy.product.jobs.PriceCalculationJob;
import com.prizy.product.service.JobsService;
import com.prizy.product.vo.JobVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JobServiceImpl implements JobsService {

    @Override
    public JobVO startPriceCalculatorJob(String command) {
        if ("start".equals(command)) {
            long started = priceCalculationJob.calculatePrices();
            if (started == -1L) {
                throw new ApiException("Another job is already running...");

            } else {
                JobVO jobVO = new JobVO();
                jobVO.setJob("price-calculation");
                jobVO.setStarted(new Date(started));

                return jobVO;
            }
        }
        throw new BadRequestException("Invalid command");

    }

    @Autowired
    private PriceCalculationJob priceCalculationJob;
}
