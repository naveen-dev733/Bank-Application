package com.bank.app.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bank.app.model.Account;
import com.bank.app.model.Bank;
import com.bank.app.repository.AccountRepository;
import com.bank.app.repository.BankRepository;
@Service
public class BankService 
{
    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;
    // Constructor Injection
    public BankService(BankRepository bankRepository,AccountRepository accountRepository) 
    {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
    }
    public Bank saveBank(Bank bank) 
    {
        return bankRepository.save(bank);
    }
    public List<Bank> getAllBanks() 
    {
        return bankRepository.findAll();
    }
    public Account addAccountToBank(Long bankId, Account account) 
    {
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> new RuntimeException("Bank Not Found"));
        account.setBank(bank);
        return accountRepository.save(account);
    }
}