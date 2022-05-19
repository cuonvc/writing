package com.writing.model.constraints;

import java.io.Serializable;

public class FollowingRelaKey implements Serializable {

    private Integer accountId;
    private Integer followingAccountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getFollowingAccountId() {
        return followingAccountId;
    }

    public void setFollowingAccountId(Integer followingAccountId) {
        this.followingAccountId = followingAccountId;
    }
}
