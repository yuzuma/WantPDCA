package com.example.main.wantpdca.db.entity;

import java.io.Serializable;

/**
 * Created by main on 2015/12/27.
 */
public class CheckTableEntity implements Serializable {
    private int planId;
    private int wantId;
    private String planTitle;
    private long planDeadLine;
    private long createdAt;
    private long updatedAt;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getWantId() {
        return wantId;
    }

    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public long getPlanDeadLine() {
        return planDeadLine;
    }

    public void setPlanDeadLine(long planDeadLine) {
        this.planDeadLine = planDeadLine;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}

