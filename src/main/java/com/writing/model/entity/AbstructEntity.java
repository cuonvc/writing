package com.writing.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstructEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public AbstructEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
