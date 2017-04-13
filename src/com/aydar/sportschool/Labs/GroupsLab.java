package com.aydar.sportschool.Labs;

import com.aydar.sportschool.Adapters.GroupsAdapter;
import com.aydar.sportschool.Group;

import java.sql.SQLException;
import java.util.List;

public class GroupsLab {
    private static GroupsLab sGroupsLab;

    private List<Group> mGroups;

    public static GroupsLab get() throws SQLException {
        if (sGroupsLab == null) {
            sGroupsLab = new GroupsLab();
        }
        return sGroupsLab;
    }
    private GroupsLab() throws SQLException {
        mGroups = new GroupsAdapter().getGroups();
    }

    public List<Group> getGroups() {
        return mGroups;
    }

    public void addGroup() {

    }


}
