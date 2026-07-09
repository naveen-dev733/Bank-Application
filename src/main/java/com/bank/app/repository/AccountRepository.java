package com.bank.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.model.Account;
public interface AccountRepository extends JpaRepository<Account, Long>
{

}
