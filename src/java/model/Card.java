/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Card {
    private int id;
    private String term;
    private String definition;
    private int studySetId;

    public Card() {
    }

    public Card(int id, String term, String definition, int studySetId) {
        this.id = id;
        this.term = term;
        this.definition = definition;
        this.studySetId = studySetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getStudySetId() {
        return studySetId;
    }

    public void setStudySetId(int studySetId) {
        this.studySetId = studySetId;
    }
}
