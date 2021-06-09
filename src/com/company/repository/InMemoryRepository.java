package com.company.repository;

import com.company.model.Bill;
import com.company.model.Group;
import com.company.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository{
    private Map<String,User> userMap = new HashMap<>();
    private Map<String, Bill> billMap = new HashMap<>();
    private Map<String, Group> groupMap = new HashMap<>();

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    @Override
    public Bill getBill(String billId) {
        return billMap.get(billId);
    }

    @Override
    public String createUserInRepository(String name) {
        User user = new User(name);
        userMap.put(user.getUserId(), user);
        return user.getUserId();
    }

    @Override
    public String createGroupInRepository(String groupId, String name, List<String> members) {
        Group group = new Group(groupId,name,members);
        groupMap.put(group.getGroupId(),group);
        return group.getGroupId();
    }

    @Override
    public String createBillInRepositoryBill(Repository repository, String groupId, int totalAmount, Map<String, Integer> contributors, Map<String, Integer> paidBy) {
        Bill bill = new Bill(repository,groupId,totalAmount,contributors,paidBy);
        billMap.put(bill.getBillId(),bill);

        return bill.getBillId();
    }

}
