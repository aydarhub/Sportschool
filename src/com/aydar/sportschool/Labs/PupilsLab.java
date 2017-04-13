package com.aydar.sportschool.Labs;

import com.aydar.sportschool.Adapters.PupilsAdapter;
import com.aydar.sportschool.Pupil;
import com.sun.istack.internal.Nullable;

import java.sql.SQLException;
import java.util.List;

public class PupilsLab {
    private static PupilsLab sPupilsLab;
    private static PupilsAdapter sPupilsAdapter;

    private List<Pupil> mPupils;

    public static PupilsLab get() throws SQLException {
        if (sPupilsLab == null) {
            sPupilsLab = new PupilsLab();
        }
        return sPupilsLab;
    }
    private PupilsLab() throws SQLException {
        if (sPupilsAdapter == null) {
            sPupilsAdapter = new PupilsAdapter();
        }
        mPupils = sPupilsAdapter.getPupils();
    }

    public List<Pupil> getPupils() {
        return mPupils;
    }

    public void addPupil(String name, String birthday, int groupId, @Nullable String phone, @Nullable String address, @Nullable int sportsCategoryId, @Nullable String rewards) throws SQLException {
        sPupilsAdapter.addPupil(name, birthday, groupId, phone, address, sportsCategoryId, rewards);
    }
}
