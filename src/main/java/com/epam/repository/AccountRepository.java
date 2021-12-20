package com.epam.repository;
import com.epam.entity.Account;
import org.springframework.data.repository.CrudRepository;
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
