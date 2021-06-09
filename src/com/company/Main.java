package com.company;

import com.company.model.User;
import com.company.repository.InMemoryRepository;
import com.company.repository.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Repository repository = new InMemoryRepository();


        String[] userNames = {"vivek","kumar","pooja","kharedia"};
        for(String user: userNames) repository.createUserInRepository(user);
        String[] groupNames = {"group1","group2"};
        String[][] groupMembers = {{"vivek","kumar"},{"vivek","pooja"}};
        for(int i=0;i<groupNames.length;i++){
            repository.createGroupInRepository(groupNames[i],groupNames[i], Arrays.asList(groupMembers[i].clone()));
        }
        Map<String,Integer> contributors = new HashMap<>();
        contributors.put("vivek",100);
        contributors.put("kumar",200);
        Map<String,Integer> paidBy = new HashMap<>();
        paidBy.put("vivek",300);
        String billId = repository.createBillInRepositoryBill(repository,"group1",300,contributors,paidBy);
        repository.getBill(billId).splitBill();


        contributors.clear();
        paidBy.clear();
        contributors.put("vivek",250);
        contributors.put("kumar",250);
        paidBy.put("kumar",500);
        billId = repository.createBillInRepositoryBill(repository,"group1",500,contributors,paidBy);
        repository.getBill(billId).splitBill();


        contributors.clear();
        paidBy.clear();
        contributors.put("kumar",10);
        contributors.put("pooja",90);
        paidBy.put("pooja",100);
        billId = repository.createBillInRepositoryBill(repository,"group2",100,contributors,paidBy);
        repository.getBill(billId).splitBill();

        contributors.clear();
        paidBy.clear();
        contributors.put("kumar",150);
        contributors.put("pooja",150);
        paidBy.put("kumar",100);
        paidBy.put("pooja",200);
        billId = repository.createBillInRepositoryBill(repository,"group2",300,contributors,paidBy);
        repository.getBill(billId).splitBill();

        for(String user : userNames){
            System.out.println(repository.getUser(user).toString());
        }
    }
}
