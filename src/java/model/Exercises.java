/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class Exercises {
    private int ExID;
    private String ExName;
    private String Answers;
    private int PageID;

    public Exercises() {
    }

    public Exercises(int ExID, String ExName, String Answers, int PageID) {
        this.ExID = ExID;
        this.ExName = ExName;
        this.Answers = Answers;
        this.PageID = PageID;
    }

    public int getExID() {
        return ExID;
    }

    public void setExID(int ExID) {
        this.ExID = ExID;
    }

    public String getExName() {
        return ExName;
    }

    public void setExName(String ExName) {
        this.ExName = ExName;
    }

    public String getAnswers() {
        return Answers;
    }

    public void setAnswers(String Answers) {
        this.Answers = Answers;
    }

    public int getPageID() {
        return PageID;
    }

    public void setPageID(int PageID) {
        this.PageID = PageID;
    }
    
}
