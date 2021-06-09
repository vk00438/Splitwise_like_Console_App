package com.company.model;

public class User {
    private static int counter=1;
    private String userId;
    private String name;
    private int outStanding;

    public User(String name) {
        // this.userId  = Integer.toString(counter++);
        this.userId = name;
        this.name = name;
        this.outStanding = 0;
    }

    @Override
    public String toString() {
        return String.format("User %s : Outstanding Bal : %s",name,outStanding);
    }

    public void addAmountToBalance(int bal){
        outStanding+=bal;
    }

    public void deductAmountToBalance(int bal){
        outStanding-=bal;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
