package com.example.main.wantpdca.dto;

/**
 *
 * wantリストの検索条件を保持するクラス
 * Created by main on 2015/12/23.
 */
public class SearchWantListCondition {

    private int wantId;
    private int motivationId;
    private String wantText;

    //スタートページ：未実装　2015/12/23
    private int startNum;

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

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }





}
