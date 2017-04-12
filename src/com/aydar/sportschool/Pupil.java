package com.aydar.sportschool;

public class Pupil {
    private int mId;
    private String mName;
    private String mBirthday;
    private Group mGroup;
    private SportsCategory mSportsCategory;
    private String mRewards;
    private String mPhone;
    private String mAddress;

    public Pupil(int id, String name, String birthday, Group group, SportsCategory sportsCategory, String rewards, String phone, String address) {
        mId = id;
        mName = name;
        mBirthday = birthday;
        mGroup = group;
        mSportsCategory = sportsCategory;
        mRewards = rewards;
        mPhone = phone;
        mAddress = address;
    }

    public int getId() {

        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public Group getGroup() {
        return mGroup;
    }

    public SportsCategory getSportsCategory() {
        return mSportsCategory;
    }

    public String getRewards() {
        return mRewards;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAddress() {
        return mAddress;
    }
}
