package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String name;
    List<String> members = new ArrayList<>();


    public Group(String groupId,String name,List<String> members){
        this.groupId=groupId;
        this.name=name;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
