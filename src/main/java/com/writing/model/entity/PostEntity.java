package com.writing.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
public class PostEntity extends AbstructEntity {

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(length = 255)
    private String thumbnail;

    @OneToMany(mappedBy = "post")
    private Set<CommentEntity> posts;

    @ManyToMany(mappedBy = "posts")
    private List<CategoryEntity> categories = new ArrayList<>();

    public PostEntity() {
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setmodifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Set<CommentEntity> getPosts() {
        return posts;
    }

    public void setPosts(Set<CommentEntity> posts) {
        this.posts = posts;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
