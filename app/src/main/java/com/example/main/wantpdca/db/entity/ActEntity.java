package com.example.main.wantpdca.db.entity;

import java.io.Serializable;

/**
 * Created by main on 2015/12/27.
 */
public class ActEntity implements Serializable {
    private int actId;
    private int wantId;
    private String actTitle;

    private String actText;
    private String actImage;

    private long actDeadLine;
    private long createdAt;
    private long updatedAt;

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public int getWantId() {
        return wantId;
    }

    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public long getActDeadLine() {
        return actDeadLine;
    }

    public void setActDeadLine(long actDeadLine) {
        this.actDeadLine = actDeadLine;
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

    public String getActImage() {
        return actImage;
    }

    public void setActImage(String actImage) {
        this.actImage = actImage;
    }

    public String getActText() {
        return actText;
    }

    public void setActText(String actText) {
        this.actText = actText;
    }
}

