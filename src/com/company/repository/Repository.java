package com.company.repository;

import com.company.model.Bill;
import com.company.model.User;

import java.util.List;
import java.util.Map;

public interface Repository {
    User getUser(String userId);
    Bill getBill(String billId);
    String createUserInRepository(String name);
    String createGroupInRepository(String groupId, String name, List<String> members);
    String createBillInRepositoryBill(Repository repository, String groupId,
                                    int totalAmount, Map<String,Integer> contributors, Map<String,Integer> paidBy);
}
