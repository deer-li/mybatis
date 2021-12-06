package com.deer.pojo;

/**
 * @author: 86175
 * @date: 2021/12/2 16:01
 * @description:
 */
public class Wife {
    private Long wid;
    private String wname;
    private String age;
    private String gender;
    private Long hid;

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
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

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", hid=" + hid +
                '}';
    }
}
