/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import controller.ClassSet;
import controller.FolderSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Card;
import model.Folder;
import model.ListFolder;
import model.StudySet;
import model.User;
import model.Class;
import model.ListMember;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBContext {

    public void addStudiedCard(int userId, int cardId, int studySetId) {
        String sql = "INSERT INTO [dbo].[FlashCards]\n"
                + "           ([userId]\n"
                + "           ,[cardId]\n"
                + "           ,[studySetId])\n"
                + "     VALUES(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, cardId);
            st.setInt(3, studySetId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void resetStudiedCard(int userId, int studySetId) {
        String sql = "DELETE FROM [dbo].[FlashCards]\n"
                + "      WHERE userId=? and studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, studySetId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Integer> getListStudiedCardId(int studySetId, int userId) {
        String sql = "SELECT [userId]\n"
                + "      ,[cardId]\n"
                + "  FROM [dbo].[FlashCards]"
                + "  WHERE studySetId = ? and userId = ?";
        ArrayList<Integer> listId = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.setInt(2, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listId.add(rs.getInt("cardId"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listId;
    }

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
        } catch (SQLException e) {
            System.out.println(e);
        }

        return listU;
    }

    public ArrayList<model.Class> getAllClass() {
        ArrayList<model.Class> listC = new ArrayList<>();
        String sql = "select * from [Class] ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = new model.Class(
                        rs.getInt("classId"),
                        rs.getString("className"),
                        rs.getString("description"),
                        rs.getBoolean("isInvite"),
                        rs.getString("inviteCode"),
                        rs.getBoolean("isEdit"),
                        rs.getString("schoolName"),
                        rs.getInt("userId"));
                listC.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listC;
    }

    public void createClass(model.Class c) {
        String sql = "INSERT INTO [dbo].[Class]\n"
                + "           ([className]\n"
                + "           ,[description]\n"
                + "           ,[isInvite]\n"
                + "           ,[inviteCode]\n"
                + "           ,[isEdit]\n"
                + "           ,[schoolName]\n"
                + "           ,[userId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,? \n"
                + "		   ,?           \n"
                + "		   ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDesc());
            st.setBoolean(3, c.isIsInvite());
            st.setString(4, c.getInviteCode());
            st.setBoolean(5, c.isIsEdit());
            st.setString(6, c.getSchoolName());
            st.setInt(7, c.getUserId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public model.Class getClassByClassId(int classId) {
        String sql = "select*from [Class] where classId=?";
        model.Class c = new model.Class();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c = new model.Class(
                        rs.getInt("classId"),
                        rs.getString("className"),
                        rs.getString("description"),
                        rs.getBoolean("isInvite"),
                        rs.getString("inviteCode"),
                        rs.getBoolean("isEdit"),
                        rs.getString("schoolName"),
                        rs.getInt("userId")
                );
            }
            return c;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public model.Class getClassById(int id) {
        ArrayList<model.Class> listC = new ArrayList<>();
        String sql = "SELECT [classId]\n"
                + "      ,[className]\n"
                + "      ,[description]\n"
                + "      ,[isInvite]\n"
                + "      ,[inviteCode]\n"
                + "      ,[isEdit]\n"
                + "      ,[schoolName]\n"
                + "      ,[userId]\n"
                + "  FROM [dbo].[Class]\n"
                + "  WHERE classId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = new model.Class();
                c.setId(rs.getInt("classId"));
                c.setName(rs.getString("className"));
                c.setDesc(rs.getString("description"));
                c.setIsInvite(rs.getBoolean("isInvite"));
                c.setInviteCode(rs.getString("inviteCode"));
                c.setIsEdit(rs.getBoolean("isEdit"));
                c.setSchoolName(rs.getString("schoolName"));
                c.setUserId(rs.getInt("userId"));
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean isAddedInClass(int classId, int studySetId) {
        ArrayList<Integer> listSSId = getStudySetIdByClassId(classId);
        for (Integer n : listSSId) {
            if (studySetId == n) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddedFolderInClass(int classId, int folderId) {
        ArrayList<Folder> listF = getListFolderByClassId(classId);
        for (Folder f : listF) {
            if (f.getId() == folderId) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Folder> getListFolderByClassId(int classId) {
        ArrayList<Folder> listF = new ArrayList<>();
        String sql = "select folderId from [ListClass] where classId =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listF.add(getFolderByFolderId(rs.getInt("folderId")));
            }
            return listF;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Integer> getStudySetIdByClassId(int classId) {
        ArrayList<Integer> listSSId = new ArrayList<>();
        String sql = "select studySetId from [ListStudySet] where classId =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listSSId.add(rs.getInt("studySetId"));
            }
            return listSSId;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Folder> getAllFolderByUserId(int userId) {
        ArrayList<Folder> listF = new ArrayList<>();
        String sql = "select * from [Folder]where userId=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
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
        } catch (SQLException e) {
            System.out.println(e);
        }

        return listF;
    }

    public ArrayList<Integer> getStudySetIdByFolderId(int folderId) {
        ArrayList<Integer> listSSId = new ArrayList<>();
        String sql = "select studySetId from [ListFolder] where folderId =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listSSId.add(rs.getInt("studySetId"));
            }
            return listSSId;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<StudySet> getListStudySetByClassId(int classId) {
        ArrayList<Integer> listSSId = getStudySetIdByClassId(classId);
        ArrayList<StudySet> listSS = new ArrayList<>();
        for (Integer n : listSSId) {
            listSS.add(getStudySetById(n));
        }
        return listSS;
    }

    public ArrayList<StudySet> getListStudySet(int folderId) {
        ArrayList<Integer> listSSId = getStudySetIdByFolderId(folderId);
        ArrayList<StudySet> listSS = new ArrayList<>();
        for (Integer n : listSSId) {
            listSS.add(getStudySetById(n));
        }
        return listSS;
    }

    public boolean isAddedInFolder(int folderId, int studySetId) {
        ArrayList<Integer> listSSId = getStudySetIdByFolderId(folderId);
        for (Integer n : listSSId) {
            if (studySetId == n) {
                return true;
            }
        }
        return false;
    }

    public void removeListClass(int classId) {
        String sql = "DELETE FROM [dbo].[ListClass]\n"
                + "      WHERE classId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteClassByClassId(int classId) {
        String sql = "DELETE FROM [dbo].[Class]\n"
                + "      WHERE classId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeListFolder(int folderId) {
        String sql = "DELETE FROM [dbo].[ListFolder]\n"
                + "      WHERE folderId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteFolderByFolderId(int folderId) {
        String sql = "DELETE FROM [dbo].[Folder]\n"
                + "      WHERE folderId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Folder getFolderByFolderId(int folderId) {
        String sql = "select * from [Folder] where folderId =? ";
        Folder f = new Folder();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                f = new Folder(
                        rs.getInt("folderId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("userId"),
                        rs.getBoolean("isShare"));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
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

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createListFolder(ListFolder lf) {
        String sql = "INSERT INTO [dbo].[ListFolder]\n"
                + "           ([studySetId]\n"
                + "           ,[folderId])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, lf.getStudySetId());
            st.setInt(2, lf.getFolderId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteInListFolder(int studySetId) {
        String sql = "DELETE FROM [dbo].[ListFolder]\n"
                + "      WHERE studySetId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.executeUpdate();
        } catch (SQLException e) {
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

        } catch (SQLException e) {
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public void addStudySet(StudySet set) {
        String sql = "INSERT INTO [dbo].[StudySet]\n"
                + "           ([title]\n"
                + "           ,[description]\n"
                + "           ,[isShare]\n"
                + "           ,[userId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, set.getTitle());
            st.setString(2, set.getDescription());
            st.setBoolean(3, set.isIsShare());
            st.setInt(4, set.getUserId());
            st.executeUpdate();

        } catch (SQLException e) {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<StudySet> getAllStudySet(User user) {
        ArrayList<StudySet> listS = new ArrayList<>();
        String sql = "SELECT [studySetId]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[isShare]\n"
                + "      ,[userId]\n"
                + "  FROM [dbo].[StudySet]"
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
                set.setUserId(rs.getInt("userId"));
                listS.add(set);
            }
        } catch (SQLException e) {
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
                + "      ,[userId]\n"
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
                set.setUserId(rs.getInt("userID"));
                return set;
            }
        } catch (SQLException e) {
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
        } catch (SQLException e) {
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

    public void deleteFolderInClass(int classId, int folderId) {
        String sql = "DELETE FROM [dbo].[ListClass]\n"
                + "      WHERE folderId=? and classId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            st.setInt(2, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStudySetInClass(int classId, int studySetId) {
        String sql = "DELETE FROM [dbo].[ListStudySet]\n"
                + "      WHERE studySetId=? and classId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.setInt(2, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addFolderInClass(int classId, int folderId) {
        String sql = "INSERT INTO [dbo].[ListClass]\n"
                + "           ([folderId]\n"
                + "           ,[classId])\n"
                + "     VALUES (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, folderId);
            st.setInt(2, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addStudySetInClass(int classId, int studySetId) {
        String sql = "INSERT INTO [dbo].[ListStudySet]\n"
                + "           ([studySetId]\n"
                + "           ,[classId])\n"
                + "     VALUES (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.setInt(2, classId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStudySetInFolder(int folderId, int studySetId) {
        String sql = "DELETE FROM [dbo].[ListFolder]\n"
                + "      WHERE studySetId=? and folderId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.setInt(2, folderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addStudySetInFolder(int folderId, int studySetId) {
        String sql = "INSERT INTO [dbo].[ListFolder]\n"
                + "           ([studySetId]\n"
                + "           ,[folderId])\n"
                + "     VALUES (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studySetId);
            st.setInt(2, folderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStudySet(int id) {
        String sql = "DELETE FROM [dbo].[StudySet]\n"
                + "      WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Integer getUserIdByNameOrEmail(String name) {
        String sql = "SELECT [userId]\n"
                + "From [dbo].[User] \n"
                + "Where name=? or gmail=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("userId");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addMember(int userId, int classId) {
        System.out.println("classID: " + classId);
        String sql = "INSERT INTO [dbo].[ListMember]\n"
                + "           ([classId]\n"
                + "           ,[userId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, classId);
            st.setInt(2, userId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateClass(Class cl) {
        String sql = "UPDATE [dbo].[Class]\n"
                + "   SET [className] = ?\n"
                + "      ,[description] = ?\n"
                //                + "      ,[isInvite] = ?\n"
                //                + "      ,[inviteCode] = ?\n"
                //                + "      ,[isEdit] = ?\n"
                + "      ,[schoolName] = ?\n"
                //                + "      ,[userId] = ?\n"
                + " WHERE classId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cl.getName());
            st.setString(2, cl.getDesc());
//            st.setBoolean(3, cl.isIsInvite());
//            st.setString(4, cl.getInviteCode());
//            st.setBoolean(5, cl.isIsEdit());
            st.setString(3, cl.getSchoolName());
//            st.setInt(7, cl.getUserId());
            st.setInt(4, cl.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudySet(StudySet set) {
        String sql = "UPDATE [dbo].[StudySet]\n"
                + "   SET [title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[isShare] = ?\n"
                + " WHERE studySetId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, set.getTitle());
            st.setString(2, set.getDescription());
            st.setBoolean(3, set.isIsShare());
            st.setInt(4, set.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCard(Card c) {
        String sql = "UPDATE [dbo].[Card]\n"
                + "   SET [term] = ?\n"
                + "      ,[definition] = ?\n"
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

    public ArrayList<Folder> getAllFolder() {
        ArrayList<Folder> listFS = new ArrayList<>();
        String sql = "Select * from Folder";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Folder set = new Folder(
                        rs.getInt("folderId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("userId"),
                        rs.getBoolean("isShare"));
                listFS.add(set);
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return listFS;
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
                        rs.getInt("userId"));
                listS.add(set);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listS;
    }

    public ArrayList<Folder> getTopFiveFolder(int userId) {
        ArrayList<Folder> listFd = new ArrayList<>();
        String sql = "select top 5 * from Folder where userId = ? order by folderId desc ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Folder f = new Folder(
                        rs.getInt("folderId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("userId"),
                        rs.getBoolean("isShare"));
                listFd.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listFd;
    }

    public ArrayList<StudySet> getFiveStudySet(int userId) {
        ArrayList<StudySet> listS = new ArrayList<>();
        String sql = "select top 5 * from StudySet where userId = ? order by studySetId desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudySet set = new StudySet();
                set.setId(rs.getInt("studySetId"));
                set.setTitle(rs.getString("title"));
                set.setDescription(rs.getString("description"));
                set.setIsShare(rs.getBoolean("isShare"));
                set.setUserId(rs.getInt("userId"));
                listS.add(set);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listS;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
