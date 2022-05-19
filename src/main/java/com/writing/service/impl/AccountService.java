package com.writing.service.impl;

import com.writing.model.constraints.Gender;
import com.writing.model.converter.AccountConverter;
import com.writing.model.dto.AccountDTO;
import com.writing.model.entity.AccountEntity;
import com.writing.repository.AccountRepo;
import com.writing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountConverter converter;

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) throws ParseException {
        AccountEntity accountEntity;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //update
        if (accountDTO.getId() != null) {
            AccountEntity oldAccount = accountRepo.findById(accountDTO.getId()).get();
            accountEntity = converter.toEntity(accountDTO, oldAccount);
        } else {
            //create
            accountEntity = converter.toEntity(accountDTO);
        }

        accountEntity.setLastLogin(new Date());
        accountEntity.setDateOfBirth(dateFormat.parse(accountDTO.getDateOfBirth()));
        accountRepo.save(accountEntity);

        return converter.toDto(accountEntity);
    }

    @Override
    public List<AccountDTO> listAll() {
        Iterable<AccountEntity> accountEntities = accountRepo.findAll();
        List<AccountDTO> accountDTOList = new ArrayList<>();

        for (AccountEntity entity : accountEntities) {
            AccountDTO dto = converter.toDto(entity);
            accountDTOList.add(dto);
        }

        return accountDTOList;
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        for (Integer id : ids) {
            accountRepo.deleteById(id);
        }
    }
}
