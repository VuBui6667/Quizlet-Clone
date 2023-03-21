/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class Chapter {
    private int ChapterID;
    private String ChapterName;
    private String Isbn;

    public Chapter() {
    }

    public Chapter(int ChapterID, String ChapterName, String Isbn) {
        this.ChapterID = ChapterID;
        this.ChapterName = ChapterName;
        this.Isbn = Isbn;
    }

    public int getChapterID() {
        return ChapterID;
    }

    public void setChapterID(int ChapterID) {
        this.ChapterID = ChapterID;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String ChapterName) {
        this.ChapterName = ChapterName;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }
    
}
