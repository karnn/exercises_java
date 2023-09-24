package com.arun;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID id;

    @JsonProperty
    private double amount;

    @JsonProperty
    private String reference;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime date;

    public Transaction(UUID id, double amount, String reference, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.reference = reference;
        this.date = date;
    }
    public Transaction(){}

}
