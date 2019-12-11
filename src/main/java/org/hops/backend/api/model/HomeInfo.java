package org.hops.backend.api.model;

public class HomeInfo {
    private long homeId;
    private long userId;
    private String title;

    public HomeInfo(long homeId, long userId, String title) {
        this.homeId = homeId;
        this.userId = userId;
        this.title = title;
    }

    public long getHomeId() {
        return homeId;
    }

    public void setHomeId(long homeId) {
        this.homeId = homeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
