/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class Page {
    private int PageID;
    private String PageName;
    private int ChapterID;

    public Page() {
    }

    public Page(int PageID, String PageName, int ChapterID) {
        this.PageID = PageID;
        this.PageName = PageName;
        this.ChapterID = ChapterID;
    }

    public int getPageID() {
        return PageID;
    }

    public void setPageID(int PageID) {
        this.PageID = PageID;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String PageName) {
        this.PageName = PageName;
    }

    public int getChapterID() {
        return ChapterID;
    }

    public void setChapterID(int ChapterID) {
        this.ChapterID = ChapterID;
    }
    
    
}
