package com.aydar.sportschool.Labs;

import com.aydar.sportschool.Fetchers.GroupsFetcher;
import com.aydar.sportschool.Fetchers.PupilsFetcher;
import com.aydar.sportschool.Group;
import com.aydar.sportschool.Pupil;

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
        mGroups = new GroupsFetcher().getGroups();
    }

    public List<Group> getGroups() {
        return mGroups;
    }


}
