package com.writing.service.impl;

import com.writing.model.constraints.Gender;
import com.writing.model.converter.AccountConverter;
import com.writing.model.dto.AccountDTO;
import com.writing.model.entity.AccountEntity;
import com.writing.repository.AccountRepo;
import com.writing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountConverter converter;

    @Override
    public AccountDTO saveAccount(AccountDTO account) throws ParseException {
        AccountEntity accountEntity;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        boolean isExistAccount = (accountRepo.findById(account.getId()) != null);

        //update
        if (isExistAccount) {
            AccountEntity oldAccount = accountRepo.findById(account.getId()).get();
            accountEntity = converter.toEntity(account, oldAccount);
        } else {
            //create
            accountEntity = converter.toEntity(account);
        }

        accountEntity.setLastLogin(new Date());
        accountEntity.setDateOfBirth(dateFormat.parse(account.getDateOfBirth()));
        accountRepo.save(accountEntity);

        return converter.toDto(accountEntity);
    }
}
