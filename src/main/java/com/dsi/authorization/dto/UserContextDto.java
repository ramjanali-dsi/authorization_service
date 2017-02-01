package com.dsi.authorization.dto;

/**
 * Created by sabbir on 1/26/17.
 */
public class UserContextDto {

    private String teamId;

    private String userId;

    private int activity;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}
