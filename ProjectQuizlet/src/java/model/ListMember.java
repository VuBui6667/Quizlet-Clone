/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class ListMember {
    private int classId;
    private int userId;
    private int listMemberId;

    public ListMember() {
    }

    public ListMember(int classId, int userId, int listMemberId) {
        this.classId = classId;
        this.userId = userId;
        this.listMemberId = listMemberId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListMemberId() {
        return listMemberId;
    }

    public void setListMemberId(int listMemberId) {
        this.listMemberId = listMemberId;
    }
    
    
    
    
}
