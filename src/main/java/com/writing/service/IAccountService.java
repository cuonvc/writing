package com.writing.service;

import com.writing.model.dto.AccountDTO;
import com.writing.model.entity.AccountEntity;

import java.text.ParseException;

public interface IAccountService {

    AccountDTO saveAccount(AccountDTO account) throws ParseException;
}
