package com.illy.kafkatest.domain;

import java.io.Serializable;

public class Column implements Serializable {
    private String org;
    private String target;

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
