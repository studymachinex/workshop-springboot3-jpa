package com.ibm.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT("WAITING_PAYMENT"),
    SHIPPED("SHIPPED"),
    PAID("PAID"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED");

    private String status;
    private OrderStatus(String status){
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}