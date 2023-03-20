/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DAO;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User;

/**
 *
 * @author LENOVO
 */
public class SendEmail {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean sendEmail(User user, String code) {
        boolean check = true;
        DAO d = new DAO();

        String toEmail = user.getEmail();
        String fromEmail = "hungbmhe161538@fpt.edu.vn";
        String password = "anhbm1311hung";

        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.socketFactory.port", "587");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session ses = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        try {
            Message mess = new MimeMessage(ses);

            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("User Email Verification");
            mess.setText("Registered successfully. Please verify your account using this code: " + code);
//            mess.setContent("<h1 style=\"color: red\">Test</div>", "text/html");

            Transport.send(mess);
            check = true;
        } catch (Exception e) {
            System.out.println(e);
            check = false;
        }

        return check;
    }

    public void sendEmailPass(int id, String to, String changeId) {

        final String user = "hungbmhe161538@fpt.edu.vn";//change accordingly
        final String password = "anhbm1311hung";//change accordingly
        //Get the session object
        String host = "smtp.gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", host);
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Forgot your password?","UTF-8");

            String share = "<td align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "\n"
                    + "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_-2684117488031932361em_full_wrap\" bgcolor=\"#F0F0F0\" style=\"table-layout:fixed\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "<table class=\"m_-2684117488031932361outer\" width=\"600\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" bgcolor=\"#4255ff\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;font-size:24px;line-height:normal;color:#ffffff;font-weight:bold;padding:24px 0\" align=\"center\">\n"
                    + "      <a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HSz6wnMB50LuEkxjHprkpxwS-2FoRbJBaQEKyvoSIssLKSbETpVtmBNkzXroz6-2Bi5bZ-2F7k-2FoKirNiZ2m-2FRSHvyS6cwUsqjXXD5Bb4FOJZAr-2FNqHZchGfI8X2X1qQ2im0Jmg-3D-3DaCoV_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJGEKWQCt39qCwCUB-2FyJPN1cE9XydeEg0Q4yl4JBx6XlrXqlyAJlSJPrbaiYjqbrknhJqVwa4ZcWUJ5LWoIp05RQ4pK8BBOIhgICaKlXmFG-2Bro8qCbPrvHtCFreSXwgNs3mcdbWcF5TPcPjT8vsOrBdI-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HSz6wnMB50LuEkxjHprkpxwS-2FoRbJBaQEKyvoSIssLKSbETpVtmBNkzXroz6-2Bi5bZ-2F7k-2FoKirNiZ2m-2FRSHvyS6cwUsqjXXD5Bb4FOJZAr-2FNqHZchGfI8X2X1qQ2im0Jmg-3D-3DaCoV_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJGEKWQCt39qCwCUB-2FyJPN1cE9XydeEg0Q4yl4JBx6XlrXqlyAJlSJPrbaiYjqbrknhJqVwa4ZcWUJ5LWoIp05RQ4pK8BBOIhgICaKlXmFG-2Bro8qCbPrvHtCFreSXwgNs3mcdbWcF5TPcPjT8vsOrBdI-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw1iRH090Vx7wgeNV6c2rGbO\"><img src=\"https://ci6.googleusercontent.com/proxy/SzNkDgxjiFa2jill6CkH3dxy5OvbPZjDupN21YP2IUSlx2z6Xt6Qzd3_yAZTiVkxt4R9uuXGfFhQGM7y636wfWs2cv3IrE0i118y9ZluTLia7BewCZHj-SeOvYNAwNsFr8poG4PVxRvNTVl6cN0b2hh0WPv119wzxJ41MeNyUTzPCCH9modxGoaV2CWw=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/61030d641f8a53665d8d2d2d/original.png?1627589988\" width=\"112\" alt=\"Quizlet\" style=\"display:block;outline:none!important;margin:0 auto;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a>\n"
                    + "    </td>\n"
                    + "  </tr>\n"
                    + "</tbody></table>\n"
                    + " </td>\n"
                    + "  </tr>\n"
                    + "</tbody></table>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "  \n"
                    + "  <table bgcolor=\"#F0F0F0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-2684117488031932361em_full_wrap\" style=\"table-layout:fixed\" width=\"100%\">\n"
                    + "    <tbody><tr>\n"
                    + "      <td align=\"center\" bgcolor=\"#F0F0F0\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\" valign=\"top\">\n"
                    + "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-2684117488031932361em_main_table\" style=\"width:600px;table-layout:fixed\" width=\"600\">\n"
                    + "          <tbody><tr>\n"
                    + "            <td align=\"center\" valign=\"top\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "              \n"
                    + "              <table align=\"center\" bgcolor=\"#4257B2\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "                <tbody><tr>\n"
                    + "                  <td style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "                    \n"
                    + "                    \n"
                    + "					          <table align=\"center\" bgcolor=\"#4255FF\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "                      <tbody><tr>\n"
                    + "                        <td align=\"center\" class=\"m_-2684117488031932361em_pad_all_2\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:8px 80px 55px\" valign=\"top\">\n"
                    + "                          \n"
                    + "                          \n"
                    + "						              \n"
                    + "                          <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-radius:8px\" width=\"100%\" bgcolor=\"#ffffff\">\n"
                    + "                            <tbody><tr>\n"
                    + "                              <td align=\"left\" class=\"m_-2684117488031932361em_pad_none\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:48px 0\" valign=\"top\">\n"
                    + "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:312px\" width=\"77%\">\n"
                    + "                                  <tbody><tr>\n"
                    + "                                    <td align=\"left\" class=\"m_-2684117488031932361em_pbottom\" style=\"font-size:24px;line-height:28px;padding-bottom:30px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;color:#303545;font-weight:bold\" valign=\"top\">Bạn quên mật khẩu?\n"
                    + "                                  </td></tr>\n"
                    + "                                  <tr>\n"
                    + "                                    <td align=\"left\" class=\"m_-2684117488031932361em_pbottom\" style=\"font-size:16px;line-height:24px;padding-bottom:30px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;color:#303545\" valign=\"top\">Đừng lo, chuyện thường tình ấy mà! Hãy nhấp vào liên kết bên dưới để đăng nhập vào tài khoản Quizlet và đặt lại mật khẩu của bạn. Liên kết này hết hạn trong 10 phút và chỉ có thể được sử dụng một lần.\n"
                    + "                            \n"
                    + "                                  </td></tr>\n"
                    + "                                  <tr>\n"
                    + "                                    <td align=\"center\" valign=\"top\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "                                      <table align=\"center\" bgcolor=\"#0A092D\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-radius:4px;width:100%;max-width:312px\" width=\"100%\">\n"
                    + "                                        <tbody><tr>\n"
                    + "                                          <td align=\"center\" height=\"57\" style=\"height:57px;color:#ffffff;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;font-size:16px;font-weight:600\" valign=\"middle\">\n"
                    + "                                            <a style=\"text-decoration:none\" href="+ changeId +">Cài đặt lại mật khẩu</a>\n"
                    + "                                          </td>\n"
                    + "                                        </tr>\n"
                    + "                                      </tbody></table>\n"
                    + "                                    </td>\n"
                    + "                                  </tr>\n"
                    + "                                            <tr>\n"
                    + "                                    <td align=\"left\" class=\"m_-2684117488031932361em_pbottom\" style=\"font-size:10px;line-height:12px;padding-bottom:30px;padding-top:30px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;color:#303545\" valign=\"top\">Nếu không yêu cầu đặt lại mật khẩu, bạn có thể bỏ qua email này và mật khẩu của bạn sẽ không thay đổi. \n"
                    + "\n"
                    + "Để tìm câu trả lời bất kỳ lúc nào, hãy truy cập <a class=\"m_-2684117488031932361arrow\" href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2Fuh9Ly69Jb7RrkzItpwJfX3Zqk_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJNGFIgk-2F7XU-2FxAAKl18JJxAf1xgaftSSkBEiKZpMlUIv-2FkN5sUkM5yyUFlvaWDNqMjhUXjFUDoIQHlRgIhEEeKUcFZUOKjR0K7GOK3oidenfHhHUIYxa3YRgKjotBjabSTCYyFmKt0RWyQ3LXia3vlA-3D\" style=\"color:inherit;font-weight:600;text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2Fuh9Ly69Jb7RrkzItpwJfX3Zqk_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJNGFIgk-2F7XU-2FxAAKl18JJxAf1xgaftSSkBEiKZpMlUIv-2FkN5sUkM5yyUFlvaWDNqMjhUXjFUDoIQHlRgIhEEeKUcFZUOKjR0K7GOK3oidenfHhHUIYxa3YRgKjotBjabSTCYyFmKt0RWyQ3LXia3vlA-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw1BM8fX7jpYEj41nm4qeGAQ\">Trung tâm hỗ trợ</a> của chúng tôi.\n"
                    + "\n"
                    + "\n"
                    + "                                  </td></tr>                       \n"
                    + "\n"
                    + "                                </tbody></table>\n"
                    + "                              </td>\n"
                    + "                            </tr>\n"
                    + "                          </tbody></table>\n"
                    + "                          \n"
                    + "                        </td>\n"
                    + "                      </tr>\n"
                    + "                    </tbody></table>\n"
                    + "                  </td>\n"
                    + "                </tr>\n"
                    + "              </tbody></table>\n"
                    + "            </td>\n"
                    + "          </tr>\n"
                    + "        </tbody></table>\n"
                    + "      </td>\n"
                    + "    </tr>\n"
                    + "  </tbody></table>\n"
                    + "  \n"
                    + "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_-2684117488031932361em_full_wrap\" style=\"table-layout:fixed\" bgcolor=\"#F0F0F0\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td align=\"center\" valign=\"top\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_-2684117488031932361em_main_table\" style=\"width:600px\" bgcolor=\"#ffffff\">\n"
                    + "        <tbody><tr>\n"
                    + "          <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "              <tbody><tr>\n"
                    + "                <td width=\"24\" style=\"width:24px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:40px 0 0\"><table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                    <tbody><tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                          <tbody><tr>\n"
                    + "                          <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4B38-2FMELK2A0SVRfjYe28O4lWjwdHCl2Z1SZOY2lFz52aGN7_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJBrsGWStHbVSv1hrgpJIRxh-2BmFe4XDmZ0VL6CW-2B4FT58fuJoDcaju7-2FnWUgVrPqnLa8kuQXfPXVKlCDPAtgR6WIHFv-2BP81gtLa9YoIBVuTmlv4vWijRAwAeJQhlNSg8qrspUxMEbInXF05RDx66ejag-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4B38-2FMELK2A0SVRfjYe28O4lWjwdHCl2Z1SZOY2lFz52aGN7_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJBrsGWStHbVSv1hrgpJIRxh-2BmFe4XDmZ0VL6CW-2B4FT58fuJoDcaju7-2FnWUgVrPqnLa8kuQXfPXVKlCDPAtgR6WIHFv-2BP81gtLa9YoIBVuTmlv4vWijRAwAeJQhlNSg8qrspUxMEbInXF05RDx66ejag-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw3Lk2N2CeeC2QZckQauGNmY\"><img src=\"https://ci4.googleusercontent.com/proxy/GlGV4uKrHHs815RrDdbM-S_LEJpR6Xi3iRxF7SKN8qNpgZFxFL9LsMdNvQN7522szMpQpUYb6MEenSnKJCFaohLZwJFIrbuZj2Vt3KvnKis8ivKeByYVGIoad75WLGBqe3hyiHiPcXbpYUS-FZyhrgeu7Kdjj_yGRXlOOQYxEh9VgUy6i7d42Bz86qE=s0-d-e1-ft#https://braze-images.com/appboy/communication/assets/image_assets/images/63c1c2979522c319972752fe/original.png?1673642647\" width=\"24\" height=\"24\" alt=\"tiktok\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4NHJsO5HXZ4R-2By1vNzmUfxquSwOLQ1UnxTnjL2g-2B0XDb_2Zp_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJODlPi3eveJmf9sutcZ8uARtX8R9U6sXxh6fnwjv9nuk1uFoSAu1O0Xt4zNr8iSO1m5Ngw5TIMK8u8LAE-2BgHeKVNlgl4t09KQF5mx6rZ6bopAvKrUmBVCzXYrJOgckooCoEWc22QF-2BFIW9v2aL2mVnM-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4NHJsO5HXZ4R-2By1vNzmUfxquSwOLQ1UnxTnjL2g-2B0XDb_2Zp_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJODlPi3eveJmf9sutcZ8uARtX8R9U6sXxh6fnwjv9nuk1uFoSAu1O0Xt4zNr8iSO1m5Ngw5TIMK8u8LAE-2BgHeKVNlgl4t09KQF5mx6rZ6bopAvKrUmBVCzXYrJOgckooCoEWc22QF-2BFIW9v2aL2mVnM-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw15o4VbDEcZZWqvGvvBYmZ7\"><img src=\"https://ci4.googleusercontent.com/proxy/muVdOUYpJtNd4-mbuZSl2VQSMHSo_O9vFDny-DTMb1N4i1-1eoga5P2bLhlOWHw6EHNv7wHiKm8ZLrSzG9foWhxaiE2pOnV4g8LDSC4tpg6LpZK6AFo4YUf_uPIIRXxuIvSqz89R0rH3BLHZG6X2ce8YkbLYmHA4aG5jx8RWGKPp0ivWo5nx84EK8aX8=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7a5ff908527006d389/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"fb\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HTvkruJItaGbSCxHMYqXkqa2L4sZQFdbTBo7BKpYDro-1OR_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJIgRiCjOpPnj0yjih6WBSn4D5fJIW2v9hhbSDCTGyEgdRdmzQz03chb409mc6dW0pYkdALPNO-2FtlfUZHir2fgv6RUfGJVf9iUWFqcGiz8R1EaH9bU-2BR7MtLROGBACp1gOPd4-2BJat3n6skF-2FSURxRfBw-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HTvkruJItaGbSCxHMYqXkqa2L4sZQFdbTBo7BKpYDro-1OR_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJIgRiCjOpPnj0yjih6WBSn4D5fJIW2v9hhbSDCTGyEgdRdmzQz03chb409mc6dW0pYkdALPNO-2FtlfUZHir2fgv6RUfGJVf9iUWFqcGiz8R1EaH9bU-2BR7MtLROGBACp1gOPd4-2BJat3n6skF-2FSURxRfBw-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw0d_WIxGPUlewjYS2QKJ16K\"><img src=\"https://ci3.googleusercontent.com/proxy/hcTCxXoV-LYcnZBgWPZAHHBkuJx5WwM7sqYwa9ZI-qupzj6oZvqwgJRy7ZyYpqkixQ2GqctG6dup3bBhZ5RoEMZdVydl_K2-qaJy5uHbbtG2cIOm8kVlquCym4zAn16jsJCXETg4Lf7kST6B9e9Hmjc0tohWdlYgj3OWQmPUQYWFIyddU1MNPagMsy2c=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7a9d7fd53e6dfa22b9/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"insta\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                             <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4AclCku5XjKLhmZGAshNJOGg-2BQ8r3rlCdmDGiCVqbZgZAK7VnJt7ISglWCT5PZRWQA-3D-3DvbaJ_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJAL2CpxcsX9yqLqmuS-2Bqr1mZgtdJsHhqqqYe9jvh-2BkhgEfwYg1rTQTF5BKC9U-2BQhAQOKaKPBOHE3NXERRrqHSa9cxQLfUM9LIrKbJrqKjK49x0KwVBxhoDHf5gcTieAys0zFNA1JHHJVaupv0oU10GM-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4AclCku5XjKLhmZGAshNJOGg-2BQ8r3rlCdmDGiCVqbZgZAK7VnJt7ISglWCT5PZRWQA-3D-3DvbaJ_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJAL2CpxcsX9yqLqmuS-2Bqr1mZgtdJsHhqqqYe9jvh-2BkhgEfwYg1rTQTF5BKC9U-2BQhAQOKaKPBOHE3NXERRrqHSa9cxQLfUM9LIrKbJrqKjK49x0KwVBxhoDHf5gcTieAys0zFNA1JHHJVaupv0oU10GM-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw1Tu-To_Z9VWYDpUV8OSexL\"><img src=\"https://ci4.googleusercontent.com/proxy/4s8fvDXDV483OAMawuNNbq5gFvYj3MraOIX7CARZtKUQmYnSVj5r18YZDLmnL7i6Li0yu26TMnRfuetY4UqVNf1oOXmN05EhEQJqr_CTuBxheJjP045gKYXOQzQ-Q0zeeyI1wlAOYgZXsSJrrkz_YBpsmRFNw_hQ8c1XUZA9KRN1zOk-UNy1_KtLY3Ji=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c1b5d79a054c75800e5/original.png?1618250779\" width=\"24\" height=\"24\" alt=\"youtube\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PztVoMs0-2F-2BP1VaGp-2BQzVDqQ7XBohY0-2FRBkaP4PhyzccboP5_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJOclWnlIASnch9eIyzlMSP2xr1QRMBLeBJ2rao9-2FJbneFFu3n3yayP8b-2BZfOXg5Z41UTXwTCKQQ0UbexsJCvXHTHgc21bS-2BFgZqwKy-2BEBh82XjYfiV3fbtX0BVIMHXcR4F2ss-2FFhmE5ZMYtK3R10Oyc-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PztVoMs0-2F-2BP1VaGp-2BQzVDqQ7XBohY0-2FRBkaP4PhyzccboP5_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJOclWnlIASnch9eIyzlMSP2xr1QRMBLeBJ2rao9-2FJbneFFu3n3yayP8b-2BZfOXg5Z41UTXwTCKQQ0UbexsJCvXHTHgc21bS-2BFgZqwKy-2BEBh82XjYfiV3fbtX0BVIMHXcR4F2ss-2FFhmE5ZMYtK3R10Oyc-3D&amp;source=gmail&amp;ust=1679343839044000&amp;usg=AOvVaw0i0CoF3ZGau65vCpRpohYW\"><img src=\"https://ci6.googleusercontent.com/proxy/IzX34v-nOcyRy92K2H4i6gGqKFhbJCwQQESg3XZ3eoQ1-_27W6YqyD8RfPTRk9R-0DWYChhxs5gKi_DEtpHy65HM7lfSH8VHGba-mOIB7RqX9mLGXQjXKdaZGDsx6lKfDVcKr5Cp3_aD3YDDF2LZApAGF8QMOBO4oK9L3Yp_PXhhIvCTfsrqMXm2e_U8=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7aef5b9f0cd4d7bdec/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"tw\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            \n"
                    + "                          </tr>\n"
                    + "                        </tbody></table></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td height=\"26\" style=\"height:26px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                          <tbody><tr>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:16px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4K8XPGgUCgm91XlfFjHwlEqEAgvVD3m7Yp3aEy6O7EEsf4I6aHLIfVVg4nJ9IOkmFYkOGdWk0Vovn4qVK8Ghoiau6Bq-2BlpAvnoUNAzVqbqDbh1beBjUpTU3PBxAdp-2BD1CWHOantWy-2FuCa0tC2kLCbX2klqlu2eJ8-2BrJWvFVR3r9gsmfQsZDlPeNScR6c0sWthA-3D-3DYMni_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJKKeCl-2B7jjpGXClK2hJlxf6MYU2zaEyUiINSMrS6lvu-2FSPwnPHvrmQupyIgUn8agiXFK7lp20UWb1j29Q4Cfihws7pU8wr8cMQux1A99OZI8L3eafa0Hvbdm0Gd10hBaCcVn8Y3tT-2FoUfyynBWXs56U-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4K8XPGgUCgm91XlfFjHwlEqEAgvVD3m7Yp3aEy6O7EEsf4I6aHLIfVVg4nJ9IOkmFYkOGdWk0Vovn4qVK8Ghoiau6Bq-2BlpAvnoUNAzVqbqDbh1beBjUpTU3PBxAdp-2BD1CWHOantWy-2FuCa0tC2kLCbX2klqlu2eJ8-2BrJWvFVR3r9gsmfQsZDlPeNScR6c0sWthA-3D-3DYMni_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJKKeCl-2B7jjpGXClK2hJlxf6MYU2zaEyUiINSMrS6lvu-2FSPwnPHvrmQupyIgUn8agiXFK7lp20UWb1j29Q4Cfihws7pU8wr8cMQux1A99OZI8L3eafa0Hvbdm0Gd10hBaCcVn8Y3tT-2FoUfyynBWXs56U-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw24fqLYboMNg_rGhAVdBEvv\"><img src=\"https://ci6.googleusercontent.com/proxy/z1gVfnC7a4QLiuwVA4p5rYW06Voy5hSYYC7aHP9ZLl39Vfkl4armLDh4pTv5bbTrvgnp8kWzMWdmCKb2Sl-V2ukeYI8zgFSxpXXvM8ZpvQgK17CEPi_t2aHx10b9qo0aKM4Qdxn3a3sHlYoj-EM-QpLGiHfAhU7b9qsT0jxvAtQJ24KC03W4nO0eqNcE=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/5e8cb7acd21f79794861d8f2/original.png?1586280364\" width=\"84\" height=\"28\" alt=\"Download on the App Store\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:16px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4I-2F7bl7nLqoNGMm6idWRgS9TL3t8Jj8awpvwi0VrPXYj2CIulRlw69hYwmLEXIgFS61HCz8anOHN-2BWaqmI5QZpUi3xE67W8Ut1L-2BoMaxeohylro6c6YOiv9FtTzfJnVk-2BuIJ64JBi1vwF-2B1pTjV7rOTQFpH-2F3a-2BmqMHxgaxwdGdcrQxtfzozRnwJmpU7B8cpZA-3D-3DO8sD_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJFnhrIjzyL7aPrY8jl4xRdpwJqxu45yRpZ2cPSnXQIhPCuRtsLsvD84mIoHCZMBnzDmlFV9E-2FII7Bc5fk5zKjAq41sryihQ0kH26INsDKQ3uqd1yKW3Xxw0-2FoHLYvjrJOFITtm4wf6JxmElMPlHz53U-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4I-2F7bl7nLqoNGMm6idWRgS9TL3t8Jj8awpvwi0VrPXYj2CIulRlw69hYwmLEXIgFS61HCz8anOHN-2BWaqmI5QZpUi3xE67W8Ut1L-2BoMaxeohylro6c6YOiv9FtTzfJnVk-2BuIJ64JBi1vwF-2B1pTjV7rOTQFpH-2F3a-2BmqMHxgaxwdGdcrQxtfzozRnwJmpU7B8cpZA-3D-3DO8sD_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJFnhrIjzyL7aPrY8jl4xRdpwJqxu45yRpZ2cPSnXQIhPCuRtsLsvD84mIoHCZMBnzDmlFV9E-2FII7Bc5fk5zKjAq41sryihQ0kH26INsDKQ3uqd1yKW3Xxw0-2FoHLYvjrJOFITtm4wf6JxmElMPlHz53U-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw1O5q2plxrRYYPrTkeXOxZf\"><img src=\"https://ci3.googleusercontent.com/proxy/KVDfQelQdNuaBU7ZGksDxPPtwK3_cHhN9lmo6e_ExZ_4dcAzPLVGEaCoBxdxJsLhHMGFLp8WsKCudgtWj4YfUY-CnCD03dL81s1xCICQQw0aGuqZRaec0FqN5bJWbc4br36tqD_snoQzqbQ7LJY4GLc2ZruuchxVP-l-6VjAYR62qtoHK61Lg6OcBwhn=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/5e8cb7acaf2cae1ec4d85639/original.png?1586280364\" width=\"84\" height=\"28\" alt=\"GET IT ON Google Play\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                          </tr>\n"
                    + "                        </tbody></table></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td height=\"26\" style=\"height:26px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2',Arial,sans-serif;font-size:10px;line-height:12px;color:#455358\">Quizlet, Inc. <br>1‌2‌3 T‌o‌w‌n‌s‌e‌n‌d S‌t‌r‌e‌e‌t, S‌u‌i‌t‌e 6‌0‌0  <br>S‌a‌n\n"
                    + "                        F‌r‌a‌n‌c‌i‌s‌c‌o, C‌A 9‌4‌1‌0‌7 U‌S‌A  <br><br>Thông điệp này dành cho: <a href=\"mailto:phuongnvhe161526@fpt.edu.vn\" target=\"_blank\">phuongnvhe161526@fpt.edu.vn</a></td>\n"
                    + "                        \n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td height=\"26\" style=\"height:26px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2',Arial,sans-serif;font-size:10px;line-height:12px;color:#455358;font-weight:bold\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2BkI5Zngj6l-2F2XVKblG-2By3Ox-2BVuMsfuaT7vQCjEjYdD4KK4bLDVI0V1bxPtMT6napCpzElWAPQ1iQn0B5OheP5VldujLxJiiwaAyPwJbaYdbA-3D-3D5MS-_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJL-2FneY6r2O5E-2F8TJ417BFdVkQZd4q7qHz9wv28-2FPVEnMT1OVmXZIRRSgXqEfdsHN-2FTNkY7Otq8vVy5jXtyu8z2RFdMeW6kLD7L7d8g7pNI37-2B9zWia-2FVTSTGCGCohMoFykJrqER4zL8wwzbJmSa2guw-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2BkI5Zngj6l-2F2XVKblG-2By3Ox-2BVuMsfuaT7vQCjEjYdD4KK4bLDVI0V1bxPtMT6napCpzElWAPQ1iQn0B5OheP5VldujLxJiiwaAyPwJbaYdbA-3D-3D5MS-_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJL-2FneY6r2O5E-2F8TJ417BFdVkQZd4q7qHz9wv28-2FPVEnMT1OVmXZIRRSgXqEfdsHN-2FTNkY7Otq8vVy5jXtyu8z2RFdMeW6kLD7L7d8g7pNI37-2B9zWia-2FVTSTGCGCohMoFykJrqER4zL8wwzbJmSa2guw-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw0wlpWhxEhb-ilWTRVmSXlk\">Trung tâm Hỗ trợ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HfdzAvpY-2BNqeKH6GJtAuTFQh4iXKvxLCIocG-2FrvijXMWhAURz7QSAQSGrSyBpwaBprdsD0mVj5-2Buj0ATRdiwCHndgmFkOcZZv1ouXvryLdmFepbKmntOHco-2FR0TLuNEQVYHQY-2BTmPu8jvmacpjosk2f9m-2B7l-2Bva4dgPFCoySy4Zg5WLJ-2BkuHjWwSKAhcSlYGw-3D-3DkMVT_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJLXGYhUwhqwxzq5yAR3hrYcxAK-2B-2FMj6OR5-2F7Pfd5pfPOhgD8GzxHoOD0mKV-2FJ2OGkPVrh1QcihWqtdWhzt5KIxxDNkZEsViWuB-2FkdZT5mJLS-2FLdN5O7WE9ak-2B7dmL86Aldn4REJBxK2fpFEEEZ7Ez20-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HfdzAvpY-2BNqeKH6GJtAuTFQh4iXKvxLCIocG-2FrvijXMWhAURz7QSAQSGrSyBpwaBprdsD0mVj5-2Buj0ATRdiwCHndgmFkOcZZv1ouXvryLdmFepbKmntOHco-2FR0TLuNEQVYHQY-2BTmPu8jvmacpjosk2f9m-2B7l-2Bva4dgPFCoySy4Zg5WLJ-2BkuHjWwSKAhcSlYGw-3D-3DkMVT_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJLXGYhUwhqwxzq5yAR3hrYcxAK-2B-2FMj6OR5-2F7Pfd5pfPOhgD8GzxHoOD0mKV-2FJ2OGkPVrh1QcihWqtdWhzt5KIxxDNkZEsViWuB-2FkdZT5mJLS-2FLdN5O7WE9ak-2B7dmL86Aldn4REJBxK2fpFEEEZ7Ez20-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw3F2Ua8r5S3wZBp6PV1BNM7\">Hủy đăng ký theo dõi</a></td>\n"
                    + "                    </tr>\n"
                    + "                                        <tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2',Arial,sans-serif;font-size:10px;line-height:12px;color:#455358;font-weight:bold\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PGpnPzxUSckOM4ciCqggyLS-2Bd0DE2onD6N-2BoJXWBxClPXGY_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJN2R5AjR5ZDYG-2BxB6gzoOOXO95ZaKDe5Eh21XHl1javbWEW2jxvY0w7PirYArq3iJTRCmUY0defR8p3RnxZwvlpQKi0YtcoWD2r03EScNUiQOTt-2F2Wi8pdKCIs0gLVGqg5IJSMaC-2BKIAl6tMuHSUEeU-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PGpnPzxUSckOM4ciCqggyLS-2Bd0DE2onD6N-2BoJXWBxClPXGY_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJN2R5AjR5ZDYG-2BxB6gzoOOXO95ZaKDe5Eh21XHl1javbWEW2jxvY0w7PirYArq3iJTRCmUY0defR8p3RnxZwvlpQKi0YtcoWD2r03EScNUiQOTt-2F2Wi8pdKCIs0gLVGqg5IJSMaC-2BKIAl6tMuHSUEeU-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw3XXQaxqib61XIUl8oREC4L\">Điều khoản dịch vụ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PQ0VEULm4DYx0oXJCnM6GhGf2HP9pPFKzO2U0uK2IEmNfGF_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJDquu0vHjqsfcOh2k4Ld5uHKV7x0yf0uh4JWkTOka6dkLR6-2BOHg1VLSJAkaFMLKxjTWn2dQddaAKfV4rhnAOwjj9WgabRY6Veb-2F2OaK5WWJVB0oZuOHANARGS-2BWwNFwe4WZMFnTMftL-2BbYVmKqmH9DI-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PQ0VEULm4DYx0oXJCnM6GhGf2HP9pPFKzO2U0uK2IEmNfGF_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLVUkqypVdSgesyFgjIBxZutl8y3afHaPSSfPLkvwAUniWDZRtuhyD1eRFEE-2FUuXe8CFgi-2Bw5ntWm8GcWHStesJUOMcc-2BtdvbBjmV5bqxxZhsPF8B2-2BT-2Bh2BsBJpYnAM5vy7ZchY20-2FjztchSh4wsDBA-2BZVaPbYOEDgjw1IVxPK8xxwyj95eNPFq7E-2Bkr4JIY-2BVbZleteXDp6iNlnSMGUqoT5i-2Fo-2B-2B-2FeD-2Bnj4rW-2BYCSUqGn36VQpEpZnC0XUrwtkP3-2FSrJQQybLq9-2BNxKIUb2MPJkJh57Yx9T3sHzAU-2FJMTIeCwq3Ej0g-2B3IROqUdJM-2FUCSq6bfj6E2K7Bs6EVg5ZFuAbTMEZKD009NoIz3GuUkwKmr90KDpSJA02pLZoAvQYaKMDD0c-2FPFwkFGTMf9Dr63FHBPobBKTp48zLYdyB1G5c7dMgi3983NxqST8cn9BAJDquu0vHjqsfcOh2k4Ld5uHKV7x0yf0uh4JWkTOka6dkLR6-2BOHg1VLSJAkaFMLKxjTWn2dQddaAKfV4rhnAOwjj9WgabRY6Veb-2F2OaK5WWJVB0oZuOHANARGS-2BWwNFwe4WZMFnTMftL-2BbYVmKqmH9DI-3D&amp;source=gmail&amp;ust=1679343839045000&amp;usg=AOvVaw1TQK3pbQcsFcciVsQ6-Kgl\">Chính sách quyền riêng tư</a></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                      <td height=\"26\" style=\"height:26px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                    </tr>\n"
                    + "                  </tbody></table></td>\n"
                    + "                <td width=\"24\" style=\"width:24px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "              </tr>\n"
                    + "            </tbody></table></td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "          <td class=\"m_-2684117488031932361em_hide\" style=\"line-height:1px;min-width:600px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\" bgcolor=\"#ffffff\"><img alt=\"\" src=\"https://ci6.googleusercontent.com/proxy/P6c11i3gpJc_W5S5bdIfR_iqMI5UM3sB5Vfn1XKzpjXvYbmVKLOYHI_KGQ=s0-d-e1-ft#http://images/spacer.gif\" height=\"1\" width=\"600\" style=\"max-height:1px;min-height:1px;display:block;width:600px;min-width:600px;outline:none!important;border:0\" border=\"0\" class=\"CToWUd\" data-bit=\"iit\" jslog=\"138226; u014N:xr6bB; 53:W2ZhbHNlLDJd\"></td>\n"
                    + "        </tr>\n"
                    + "      </tbody></table></td>\n"
                    + "  </tr>\n"
                    + "</tbody></table>\n"
                    + "\n"
                    + "</td>";
            message.setContent(share, "text/html;charset=UTF-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
