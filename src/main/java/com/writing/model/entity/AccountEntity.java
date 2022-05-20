package com.writing.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.writing.model.constraints.Gender;
import com.writing.model.constraints.Role;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class AccountEntity extends AbstructEntity {

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(name = "pass_word", nullable = false)
    private String password;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @Column()
    @Builder.Default
    private String role = Role.USER_ROLE.getAuthority();

    @Column()
    private String gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column()
    private String about;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column()
    private Integer enabled;  //true = 1

    @OneToMany(mappedBy = "account")
    private Set<PostEntity> posts;

    @OneToMany(mappedBy = "account")
    private Set<FollowingRelationshipEntity> accountFollowing;

    @OneToMany(mappedBy = "account")
    private Set<CommentEntity> comments;

    public AccountEntity() {
    }

    public AccountEntity(String email, String password, String firstName,
                         String lastName, /*String role,*/ String gender, Date dateOfBirth,
                         String about, Date lastLogin,/* Integer loginCount,*/ Integer enabled) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.role = role;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.about = about;
        this.lastLogin = lastLogin;
//        this.loginCount = loginCount;
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Set<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostEntity> posts) {
        this.posts = posts;
    }

    public Set<FollowingRelationshipEntity> getAccountFollowing() {
        return accountFollowing;
    }

    public void setAccountFollowing(Set<FollowingRelationshipEntity> accountFollowing) {
        this.accountFollowing = accountFollowing;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }
}
