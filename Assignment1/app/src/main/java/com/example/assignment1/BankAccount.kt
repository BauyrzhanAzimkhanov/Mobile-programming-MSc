package com.example.assignment1

open class BankAccount(private var balance: Double)
{
    open fun deposit(amount: Double)
    {
        if (amount > 0)
        {
            balance += amount;
            println("Deposited: $amount, New Balance: $balance");
        }
        else
        {
            println("Deposit amount must be positive");
        }
    }

    open fun withdraw(amount: Double)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            println("Withdrew: $amount, New Balance: $balance");
        }
        else
        {
            println("Insufficient balance or invalid amount");
        }
    }

    open fun getBalance(): Double
    {
        return balance;
    }
}