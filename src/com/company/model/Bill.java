package com.company.model;


import com.company.repository.Repository;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

public class Bill {
    private static int counter=1;
    private String billId;
    private String groupId;
    private int totalAmount;
    private Map<String,Integer> contributors;
    private Map<String,Integer> paidBy;
    private Repository repository;

    public Bill(Repository repository, String groupId, int totalAmount, Map<String,Integer> contributors, Map<String,Integer> paidBy){
        this.billId = Integer.toString(counter++);
        this.groupId  =groupId;
        this.totalAmount = totalAmount;
        this.contributors = contributors;
        this.paidBy = paidBy;
        this.repository = repository;
    }

    public void splitBill(){
        for(Map.Entry<String,Integer> entry : contributors.entrySet()){
            repository.getUser(entry.getKey()).addAmountToBalance(entry.getValue());
        }
        for(Map.Entry<String,Integer> entry : paidBy.entrySet()){
            repository.getUser(entry.getKey()).deductAmountToBalance(entry.getValue());
        }
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
