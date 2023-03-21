/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class Answer {
    private int AnswerID;
    private String Answer;
    private int ExID;

    public Answer() {
    }

    public Answer(int AnswerID, String Answer, int ExID) {
        this.AnswerID = AnswerID;
        this.Answer = Answer;
        this.ExID = ExID;
    }

    public int getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(int AnswerID) {
        this.AnswerID = AnswerID;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public int getExID() {
        return ExID;
    }

    public void setExID(int ExID) {
        this.ExID = ExID;
    }
    
}
