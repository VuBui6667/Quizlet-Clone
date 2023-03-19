package utility;

import dal.*;
import java.util.*;
import javafx.scene.control.ListCell;
import model.*;

/**
 *
 * @author Admin
 */
public class Utilities {

    DAO d = new DAO();
//    ArrayList<Account> listacc = d.loadListAccount();
//    ArrayList<Post> listpost = d.loadListPost();
    ArrayList<User> listU = d.getAllUser();

    public Utilities() {
    }

    // validate not empty
    public boolean isNotEmpty(String e, String u, String p) {
        if ("".equals(e) && "".equals(u) && "".equals(p)) {
            return false;
        }
        return true;
    }

    // validate not blank
    public boolean isBlank(String u) {
        if ("".equals(u)) {
            return true;
        }
        return false;
    }

    //check exist email
    public boolean checkExistEmail(String email) {
        for (User u : listU) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    //check repeat pass matching
    public boolean checkRepeatPass(String p, String cp) {
        if (cp.equals(p)) {
            return true;
        }
        return false;
    }

    // validate input field require
    public String validInputRequire(String e, String u, String p) {
        String errNoti = null;
        if (validEmail(e) != null) {
            errNoti = validEmail(e);
        } else if (validUsername(u) != null) {
            errNoti = validUsername(u);
        } else if (validPass(p) != null) {
            errNoti = validPass(p);
        }
        return errNoti;
    }

    //validate email
    public String validEmail(String email) {
        String regex = "\\w+@\\w+[.]\\w+";
        if (!email.matches(regex)) {
            return "Invalid type of email!, for example: example1@gmail.com";
        }
        return null;
    }

    // validate username
    public String validUsername(String u) {
        String regex = "[a-zA-Z0-9 ]+";
        if (u.length() < 4 || u.length() > 12 || !u.matches(regex)) {
            return "User name must be between 4 and 12 characters and be the number or alphabet characters";
        }
        return null;
    }

    // validate pass
    public String validPass(String p) {
        if (p.length() < 4 || p.length() > 12) {
            return "Password must be between 4 and 12 characters";
        }
        return null;
    }
    
    public int getNumberCard(ArrayList<Card> listC, Card c) {
        for(int i=0; i<listC.size(); i++) {
            if(listC.get(i).getId() == c.getId()) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // test
    }
}
