/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class ListFolder {
    private int studySetId;
    private int folderId;
    private int listFolderId;

    public ListFolder() {
    }

    public ListFolder(int studySetId, int folderId, int listFolderId) {
        this.studySetId = studySetId;
        this.folderId = folderId;
        this.listFolderId = listFolderId;
    }

    public int getStudySetId() {
        return studySetId;
    }

    public void setStudySetId(int studySetId) {
        this.studySetId = studySetId;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public int getListFolderId() {
        return listFolderId;
    }

    public void setListFolderId(int listFolderId) {
        this.listFolderId = listFolderId;
    }
    
    
}
