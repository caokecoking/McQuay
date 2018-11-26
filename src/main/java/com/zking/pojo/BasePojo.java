package com.zking.pojo;

public class BasePojo {
    private String name;
    private int page;
    private int limit;
    private String startTime;
    private String endTime;

    public BasePojo() {
    }

    public BasePojo(String name, int page, int limit, String startTime, String endTime) {
        this.name = name;
        this.page = page;
        this.limit = limit;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
