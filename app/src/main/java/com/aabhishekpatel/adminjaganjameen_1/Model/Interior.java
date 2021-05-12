package com.aabhishekpatel.adminjaganjameen_1.Model;

public class Interior {

    private String interiorid;
    private String interiorname;
    private String interiorprice;
    private String interiorimage1;
    private String interiorphone;

    public Interior() {
    }

    public Interior(String interiorid,String interiorname, String interiorprice, String interiorimage1, String interiorphone) {
        this.interiorid = interiorid;
        this.interiorname = interiorname;
        this.interiorprice = interiorprice;
        this.interiorimage1 = interiorimage1;
        this.interiorphone = interiorphone;
    }

    public String getInteriorid() {
        return interiorid;
    }

    public void setInteriorid(String interiorid) {
        this.interiorid = interiorid;
    }

    public String getInteriorname() {
        return interiorname;
    }

    public void setInteriorname(String interiorname) {
        this.interiorname = interiorname;
    }

    public String getInteriorprice() {
        return interiorprice;
    }

    public void setInteriorprice(String interiorprice) {
        this.interiorprice = interiorprice;
    }

    public String getInteriorimage1() {
        return interiorimage1;
    }

    public void setInteriorimage1(String interiorimage1) {
        this.interiorimage1 = interiorimage1;
    }

    public String getInteriorphone() {
        return interiorphone;
    }

    public void setInteriorphone(String interiorphone) {
        this.interiorphone = interiorphone;
    }
}
