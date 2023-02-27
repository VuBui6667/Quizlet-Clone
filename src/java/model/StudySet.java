/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DAO;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class StudySet {
    private int id;
    private String title;
    private String description;
    private boolean isShare;
    private int userId;


    public StudySet() {
    }

    public StudySet(int id, String title, String description, boolean isShare, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isShare = isShare;
        this.userId = userId;  }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsShare() {
        return isShare;
    }

    public void setIsShare(boolean isShare) {
        this.isShare = isShare;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getNumberCard() {
        DAO d = new DAO();
        ArrayList<Card> listC = d.getAllCardInSet(id);
        return listC.size();
    }
    
    public String getAuthor() {
        DAO d = new DAO();
        User user = d.getUserByUserId(userId);
        String name = user.getName();
        return name;
    }
}
