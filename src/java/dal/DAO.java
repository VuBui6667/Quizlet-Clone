/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Card;
import model.Folder;
import model.StudySet;
import model.User;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBContext {

    public ArrayList<User> getAllUser() {
        ArrayList<User> listU = new ArrayList<>();
        String sql = "select * from [User]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("name"), rs.getString("password"), rs.getString("gmail"),
                        rs.getBoolean("isActive"), rs.getString("avatar"), rs.getInt("userId"), rs.getString("language"));
                listU.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listU;
    }

    public ArrayList<Folder> getAllFolder() {
        ArrayList<Folder> listF = new ArrayList<>();
        String sql = "select * from [Folder] ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                 Folder f = new Folder(
                         rs.getInt("folderId"),
                         rs.getString("title"),
                         rs.getString("description"),
                         rs.getInt("userId"),
                         rs.getBoolean("isShare"));
                 listF.add(f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listF;
    }

    public User checkUser(String username, String password) {
        ArrayList<User> listU = getAllUser();
        for (User u : listU) {
            if ((u.getName().equals(username) || u.getEmail().equals(username)) && u.getPass().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void register(User user) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([name]\n"
                + "           ,[password]\n"
                + "           ,[gmail]\n"
                + "           ,[isActive]\n"
                + "           ,[avatar]\n"
                + "           ,[language])\n"
                + "     VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getName());
            st.setString(2, user.getPass());
            st.setString(3, user.getEmail());
            st.setBoolean(4, user.isIsActive());
            st.setString(5, user.getAvatar());
            st.setString(6, user.getLanguage());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createFolder(Folder folder) {
        String sql = "INSERT INTO [dbo].[Folder]\n"
                + "           ([title]\n"
                + "           ,[description]\n"
                + "           ,[userId]\n"
                + "           ,[isShare])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, folder.getTitle());
            st.setString(2, folder.getDesc());
            st.setInt(3, folder.getUserId());
            st.setBoolean(4, folder.isIsShare());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getIdStudySet() {
        int idx = 0;
        String sql = "SELECT TOP 1 * FROM StudySet ORDER BY studySetId DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("studySetId");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return idx;
    }

    public boolean activeAccount(String email) {
        boolean check = false;
        String sql = "update [User] set isActive = 1 where gmail like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.execute();
            check = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }

    public void addStudySet(StudySet set) {
        String sql = "INSERT INTO [dbo].[StudySet]\n"
                + "           ([title]\n"
                + "           ,[description]\n"
                + "           ,[isShare]\n"
                + "           ,[folderId]\n"
                + "           ,[userId]\n"
                + "           ,[classId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, set.getTitle());
            st.setString(2, set.getDescription());
            st.setBoolean(3, true);
            st.setInt(4, set.getFolderId());
            st.setInt(5, set.getUserId());
            st.setInt(6, set.getClassId());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCard(Card c) {
        String sql = "INSERT INTO [dbo].[Card]\n"
                + "           ([term]\n"
                + "           ,[definition]\n"
                + "           ,[studySetId])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getTerm());
            st.setString(2, c.getDefinition());
            st.setInt(3, c.getStudySetId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<StudySet> getAllStudySet(User user) {
        ArrayList<StudySet> listS = new ArrayList<>();
        String sql = "SELECT [studySetId]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[isShare]\n"
                + "      ,[folderId]\n"
                + "      ,[userId]\n"
                + "      ,[classId]\n"
                + "  FROM [dbo].[StudySet]\n"
                + "  WHERE userId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudySet set = new StudySet();
                set.setId(rs.getInt("studySetId"));
                set.setTitle(rs.getString("title"));
                set.setDescription(rs.getString("description"));
                set.setIsShare(rs.getBoolean("isShare"));
                set.setFolderId(rs.getInt("folderId"));
                set.setUserId(rs.getInt("userId"));
                set.setUserId(rs.getInt("classId"));
                listS.add(set);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listS;
    }

    public StudySet getStudySetById(int id) {
        ArrayList<StudySet> listS = new ArrayList<>();
        String sql = "SELECT [studySetId]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[isShare]\n"
                + "      ,[folderId]\n"
                + "      ,[userId]\n"
                + "      ,[classId]\n"
                + "  FROM [dbo].[StudySet]\n"
                + "  WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudySet set = new StudySet();
                set.setId(rs.getInt("studySetId"));
                set.setTitle(rs.getString("title"));
                set.setDescription(rs.getString("description"));
                set.setIsShare(rs.getBoolean("isShare"));
                set.setFolderId(rs.getInt("folderID"));
                set.setUserId(rs.getInt("userID"));
                return set;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Card> getAllCardInSet(int id) {
        ArrayList<Card> listC = new ArrayList<>();
        String sql = "SELECT [cardId]\n"
                + "      ,[term]\n"
                + "      ,[definition]\n"
                + "      ,[studySetId]\n"
                + "  FROM [dbo].[Card]\n"
                + "  WHERE studySetID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Card c = new Card();
                c.setId(rs.getInt("cardID"));
                c.setTerm(rs.getString("term"));
                c.setDefinition(rs.getString("definition"));
                c.setStudySetId(rs.getInt("studySetId"));
                listC.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listC;
    }

    public User getUserByUserId(int userId) {
        ArrayList<User> listU = getAllUser();
        for (User u : listU) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }

    public void deleteStudySet(int id) {
        String sql = "DELETE FROM [dbo].[StudySet]\n"
                + "      WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAllCard(int studySetId) {
        String sql = "DELETE FROM [dbo].[Card]\n"
                + "      WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudySet(StudySet set) {
        String sql = "UPDATE [dbo].[StudySet]\n"
                + "   SET [title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[isShare] = ?\n"
                + "      ,[folderId] = ?\n"
                + "      ,[userId] = ?\n"
                + "      ,[classId] = ?\n"
                + " WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, set.getTitle());
            st.setString(2, set.getDescription());
            st.setBoolean(3, set.isIsShare());
            st.setInt(4, set.getFolderId());
            st.setInt(5, set.getUserId());
            st.setInt(6, set.getClassId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCard(Card c) {
        String sql = "UPDATE [dbo].[Card]\n"
                + "   SET [term] = ?\n"
                + "      ,[definition] = ?\n"
                + "      ,[studySetId] = ?\n"
                + " WHERE cardId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getTerm());
            st.setString(2, c.getDefinition());
            st.setInt(3, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<StudySet> getAllStudySet() {
        ArrayList<StudySet> listS = new ArrayList<>();
        String sql = "Select * from StudySet";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudySet set = new StudySet(
                        rs.getInt("studySetId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getBoolean("isShare"),
                        rs.getInt("folderId"),
                        rs.getInt("userId"),
                        rs.getInt("classId"));
                listS.add(set);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listS;
    }
    public static void main(String[] args) {
        DAO d = new DAO();
        ArrayList<Folder> s = d.getAllFolder();
        System.out.println(s.get(0).getTitle());
        
    }
}
