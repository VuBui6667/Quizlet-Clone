/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Class {
    private int id;
    private String name;
    private String desc;
    private boolean isInvite;
    private String inviteCode;
    private boolean isEdit;
    private String schoolName;
    private int userId;

    public Class() {
    }

    public Class(int id, String name, String desc, boolean isInvite, String inviteCode, boolean isEdit, String schoolName, int userId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.isInvite = isInvite;
        this.inviteCode = inviteCode;
        this.isEdit = isEdit;
        this.schoolName = schoolName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isIsInvite() {
        return isInvite;
    }

    public void setIsInvite(boolean isInvite) {
        this.isInvite = isInvite;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
