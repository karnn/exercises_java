package com.arun;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions()  {
       return Collections.unmodifiableList(transactions);
    }

}
