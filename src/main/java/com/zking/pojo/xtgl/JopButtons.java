package com.zking.pojo.xtgl;

public class JopButtons {
    private String jobid;
    private String bid;

    public JopButtons() {
    }

    public JopButtons(String jobid, String bid) {
        this.jobid = jobid;
        this.bid = bid;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
