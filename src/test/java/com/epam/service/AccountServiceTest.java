package com.epam.service;
import com.epam.dao.AccountDao;
import com.epam.dto.RegisterDTO;
import com.epam.entity.Account;
import com.epam.exception.AccountAlreadyExistsException;
import com.epam.exception.NoGroupFoundForAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class AccountServiceTest {
    @InjectMocks
    AccountService accountService;
    @Mock
    AccountDao accountDao;
@Test
     void testRegisterAccount() throws AccountAlreadyExistsException, NoGroupFoundForAccount {
        RegisterDTO registerDTO = new RegisterDTO("TATA", "Rahul", "www.leetcode.com", "#@*ui*&M");
        when(accountDao.registerAccount(registerDTO)).thenReturn(true);
        Assertions.assertDoesNotThrow(() ->accountService.registerAccount(registerDTO));
    }

    @Test
    void testAllAccountByGroupName() throws NoGroupFoundForAccount {
    List<Account>accounts=new ArrayList<>();
        when(accountDao.displayUserAccountByGroupName("RAM")).thenReturn(accounts);
        Assertions.assertDoesNotThrow(() -> accountService.allAccountByGroupName("RAM"));
    }

    @Test
  void testDeleteAccountFromGroup() throws NoGroupFoundForAccount {
        when(accountDao.removeUserAccountFromGroup("RAM","Google")).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> accountService.deleteAccountFromGroup("RAM","Google"));
    }

    @Test
     void testUpdatePasswordFromUserAccount() throws NoGroupFoundForAccount {
        when(accountDao.updatePasswordForUserAccount("RAM","Google","@#$ASD")).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> accountService.updatePasswordFromUserAccount("RAM","Google","@#$ASD"));
    }
    @Test
      void testRetrievalPassword() throws NoGroupFoundForAccount {
        when(accountDao.retrievePassword("Google", "RAM")).thenReturn("#@$%ASDF");
        Assertions.assertDoesNotThrow(() -> accountService.retrievalPassword("Google","RAM"));
    }




}
