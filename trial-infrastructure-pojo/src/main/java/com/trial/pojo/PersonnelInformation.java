package com.trial.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 人员信息类
 * @date: 2020/7/15 10:07
 * @author: luoziwen
 */
public class PersonnelInformation implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private Integer tall;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getTall() {
        return tall;
    }

    public void setTall(Integer tall) {
        this.tall = tall;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PersonnelInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", tall=" + tall +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
