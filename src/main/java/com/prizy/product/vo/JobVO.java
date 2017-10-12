package com.prizy.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class JobVO {

    private String job;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private Date started;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }
}
