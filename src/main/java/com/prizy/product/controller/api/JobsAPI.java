package com.prizy.product.controller.api;

import com.prizy.product.vo.JobVO;
import org.springframework.http.ResponseEntity;

public interface JobsAPI {

    ResponseEntity<JobVO> startPriceCalculatorJob(String command);
}
