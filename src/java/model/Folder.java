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
public class Folder {

    private int id;
    private String title;
    private String desc;
    private int userId;
    private boolean isShare;

    public Folder() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIsShare() {
        return isShare;
    }

    public void setIsShare(boolean isShare) {
        this.isShare = isShare;
    }

    public Folder(int id, String title, String desc, int userId, boolean isShare) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.userId = userId;
        this.isShare = isShare;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumberStudySet() {
        DAO d = new DAO();
        ArrayList<Integer> listS = d.getStudySetIdByFolderId(id);
        return listS.size();
    }

}
