package com.example.main.wantpdca.db.entity;

import java.io.Serializable;

/**
 * Created by main on 2015/12/23.
 */
public class WantEntity implements Serializable{


    private int wantId;
    private int motivationId;
    private String wantText;
    private int planId;
    private int doId;
    private int checkId;
    private int actId;
    private long createdAt;
    private long updatedAt;

    public int getWantId() {
        return wantId;
    }

    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    public int getMotivationId() {
        return motivationId;
    }

    public void setMotivationId(int motivationId) {
        this.motivationId = motivationId;
    }

    public String getWantText() {
        return wantText;
    }

    public void setWantText(String wantText) {
        this.wantText = wantText;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getDoId() {
        return doId;
    }

    public void setDoId(int doId) {
        this.doId = doId;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
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
