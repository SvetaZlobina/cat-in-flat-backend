package org.hops.backend.api.model;

public class RoomInfo {
    private long roomId;
    private long homeId;
    private String title;

    public RoomInfo(long roomId, long homeId, String title) {
        this.roomId = roomId;
        this.homeId = homeId;
        this.title = title;
    }

    public RoomInfo() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getHomeId() {
        return homeId;
    }

    public void setHomeId(long homeId) {
        this.homeId = homeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
