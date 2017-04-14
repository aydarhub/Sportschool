package com.aydar.sportschool;

public class Trainer {
    private int mId;
    private String mName;
    private String mBirthday;
    private KindOfSport mKindOfSport;
    private SportsCategory mSportsCategory;
    private String mPhone;
    private String mAddress;

    public Trainer(int id, String name, String birthday, KindOfSport kindOfSport, SportsCategory sportsCategory, String phone, String address) {
        mId = id;
        mName = name;
        mBirthday = birthday;
        mKindOfSport = kindOfSport;
        mSportsCategory = sportsCategory;
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

    public KindOfSport getKindOfSport() {
        return mKindOfSport;
    }

    public SportsCategory getSportsCategory() {
        return mSportsCategory;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAddress() {
        return mAddress;
    }
}
