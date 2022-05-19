package com.writing.controller;

import com.writing.model.dto.AccountDTO;
import com.writing.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/account/new")
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) throws ParseException {
        return service.saveAccount(accountDTO);
    }

    @PutMapping("/account/edit/{id}")
    public AccountDTO updateAccount(@PathVariable(name = "id") Integer id,
                                    @RequestBody AccountDTO accountDTO) throws ParseException {
        accountDTO.setId(id);

        return service.saveAccount(accountDTO);
    }

    //list All
    @GetMapping("/account/list")
    public List<AccountDTO> listAll() {

        return service.listAll();
    }

    @DeleteMapping("/account/delete")
    public void deleteAccounts(@RequestBody Integer[] ids) {
        service.deleteByIds(ids);
    }
}
