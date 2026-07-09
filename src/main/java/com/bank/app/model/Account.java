package com.bank.app.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Entity
@Table(name="accounts")
public class Account 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private Double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bank_id")
    @JsonIgnoreProperties("accounts")
    private Bank bank;
    // Default Constructor
    public Account(){}
    // Getters And Setters
    public Long getId() 
    {
        return id;
    }
    public void setId(Long id) 
    {
        this.id=id;
    }
    public String getAccountHolderName() 
    {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) 
    {
        this.accountHolderName=accountHolderName;
    }
    public Double getBalance() 
    {
        return balance;
    }
    public void setBalance(Double balance) 
    {
        this.balance=balance;
    }
    public Bank getBank() 
    {
        return bank;
    }
    public void setBank(Bank bank) 
    {
        this.bank=bank;
    }
}