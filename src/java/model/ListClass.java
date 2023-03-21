/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vieta
 */
public class ListClass {
     private int classId;
    private int folderId;
    private int listClassId;

    public ListClass(int classId, int folderId, int listClassId) {
        this.classId = classId;
        this.folderId = folderId;
        this.listClassId = listClassId;
    }

    public int getClassId() {
        return classId;
    }

    public int getFolderId() {
        return folderId;
    }

    public int getListClassId() {
        return listClassId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public void setListClassId(int listClassId) {
        this.listClassId = listClassId;
    }
    
    
}
