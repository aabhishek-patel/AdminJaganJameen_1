package com.aabhishekpatel.adminjaganjameen_1.Model;

public class Ads {
    private String cxid;
    private String cxname;
    private String cxemail;
    private String cxphone;
    private String cxhouse;
    private String cxaddress;
    private String cxdistrict;
    private String cxstate;
    private String cxpincode;
    private String cxcomments;

    public Ads(String cxid, String cxname, String cxemail, String cxphone, String cxhouse, String cxaddress, String cxdistrict, String cxstate, String cxpincode, String cxcomments) {
        this.cxid = cxid;
        this.cxname = cxname;
        this.cxemail = cxemail;
        this.cxphone = cxphone;
        this.cxhouse = cxhouse;
        this.cxaddress = cxaddress;
        this.cxdistrict = cxdistrict;
        this.cxstate = cxstate;
        this.cxpincode = cxpincode;
        this.cxcomments = cxcomments;
    }

    public Ads() {
    }

    public String getCxid() {
        return cxid;
    }

    public void setCxid(String cxid) {
        this.cxid = cxid;
    }

    public String getCxname() {
        return cxname;
    }

    public void setCxname(String cxname) {
        this.cxname = cxname;
    }

    public String getCxemail() {
        return cxemail;
    }

    public void setCxemail(String cxemail) {
        this.cxemail = cxemail;
    }

    public String getCxphone() {
        return cxphone;
    }

    public void setCxphone(String cxphone) {
        this.cxphone = cxphone;
    }

    public String getCxhouse() {
        return cxhouse;
    }

    public void setCxhouse(String cxhouse) {
        this.cxhouse = cxhouse;
    }

    public String getCxaddress() {
        return cxaddress;
    }

    public void setCxaddress(String cxaddress) {
        this.cxaddress = cxaddress;
    }

    public String getCxdistrict() {
        return cxdistrict;
    }

    public void setCxdistrict(String cxdistrict) {
        this.cxdistrict = cxdistrict;
    }

    public String getCxstate() {
        return cxstate;
    }

    public void setCxstate(String cxstate) {
        this.cxstate = cxstate;
    }

    public String getCxpincode() {
        return cxpincode;
    }

    public void setCxpincode(String cxpincode) {
        this.cxpincode = cxpincode;
    }

    public String getCxcomments() {
        return cxcomments;
    }

    public void setCxcomments(String cxcomments) {
        this.cxcomments = cxcomments;
    }
}