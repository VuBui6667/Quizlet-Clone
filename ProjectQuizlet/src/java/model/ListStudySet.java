/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class ListStudySet {
    private int classId;
    private int studySetId;
    private int listStudySetId;

    public ListStudySet() {
    }

    public ListStudySet(int classId, int studySetId, int listStudySetId) {
        this.classId = classId;
        this.studySetId = studySetId;
        this.listStudySetId = listStudySetId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudySetId() {
        return studySetId;
    }

    public void setStudySetId(int studySetId) {
        this.studySetId = studySetId;
    }

    public int getListStudySetId() {
        return listStudySetId;
    }

    public void setListStudySetId(int listStudySetId) {
        this.listStudySetId = listStudySetId;
    }
    
    
}
