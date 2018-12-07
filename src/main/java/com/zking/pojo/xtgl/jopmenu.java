package com.zking.pojo.xtgl;

public class jopmenu {
    private String MenuId;
    private String jobid;

    public jopmenu() {
    }

    public jopmenu(String menuId, String jobid) {
        MenuId = menuId;
        this.jobid = jobid;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }
}
