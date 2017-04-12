package com.aydar.sportschool.Labs;

import com.aydar.sportschool.Fetchers.PupilsFetcher;
import com.aydar.sportschool.Pupil;

import java.sql.SQLException;
import java.util.List;

public class PupilsLab {
    private static PupilsLab sPupilsLab;

    private List<Pupil> mPupils;

    public static PupilsLab get() throws SQLException {
        if (sPupilsLab == null) {
            sPupilsLab = new PupilsLab();
        }
        return sPupilsLab;
    }
    private PupilsLab() throws SQLException {
        mPupils = new PupilsFetcher().getPupils();
    }

    public List<Pupil> getPupils() {
        return mPupils;
    }


}
