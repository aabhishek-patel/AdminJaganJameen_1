package com.aabhishekpatel.adminjaganjameen_1.Model;

public class Houses {

    private String houseid;
    private String housename;
    private String houseprice;
    private String houseimage1;
    private String housesphone;

    public Houses(String houseid, String housename, String houseprice, String houseimage1, String housesphone) {
        this.houseid = houseid;
        this.housename = housename;
        this.houseprice = houseprice;
        this.houseimage1 = houseimage1;
        this.housesphone = housesphone;
    }

    public Houses() {
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getHouseprice() {
        return houseprice;
    }

    public void setHouseprice(String houseprice) {
        this.houseprice = houseprice;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getHouseimage1() {
        return houseimage1;
    }

    public void setHouseimage1(String houseimage1) {
        this.houseimage1 = houseimage1;
    }

    public String getHousesphone() {
        return housesphone;
    }

    public void setHousesphone(String housesphone) {
        this.housesphone = housesphone;
    }
}
