package com.writing.service;

import com.writing.model.dto.AccountDTO;
import com.writing.model.entity.AccountEntity;

import java.text.ParseException;
import java.util.List;

public interface IAccountService {

    AccountDTO saveAccount(AccountDTO account) throws ParseException;
    List<AccountDTO> listAll();
    void deleteByIds(Integer[] ids);
}
