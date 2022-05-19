package com.writing.model.converter;

import com.writing.model.dto.AccountDTO;
import com.writing.model.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    public AccountDTO toDto(AccountEntity entity) {
        AccountDTO dto = new AccountDTO();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPassword(entity.getPassword());
        dto.setGender(entity.getGender());
        dto.setAbout(entity.getAbout());
        dto.setEnabled(entity.getEnabled());
        //...
        return dto;
    }

    public AccountEntity toEntity(AccountDTO dto) {
        AccountEntity entity = new AccountEntity();

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
        entity.setAbout(dto.getAbout());
        entity.setEnabled(dto.getEnabled());
        //...
        return entity;
    }

    public AccountEntity toEntity(AccountDTO dto, AccountEntity entity) {

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
        entity.setAbout(dto.getAbout());
        entity.setEnabled(dto.getEnabled());
        //...
        return entity;
    }
}
