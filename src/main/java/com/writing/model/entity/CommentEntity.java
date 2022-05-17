package com.writing.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity extends AbstructEntity {

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(nullable = false)
    private String content;

    @Column(name = "content_date")
    private Date contentDate;

    public CommentEntity() {
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContentDate() {
        return contentDate;
    }

    public void setContentDate(Date contentDate) {
        this.contentDate = contentDate;
    }
}
