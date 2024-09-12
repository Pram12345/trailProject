package com.Synergastic.controller;



public class WebhookRequest {

    private String payment_id;
    private String amount;
    private String currency;
    private String description;

    // Getters and Setters
    public String getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
