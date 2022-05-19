package com.writing.account;

import com.writing.model.constraints.Gender;
import com.writing.model.constraints.Role;
import com.writing.model.entity.AccountEntity;
import com.writing.repository.AccountRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AccountRepoTest {

    @Autowired
    private AccountRepo accountRepo;

    @Test
    public void testCreateAccount() {
        AccountEntity account = new AccountEntity(
                "email test", "pass test", "first test", "last test", Gender.MALE.toString(),
                new Date(), "about test", new Date(), 1);

        System.out.println("=========================");
        System.out.println(account.getRole());
        accountRepo.save(account);
    }

    @Test
    public void testUpdateAccount() {
        AccountEntity existAccount = accountRepo.findById(1).get();
        existAccount.setAbout("about edit");
        existAccount.setGender(Gender.FEMALE.toString());
        existAccount.setRole(Role.ADMIN_ROLE.getAuthority());

        accountRepo.save(existAccount);
    }
}
