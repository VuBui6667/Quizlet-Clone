/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Book {
    private String isbn;
    private String title;
    private String edition;
    private String authors;
    private String image;
    private String numOfAnswers;
    private int cateId;

    public Book() {
    }

    public Book(String isbn, String title, String edition, String authors, String image, String numOfAnswers, int cateId) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.authors = authors;
        this.image = image;
        this.numOfAnswers = numOfAnswers;
        this.cateId = cateId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumOfAnswers() {
        return numOfAnswers;
    }

    public void setNumOfAnswers(String numOfAnswers) {
        this.numOfAnswers = numOfAnswers;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
    
    
}
