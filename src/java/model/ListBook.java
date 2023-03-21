/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class ListBook {
    private String Isbn;
    private String Title;
    private String Edition;
    private String Authors;
    private String Image;
    private String NumOfAnswers;
    private int CateID;

    public ListBook() {
    }

    public ListBook(String Isbn, String Title, String Edition, String Authors, String Image, String NumOfAnswers, int CateID) {
        this.Isbn = Isbn;
        this.Title = Title;
        this.Edition = Edition;
        this.Authors = Authors;
        this.Image = Image;
        this.NumOfAnswers = NumOfAnswers;
        this.CateID = CateID;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String Edition) {
        this.Edition = Edition;
    }

    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String Authors) {
        this.Authors = Authors;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getNumOfAnswers() {
        return NumOfAnswers;
    }

    public void setNumOfAnswers(String NumOfAnswers) {
        this.NumOfAnswers = NumOfAnswers;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

   
    

}