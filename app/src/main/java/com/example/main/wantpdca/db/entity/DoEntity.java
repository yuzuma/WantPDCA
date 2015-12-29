package com.example.main.wantpdca.db.entity;

import java.io.Serializable;

/**
 * Created by main on 2015/12/27.
 */
public class DoEntity implements Serializable {
    private int doId;
    private int wantId;
    private String doTitle;
    private long  doDeadLine;
    private long createdAt;
    private long updatedAt;

    public int getDoId() {
        return doId;
    }

    public void setDoId(int doId) {
        this.doId = doId;
    }

    public int getWantId() {
        return wantId;
    }

    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    public String getDoTitle() {
        return doTitle;
    }

    public void setDoTitle(String doTitle) {
        this.doTitle = doTitle;
    }

    public long getDoDeadLine() {
        return doDeadLine;
    }

    public void setDoDeadLine(long doDeadLine) {
        this.doDeadLine = doDeadLine;
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

