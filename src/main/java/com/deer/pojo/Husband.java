package com.deer.pojo;

/**
 * @author: 86175
 * @date: 2021/12/2 16:00
 * @description:
 */
public class Husband {

    private Long hid;
    private String hname;
    private String age;
    private String gender;
    private Wife wife;

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", wife=" + wife +
                '}';
    }
}
