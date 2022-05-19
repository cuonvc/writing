package com.writing.model.dto;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

public class AbstructDTO<T> {

    private Integer id;
    private List<T> listResult = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }
}
