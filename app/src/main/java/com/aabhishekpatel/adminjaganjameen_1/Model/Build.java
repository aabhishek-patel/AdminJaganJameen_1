package com.aabhishekpatel.adminjaganjameen_1.Model;

public class Build {

    private String buildid;
    private String buildname;
    private String buildrice;
    private String buildimage1;
    private String buildphone;

    public Build() {
    }

    public Build(String buildid, String buildname, String buildrice, String buildimage1 , String buildphone) {
        this.buildid = buildid;
        this.buildname = buildname;
        this.buildrice = buildrice;
        this.buildimage1 = buildimage1;
        this.buildphone = buildphone;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getBuildrice() {
        return buildrice;
    }

    public void setBuildrice(String buildrice) {
        this.buildrice = buildrice;
    }

    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid;
    }

    public String getBuildimage1() {
        return buildimage1;
    }

    public void setBuildimage1(String buildimage1) {
        this.buildimage1 = buildimage1;
    }

    public String getBuildphone() {
        return buildphone;
    }

    public void setBuildphone(String buildphone) {
        this.buildphone = buildphone;
    }
}
