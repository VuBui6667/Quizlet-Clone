/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class ListEdit {
    private int studySetId;
    private int userId;
    private int listEditId;

    public ListEdit() {
    }

    public ListEdit(int studySetId, int userId, int listEditId) {
        this.studySetId = studySetId;
        this.userId = userId;
        this.listEditId = listEditId;
    }

    public int getStudySetId() {
        return studySetId;
    }

    public void setStudySetId(int studySetId) {
        this.studySetId = studySetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListEditId() {
        return listEditId;
    }

    public void setListEditId(int listEditId) {
        this.listEditId = listEditId;
    }
    
    
}
