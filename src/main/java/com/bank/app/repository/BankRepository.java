package com.bank.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.model.Bank;
public interface BankRepository extends JpaRepository
<Bank, Long>
{
	
}
