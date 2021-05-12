package com.aabhishekpatel.adminjaganjameen_1.Model;

public class Land {
    private String landid;
    private String landname;
    private String landprice;
    private String landimage1;
    private String landphone;

    public Land() {
    }

    public Land(String landid ,String landname, String landprice, String landimage1, String landphone) {
        this.landid = landid;
        this.landname = landname;
        this.landprice = landprice;
        this.landimage1 = landimage1;
        this.landphone = landphone;
    }

    public String getLandid() {
        return landid;
    }

    public void setLandid(String landid) {
        this.landid = landid;
    }

    public String getLandname() {
        return landname;
    }

    public void setLandname(String landname) {
        this.landname = landname;
    }

    public String getLandprice() {
        return landprice;
    }

    public void setLandprice(String landprice) {
        this.landprice = landprice;
    }

    public String getLandimage1() {
        return landimage1;
    }

    public void setLandimage1(String landimage1) {
        this.landimage1 = landimage1;
    }

    public String getLandphone() {
        return landphone;
    }

    public void setLandphone(String landphone) {
        this.landphone = landphone;
    }
}
