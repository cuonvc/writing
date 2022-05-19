package com.writing.model.entity;

import com.writing.model.constraints.FollowingRelaKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "following_relationship")
@IdClass(FollowingRelaKey.class)
public class FollowingRelationshipEntity {

    @Id
    @Column(name = "account_id")
    private Integer accountId;

    @Id
    @Column(name = "following_account_id")
    private Integer followingAccountId;

    @ManyToOne()
    @MapsId(value = "accountId")
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;

    @Column(name = "followed_date")
    private Date followedDate;

    public FollowingRelationshipEntity() {
    }

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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public Date getFollowedDate() {
        return followedDate;
    }

    public void setFollowedDate(Date followedDate) {
        this.followedDate = followedDate;
    }
}
