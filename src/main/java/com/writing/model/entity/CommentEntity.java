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

    @Column(name = "comment_date")
    private Date commentDate;

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

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
