/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DAO;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Folder;
import model.User;

/**
 *
 * @author ASUS
 */
public class SendEmailShare {

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

            Transport.send(mess);
            check = true;
        } catch (Exception e) {
            System.out.println(e);
            check = false;
        }

        return check;
    }

    public void sendEmailInviteClass(String to, User u, String href) {
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
            message.setSubject("Lời mời tham gia lớp trên quizlet","UTF-8");
            String share = "<table width=\"598\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"width:598px\" class=\"m_8100147788066177956em_wrapper\"><tbody><tr><td valign=\"top\" align=\"center\" class=\"m_8100147788066177956em_aside10\" style=\"padding-left:45px;padding-right:45px\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"padding-bottom:25px\"><tbody><tr><td valign=\"top\" align=\"center\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"padding-top:42px;padding-bottom:35px\"><tbody><tr><td valign=\"top\" align=\"left\"><a href=\"https://links-share.quizlet.com/ls/click?upn=lWfVo-2BdHFKQCHnahn-2FofOAlmXF22VCcrNoNYG2BwfXY-3DlZ7k_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjZY3yfHrX3-2FlsPULuuA5K79b1Qv-2BvuOXL38n2Kgdzv1Ud4v5wyk4JMU76BhZgcP3TjVtyMv-2F-2Bug6kprMJigMNaxT-2BptJNna-2BqG7FsCMK2Oy9rk-2BwM0uYbyBpk0cs84tMYybFsNl5iVCzB5BOM9i-2Bwin7TgmWi6oZtASoxlvGS1-2FTSqatkXceWqRElhfaGZ6Z7UW5KFOofBrisQvMncIu3C0GF2PFqc81cejMz5xm3XZSTELIsrhM-2Bai-2F8DvrmCACU-2BTN93AowjKK1qpdkuOvDqvUIy0-2FjUXR0AlPOL0NwYGfZBUIU4E4jwnr1VOuS6CIr\" style=\"text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://links-share.quizlet.com/ls/click?upn%3DlWfVo-2BdHFKQCHnahn-2FofOAlmXF22VCcrNoNYG2BwfXY-3DlZ7k_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjZY3yfHrX3-2FlsPULuuA5K79b1Qv-2BvuOXL38n2Kgdzv1Ud4v5wyk4JMU76BhZgcP3TjVtyMv-2F-2Bug6kprMJigMNaxT-2BptJNna-2BqG7FsCMK2Oy9rk-2BwM0uYbyBpk0cs84tMYybFsNl5iVCzB5BOM9i-2Bwin7TgmWi6oZtASoxlvGS1-2FTSqatkXceWqRElhfaGZ6Z7UW5KFOofBrisQvMncIu3C0GF2PFqc81cejMz5xm3XZSTELIsrhM-2Bai-2F8DvrmCACU-2BTN93AowjKK1qpdkuOvDqvUIy0-2FjUXR0AlPOL0NwYGfZBUIU4E4jwnr1VOuS6CIr&amp;source=gmail&amp;ust=1679347689962000&amp;usg=AOvVaw1nw--kOzZik7RwRLpU4op6\"><img src=\"https://ci6.googleusercontent.com/proxy/VUBSJBCifFZIRqA5MN4VWsRaz4ggXdy14s-ShkY_2Cfb9OvD1O19sNHxVb3uMP9_LYV490Z-FQWxALP6Lacv1XMN-uP4vNtGC2gtUlGkqVJoBIN0JtnnFkSKsSkRbRksGreB8euWiEA=s0-d-e1-ft#https://assets.quizlet.com/a/j/dist/app/i/logo/2021/logo-twilight.3a81a0a8731485a.png\" width=\"93\" alt=\"Quizlet\" border=\"0\" style=\"display:block;max-width:93px;font-family:Arial,sans-serif;font-size:17px;line-height:20px;color:#000000;font-weight:bold\" class=\"CToWUd\" data-bit=\"iit\"></a></td></tr></tbody></table></td></tr><tr><td><span></span><span></span></td></tr><tr><td valign=\"top\" align=\"left\" style=\"font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#303545;padding-top:22px\">Xin chào,<br>\n"
                    + "<br>\n"
                    + "Một người dùng Quizlet," +u.getName()+", đã mời bạn tham gia một lớp học. Nếu bạn chưa quen dùng ứng dụng này, thì Quizlet là dịch vụ học tập trực tuyến biến việc học trở nên vui thú và hiệu quả hơn nhờ các thẻ ghi nhớ, các hoạt động, trò chơi và nhiều tính năng khác. Chấp nhận lời mời tham gia lớp học và truy cập ngay để học các nội dung.</td></tr></tbody></table></td></tr><tr><td valign=\"top\" align=\"center\" class=\"m_8100147788066177956em_padding\" style=\"padding-top:25px;padding-bottom:25px\"><table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_8100147788066177956em_tab\" bgcolor=\"#4255ff\"><tbody><tr><td class=\"m_8100147788066177956em_button\" valign=\"middle\" align=\"center\" height=\"58\" style=\"font-family:Arial,sans-serif;font-size:16px;color:#ffffff;font-weight:bold\"><a href="+href+" style=\"padding:10px 25px;text-decoration:none;color:#ffffff;display:block\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://links-share.quizlet.com/ls/click?upn%3DlWfVo-2BdHFKQCHnahn-2FofOFT32b7ywOPUaDU4tltTo7eCCwu0fu3BsIowYxduNmkQ2-2FBCiOa70XfcxK-2FMGgK6Ep-2BPAJfuFAGfwq5X6TLkQYg-3DyBgV_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjZY3yfHrX3-2FlsPULuuA5K79b1Qv-2BvuOXL38n2Kgdzv1Ud4v5wyk4JMU76BhZgcP3TjVtyMv-2F-2Bug6kprMJigMNaxT-2BptJNna-2BqG7FsCMK2Oy8slKHwCq-2B6KaqU1x0pMT-2FHSuVTyy4gSyswEdTV-2FHYTCXJmnUkwyfQz6zeCi6bSpxJAFUZsMas4DRLBST5dzU-2Frpl7SKSuMvCHeyh3ChUGvSs3xnjbKflk3vwBBeyOQO6JoGlx-2Fb-2FTBp83CcQ3tLKo8qgSABkCXZYjGx2LWai2HiAY5lv-2BxxdtTR1ZxleYbwApeBuFPegN4mEpK2GElnMyE&amp;source=gmail&amp;ust=1679347689963000&amp;usg=AOvVaw1-kVXBQ-2xAtvuSW6iz6re\">Chấp nhận lời mời</a></td></tr></tbody></table></td></tr><tr><td valign=\"top\" align=\"center\" style=\"padding:10px\"><table width=\"578\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"m_8100147788066177956em_wrapper\"><tbody><tr><td valign=\"top\" align=\"center\" style=\"font-family:Arial,sans-serif;font-size:14px;line-height:22px;color:#303545\"><span>Cảm ơn bạn!</span>&nbsp;<span style=\"color:#4255ff;font-family:'Trebuchet MS',Arial,sans-serif\">Đội ngũ <img src=\"https://ci6.googleusercontent.com/proxy/VUBSJBCifFZIRqA5MN4VWsRaz4ggXdy14s-ShkY_2Cfb9OvD1O19sNHxVb3uMP9_LYV490Z-FQWxALP6Lacv1XMN-uP4vNtGC2gtUlGkqVJoBIN0JtnnFkSKsSkRbRksGreB8euWiEA=s0-d-e1-ft#https://assets.quizlet.com/a/j/dist/app/i/logo/2021/logo-twilight.3a81a0a8731485a.png\" width=\"50\" alt=\"Quizlet\" class=\"CToWUd\" data-bit=\"iit\"></span></td></tr><tr><td height=\"47\" class=\"m_8100147788066177956em_h20\">&nbsp;</td></tr></tbody></table></td></tr></tbody></table>";
            message.setContent(share, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailShare(String to, User u, Folder f, String href) {

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
            message.setSubject(u.getName() + " muốn chia sẻ tài liệu học Quizlet với bạn?","UTF-8");
            String share = "<table role=\"presentation\" width=\"100%\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"color:#455357;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;min-width:100%\" bgcolor=\"#f0f0f0\"><tbody><tr><td align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "\n"
                    + "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_4444567503209527307em_full_wrap\" bgcolor=\"#F0F0F0\" style=\"table-layout:fixed\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "<table class=\"m_4444567503209527307outer\" width=\"600\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" bgcolor=\"#4255ff\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;font-size:24px;line-height:normal;color:#ffffff;font-weight:bold;padding:24px 0\" align=\"center\">\n"
                    + "      <a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HSz6wnMB50LuEkxjHprkpxwS-2FoRbJBaQEKyvoSIssLKSbETpVtmBNkzXroz6-2Bi5bZ-2F7k-2FoKirNiZ2m-2FRSHvyS6cwUsqjXXD5Bb4FOJZAr-2FNqHZchGfI8X2X1qQ2im0Jmg-3D-3Drs8f_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJz96A5rNegmYuCeb2eV-2F2OkE31kOu6xknVKZb8RJ93Hqsm2Q1S5pz-2BEkLLwGw28K1iHnmMBzm8u-2FWVUFY7kQRo8GuuUeQUhMH74bLKvKt8ejGamgO9qiRcn7ON41egpHVcrEFFqmRSyUdVasD8XVmdM-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HSz6wnMB50LuEkxjHprkpxwS-2FoRbJBaQEKyvoSIssLKSbETpVtmBNkzXroz6-2Bi5bZ-2F7k-2FoKirNiZ2m-2FRSHvyS6cwUsqjXXD5Bb4FOJZAr-2FNqHZchGfI8X2X1qQ2im0Jmg-3D-3Drs8f_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJz96A5rNegmYuCeb2eV-2F2OkE31kOu6xknVKZb8RJ93Hqsm2Q1S5pz-2BEkLLwGw28K1iHnmMBzm8u-2FWVUFY7kQRo8GuuUeQUhMH74bLKvKt8ejGamgO9qiRcn7ON41egpHVcrEFFqmRSyUdVasD8XVmdM-3D&amp;source=gmail&amp;ust=1679337600034000&amp;usg=AOvVaw21DWZPNVF5p_B__e_FwwJM\"><img src=\"https://ci6.googleusercontent.com/proxy/SzNkDgxjiFa2jill6CkH3dxy5OvbPZjDupN21YP2IUSlx2z6Xt6Qzd3_yAZTiVkxt4R9uuXGfFhQGM7y636wfWs2cv3IrE0i118y9ZluTLia7BewCZHj-SeOvYNAwNsFr8poG4PVxRvNTVl6cN0b2hh0WPv119wzxJ41MeNyUTzPCCH9modxGoaV2CWw=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/61030d641f8a53665d8d2d2d/original.png?1627589988\" width=\"112\" alt=\"Quizlet\" style=\"display:block;outline:none!important;margin:0 auto;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a>\n"
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
                    + "  \n"
                    + "  <table bgcolor=\"#F0F0F0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_4444567503209527307em_full_wrap\" style=\"table-layout:fixed\" width=\"100%\">\n"
                    + "    <tbody><tr>\n"
                    + "      <td align=\"center\" bgcolor=\"#F0F0F0\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\" valign=\"top\">\n"
                    + "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_4444567503209527307em_main_table\" style=\"width:600px;table-layout:fixed\" width=\"600\">\n"
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
                    + "                        <td align=\"center\" class=\"m_4444567503209527307em_pad_all_2\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:8px 80px 55px\" valign=\"top\">\n"
                    + "                          \n"
                    + "						              \n"
                    + "                          <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-radius:8px\" width=\"100%\" bgcolor=\"#ffffff\">\n"
                    + "                            <tbody><tr>\n"
                    + "                              <td align=\"left\" class=\"m_4444567503209527307em_pad_none\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:48px 0\" valign=\"top\">\n"
                    + "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:312px\" width=\"77%\">\n"
                    + "                                <tbody><tr>\n"
                    + "                                    <td align=\"left\" class=\"m_4444567503209527307em_pbottom\" style=\"font-size:16px;line-height:24px;padding-bottom:30px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;color:#303545\" valign=\"top\">\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "Xin chào,\n"
                    + "\n"
                    + "\n"
                    + "<br><br>\n"
                    + "Tin tốt đây! " + u.getName() + " muốn chia sẻ tài liệu học Quizlet của họ với bạn. Quizlet giúp bạn tự tin chuẩn bị cho bài kiểm tra, sát hạch hoặc bài tập tiếp theo của mình nhờ tính năng thẻ ghi nhớ, trò chơi và các chế độ học khác.\n"
                    + "<br><br>\n"
                    + "\n"
                    + "\n"
                    + "Thư mục được gọi là " + f.getTitle()
                    + "\n"
                    + "\n"
                    + "<br>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + " </td>\n"
                    + "                            </tr>\n"
                    + "                                  <tr>\n"
                    + "                                    <td align=\"center\" valign=\"top\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">\n"
                    + "                                      <table align=\"center\" bgcolor=\"#0A092D\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-radius:4px;width:100%;max-width:312px\" width=\"100%\">\n"
                    + "                                        <tbody><tr>\n"
                    + "                                          <td align=\"center\" height=\"57\" style=\"height:57px;color:#ffffff;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;font-size:16px;font-weight:600\" valign=\"middle\">\n"
                    + "                                            <a href=" + href + " style=\"color:#ffffff;text-decoration:none;line-height:57px;display:block\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4KJxu-2B5Vy87MeeoFdcZ21wQiC2IT4jRvayagRaq47pb5XvJxp8sBYovVmqXwFvy-2BArsUadUi36dDyNQTt5lN6yw-3DYZRS_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ3Imz6NeccY7GU1JLtJL9c1lfHZU5WrFYw3Fx786CL1b7-2B3c5rdbOwY9m4lg7HVfH3T30EwrH7mcRBcY-2BFedeA5CgAvDPS3g842Oe-2BmTTEk5PZyGJpOyys-2BG2dUR3asfQrIBA-2F23nGfEUzrWM5rrTao-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0GB6OZirXlyHRxt4apWxsH\">Học thư mục này</a>\n"
                    + "                                          </td>\n"
                    + "                                        </tr>\n"
                    + "                                      </tbody></table>\n"
                    + "                                    </td>\n"
                    + "                                  </tr>\n"
                    + "                                  <tr>\n"
                    + "                                    <td align=\"left\" class=\"m_4444567503209527307em_pbottom\" style=\"font-size:16px;line-height:24px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;color:#303545;padding:30px 0 15px\" valign=\"top\">\n"
                    + "          Học, học nữa, học mãi!\n"
                    + "                                  <br>\n"
                    + "                                  </td></tr>\n"
                    + "\n"
                    + "                                </tbody></table>\n"
                    + "                              </td>\n"
                    + "                            </tr>\n"
                    + "                          </tbody></table>\n"
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
                    + "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_4444567503209527307em_full_wrap\" style=\"table-layout:fixed\" bgcolor=\"#F0F0F0\">\n"
                    + "  <tbody><tr>\n"
                    + "    <td align=\"center\" valign=\"top\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"m_4444567503209527307em_main_table\" style=\"width:600px\" bgcolor=\"#ffffff\">\n"
                    + "        <tbody><tr>\n"
                    + "          <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "              <tbody><tr>\n"
                    + "                <td width=\"24\" style=\"width:24px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\">&nbsp;</td>\n"
                    + "                <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif;padding:40px 0 0\"><table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                    <tbody><tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                          <tbody><tr>\n"
                    + "                          <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4B38-2FMELK2A0SVRfjYe28O4lWjwdHCl2Z1SZOY2lFz52Bbel_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ21eZ2PxS2Xo5jDZ-2BUmhYgIqWA1sd0FZn5dHVwhpNt8LyAp1aAhU8UVdV9zEACQgJTShgZB81bfbjKyalDzFFsrbW8kZH8T-2BYMMxyRkjUZ8z9eNitSdqNRmYJXon9I-2BBxw49FbhrV0fyUjqH0-2FCCXX4-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4B38-2FMELK2A0SVRfjYe28O4lWjwdHCl2Z1SZOY2lFz52Bbel_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ21eZ2PxS2Xo5jDZ-2BUmhYgIqWA1sd0FZn5dHVwhpNt8LyAp1aAhU8UVdV9zEACQgJTShgZB81bfbjKyalDzFFsrbW8kZH8T-2BYMMxyRkjUZ8z9eNitSdqNRmYJXon9I-2BBxw49FbhrV0fyUjqH0-2FCCXX4-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw3QpSiIUSP0G4aiyyxaSoQ5\"><img src=\"https://ci4.googleusercontent.com/proxy/GlGV4uKrHHs815RrDdbM-S_LEJpR6Xi3iRxF7SKN8qNpgZFxFL9LsMdNvQN7522szMpQpUYb6MEenSnKJCFaohLZwJFIrbuZj2Vt3KvnKis8ivKeByYVGIoad75WLGBqe3hyiHiPcXbpYUS-FZyhrgeu7Kdjj_yGRXlOOQYxEh9VgUy6i7d42Bz86qE=s0-d-e1-ft#https://braze-images.com/appboy/communication/assets/image_assets/images/63c1c2979522c319972752fe/original.png?1673642647\" width=\"24\" height=\"24\" alt=\"tiktok\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4NHJsO5HXZ4R-2By1vNzmUfxquSwOLQ1UnxTnjL2g-2B0XDbt2An_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJzsX5JgqXmXHanL0P8f-2FzSO7vhACgqweIX-2FSZ72ZocyavWxM-2Bt0lRMTfLCzcXRj8-2F4XKxACg7GqsfHoXUfW4jLcazPk9sKW5AjEk1T19fgNpYaJBIn7dwNIC4un4gs4-2BSxcIb-2F2vUGZTNdzgyCT-2Bp00-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4NHJsO5HXZ4R-2By1vNzmUfxquSwOLQ1UnxTnjL2g-2B0XDbt2An_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJzsX5JgqXmXHanL0P8f-2FzSO7vhACgqweIX-2FSZ72ZocyavWxM-2Bt0lRMTfLCzcXRj8-2F4XKxACg7GqsfHoXUfW4jLcazPk9sKW5AjEk1T19fgNpYaJBIn7dwNIC4un4gs4-2BSxcIb-2F2vUGZTNdzgyCT-2Bp00-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0A84rsmUkmeFa3fH6Aiadu\"><img src=\"https://ci4.googleusercontent.com/proxy/muVdOUYpJtNd4-mbuZSl2VQSMHSo_O9vFDny-DTMb1N4i1-1eoga5P2bLhlOWHw6EHNv7wHiKm8ZLrSzG9foWhxaiE2pOnV4g8LDSC4tpg6LpZK6AFo4YUf_uPIIRXxuIvSqz89R0rH3BLHZG6X2ce8YkbLYmHA4aG5jx8RWGKPp0ivWo5nx84EK8aX8=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7a5ff908527006d389/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"fb\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HTvkruJItaGbSCxHMYqXkqa2L4sZQFdbTBo7BKpYDro-Vgv_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ702hz0mm6AOb3ZXYAZAagEjS-2FKsVASKWu2TTIT1E9ldrye13OX2VwdHCDKZIPOgUHaTlTVV2qIuy5vcpOVpJKV6b8JkxbLivOCVUuRMkJG51nl9v8zE60nehNMw4ThoZC4t36q0NT-2FddjG6DhkpOcw-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HTvkruJItaGbSCxHMYqXkqa2L4sZQFdbTBo7BKpYDro-Vgv_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ702hz0mm6AOb3ZXYAZAagEjS-2FKsVASKWu2TTIT1E9ldrye13OX2VwdHCDKZIPOgUHaTlTVV2qIuy5vcpOVpJKV6b8JkxbLivOCVUuRMkJG51nl9v8zE60nehNMw4ThoZC4t36q0NT-2FddjG6DhkpOcw-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0s6wZW2dFYLdvSsTtOwt4V\"><img src=\"https://ci3.googleusercontent.com/proxy/hcTCxXoV-LYcnZBgWPZAHHBkuJx5WwM7sqYwa9ZI-qupzj6oZvqwgJRy7ZyYpqkixQ2GqctG6dup3bBhZ5RoEMZdVydl_K2-qaJy5uHbbtG2cIOm8kVlquCym4zAn16jsJCXETg4Lf7kST6B9e9Hmjc0tohWdlYgj3OWQmPUQYWFIyddU1MNPagMsy2c=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7a9d7fd53e6dfa22b9/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"insta\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                             <td valign=\"top\" align=\"center\" style=\"padding-right:20px;font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4AclCku5XjKLhmZGAshNJOGg-2BQ8r3rlCdmDGiCVqbZgZAK7VnJt7ISglWCT5PZRWQA-3D-3Di-Y8_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ0NspIoHfPe-2FIe75TKbAOkneZaqB2jVSFBfafqidMLxd3i0U74ERZvr1rF1Go5U7IZjMArrJEwbXHbcQdZ0M5VODoZ17aViHvIWZOBijyJOs81fRC8ikqstpdSLZIFnX0pmxgSN6SUf13CPMkGcxCMs-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4AclCku5XjKLhmZGAshNJOGg-2BQ8r3rlCdmDGiCVqbZgZAK7VnJt7ISglWCT5PZRWQA-3D-3Di-Y8_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ0NspIoHfPe-2FIe75TKbAOkneZaqB2jVSFBfafqidMLxd3i0U74ERZvr1rF1Go5U7IZjMArrJEwbXHbcQdZ0M5VODoZ17aViHvIWZOBijyJOs81fRC8ikqstpdSLZIFnX0pmxgSN6SUf13CPMkGcxCMs-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw1YEb8hch2NRiMupRg1qaq7\"><img src=\"https://ci4.googleusercontent.com/proxy/4s8fvDXDV483OAMawuNNbq5gFvYj3MraOIX7CARZtKUQmYnSVj5r18YZDLmnL7i6Li0yu26TMnRfuetY4UqVNf1oOXmN05EhEQJqr_CTuBxheJjP045gKYXOQzQ-Q0zeeyI1wlAOYgZXsSJrrkz_YBpsmRFNw_hQ8c1XUZA9KRN1zOk-UNy1_KtLY3Ji=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c1b5d79a054c75800e5/original.png?1618250779\" width=\"24\" height=\"24\" alt=\"youtube\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"font-size:0px;line-height:0px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PztVoMs0-2F-2BP1VaGp-2BQzVDqQ7XBohY0-2FRBkaP4PhyzccrvQz_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ8xQen5XTQUsOjGV2icrzQk25vMEkNhmkApq8A1WBD6B8S0C9IxO4Pl64BGNbxjH90NPexSD2AySV4bfDKqHhcyGlkg9R6nNBZlotdIpmeAM10-2F88dYGinmF7j2B3hHuC-2FyEsVbQv74xw5c-2F4kh683Y-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PztVoMs0-2F-2BP1VaGp-2BQzVDqQ7XBohY0-2FRBkaP4PhyzccrvQz_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ8xQen5XTQUsOjGV2icrzQk25vMEkNhmkApq8A1WBD6B8S0C9IxO4Pl64BGNbxjH90NPexSD2AySV4bfDKqHhcyGlkg9R6nNBZlotdIpmeAM10-2F88dYGinmF7j2B3hHuC-2FyEsVbQv74xw5c-2F4kh683Y-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0W4KOr3obQcmP2Iwy6bhzQ\"><img src=\"https://ci6.googleusercontent.com/proxy/IzX34v-nOcyRy92K2H4i6gGqKFhbJCwQQESg3XZ3eoQ1-_27W6YqyD8RfPTRk9R-0DWYChhxs5gKi_DEtpHy65HM7lfSH8VHGba-mOIB7RqX9mLGXQjXKdaZGDsx6lKfDVcKr5Cp3_aD3YDDF2LZApAGF8QMOBO4oK9L3Yp_PXhhIvCTfsrqMXm2e_U8=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/60748c7aef5b9f0cd4d7bdec/original.png?1618250874\" width=\"24\" height=\"24\" alt=\"tw\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;max-width:24px;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
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
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:16px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4K8XPGgUCgm91XlfFjHwlEqEAgvVD3m7Yp3aEy6O7EEsf4I6aHLIfVVg4nJ9IOkmFYkOGdWk0Vovn4qVK8Ghoiau6Bq-2BlpAvnoUNAzVqbqDbh1beBjUpTU3PBxAdp-2BD1CWHOantWy-2FuCa0tC2kLCbX2klqlu2eJ8-2BrJWvFVR3r9gsmfQsZDlPeNScR6c0sWthA-3D-3De_fP_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ9G6AfGhdJypvrM3Cc2M9sshAvw9zAzJ-2BcBl3K2-2FCsVoZ0dkkfq014rxt3o-2Fz-2FsbPLxRo7MHAlxeP9LHm3YWEb4uFBcaj4ZOmzkC2lmBRXVEGmrCCjgANAVM2YTVkkRqlUDgQcSuO7KD-2FtVnJu2GcHk-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4K8XPGgUCgm91XlfFjHwlEqEAgvVD3m7Yp3aEy6O7EEsf4I6aHLIfVVg4nJ9IOkmFYkOGdWk0Vovn4qVK8Ghoiau6Bq-2BlpAvnoUNAzVqbqDbh1beBjUpTU3PBxAdp-2BD1CWHOantWy-2FuCa0tC2kLCbX2klqlu2eJ8-2BrJWvFVR3r9gsmfQsZDlPeNScR6c0sWthA-3D-3De_fP_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ9G6AfGhdJypvrM3Cc2M9sshAvw9zAzJ-2BcBl3K2-2FCsVoZ0dkkfq014rxt3o-2Fz-2FsbPLxRo7MHAlxeP9LHm3YWEb4uFBcaj4ZOmzkC2lmBRXVEGmrCCjgANAVM2YTVkkRqlUDgQcSuO7KD-2FtVnJu2GcHk-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0QGCDhxVonTvooZZDoNxYA\"><img src=\"https://ci6.googleusercontent.com/proxy/z1gVfnC7a4QLiuwVA4p5rYW06Voy5hSYYC7aHP9ZLl39Vfkl4armLDh4pTv5bbTrvgnp8kWzMWdmCKb2Sl-V2ukeYI8zgFSxpXXvM8ZpvQgK17CEPi_t2aHx10b9qo0aKM4Qdxn3a3sHlYoj-EM-QpLGiHfAhU7b9qsT0jxvAtQJ24KC03W4nO0eqNcE=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/5e8cb7acd21f79794861d8f2/original.png?1586280364\" width=\"84\" height=\"28\" alt=\"Download on the App Store\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
                    + "                            <td valign=\"top\" align=\"center\" style=\"padding-right:16px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4I-2F7bl7nLqoNGMm6idWRgS9TL3t8Jj8awpvwi0VrPXYj2CIulRlw69hYwmLEXIgFS61HCz8anOHN-2BWaqmI5QZpUi3xE67W8Ut1L-2BoMaxeohylro6c6YOiv9FtTzfJnVk-2BuIJ64JBi1vwF-2B1pTjV7rOTQFpH-2F3a-2BmqMHxgaxwdGdcrQxtfzozRnwJmpU7B8cpZA-3D-3DaI-__yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ8YKsmv39O5iWUy22eWar12jw3uDGyALhHDHfn-2FO90a6TlLdl8BKhpuvhQy0PzATAplFVjetxbTmX8pDuTloJU8-2FP8LR3AptAeFTbIGTAoFzAR6Y2gOjRyj-2FpU89k7SnbR6ew9EyGgtAc3YqgwBgX6c-3D\" style=\"text-decoration:none;color:inherit\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4I-2F7bl7nLqoNGMm6idWRgS9TL3t8Jj8awpvwi0VrPXYj2CIulRlw69hYwmLEXIgFS61HCz8anOHN-2BWaqmI5QZpUi3xE67W8Ut1L-2BoMaxeohylro6c6YOiv9FtTzfJnVk-2BuIJ64JBi1vwF-2B1pTjV7rOTQFpH-2F3a-2BmqMHxgaxwdGdcrQxtfzozRnwJmpU7B8cpZA-3D-3DaI-__yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ8YKsmv39O5iWUy22eWar12jw3uDGyALhHDHfn-2FO90a6TlLdl8BKhpuvhQy0PzATAplFVjetxbTmX8pDuTloJU8-2FP8LR3AptAeFTbIGTAoFzAR6Y2gOjRyj-2FpU89k7SnbR6ew9EyGgtAc3YqgwBgX6c-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0HP1eWd-O8OEudoeCv8R51\"><img src=\"https://ci3.googleusercontent.com/proxy/KVDfQelQdNuaBU7ZGksDxPPtwK3_cHhN9lmo6e_ExZ_4dcAzPLVGEaCoBxdxJsLhHMGFLp8WsKCudgtWj4YfUY-CnCD03dL81s1xCICQQw0aGuqZRaec0FqN5bJWbc4br36tqD_snoQzqbQ7LJY4GLc2ZruuchxVP-l-6VjAYR62qtoHK61Lg6OcBwhn=s0-d-e1-ft#https://appboy-images.com/appboy/communication/assets/image_assets/images/5e8cb7acaf2cae1ec4d85639/original.png?1586280364\" width=\"84\" height=\"28\" alt=\"GET IT ON Google Play\" border=\"0\" style=\"display:block;font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:17px;color:#000000;outline:none!important;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></td>\n"
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
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2',Arial,sans-serif;font-size:10px;line-height:12px;color:#455358;font-weight:bold\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2BkI5Zngj6l-2F2XVKblG-2By3Ox-2BVuMsfuaT7vQCjEjYdD4KK4bLDVI0V1bxPtMT6napCpzElWAPQ1iQn0B5OheP5VldujLxJiiwaAyPwJbaYdbA-3D-3Di9iU_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ1T4SfoqqcBtLoBPUMWIHtSlcikH1Fo1nCSLbCRdZDfd8mWnLT8IdNtcRvK-2Bt3imkHSttXNumQ8xqXa2mahXcvVxCC4GobjwLd3cEBce-2FuhPROXrHwcKJeOpOiArnfP2TlRvdzfiCTJpQbqHyihgTIc-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4BlHxFu-2BQOMcwrDvBNvIlg-2BkI5Zngj6l-2F2XVKblG-2By3Ox-2BVuMsfuaT7vQCjEjYdD4KK4bLDVI0V1bxPtMT6napCpzElWAPQ1iQn0B5OheP5VldujLxJiiwaAyPwJbaYdbA-3D-3Di9iU_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ1T4SfoqqcBtLoBPUMWIHtSlcikH1Fo1nCSLbCRdZDfd8mWnLT8IdNtcRvK-2Bt3imkHSttXNumQ8xqXa2mahXcvVxCC4GobjwLd3cEBce-2FuhPROXrHwcKJeOpOiArnfP2TlRvdzfiCTJpQbqHyihgTIc-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw0Kn04N9qpej4FjntI5t_Yi\">Trung tâm Hỗ trợ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4HfdzAvpY-2BNqeKH6GJtAuTFQh4iXKvxLCIocG-2FrvijXMWhAURz7QSAQSGrSyBpwaBprdsD0mVj5-2Buj0ATRdiwCHndgmFkOcZZv1ouXvryLdmFepbKmntOHco-2FR0TLuNEQVYHQY-2BTmPu8jvmacpjosk2f9m-2B7l-2Bva4dgPFCoySy4Zg5WLJ-2BkuHjWwSKAhcSlYGw-3D-3D6ZfT_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJx2MixHAvpjnO9WI0CCC7b87-2BztRiWMa-2BinEPqMy35qTqNsLzSqxM7Yb4yEEzgsjSEXubxxe9ZN55St4kuMa1dBq-2FU8rlpkDCSThbGSaf-2BjsHLwouHM23BQLSVaVh0b5zRtCy9VkjmhMGVAI8u98RKk-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4HfdzAvpY-2BNqeKH6GJtAuTFQh4iXKvxLCIocG-2FrvijXMWhAURz7QSAQSGrSyBpwaBprdsD0mVj5-2Buj0ATRdiwCHndgmFkOcZZv1ouXvryLdmFepbKmntOHco-2FR0TLuNEQVYHQY-2BTmPu8jvmacpjosk2f9m-2B7l-2Bva4dgPFCoySy4Zg5WLJ-2BkuHjWwSKAhcSlYGw-3D-3D6ZfT_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJx2MixHAvpjnO9WI0CCC7b87-2BztRiWMa-2BinEPqMy35qTqNsLzSqxM7Yb4yEEzgsjSEXubxxe9ZN55St4kuMa1dBq-2FU8rlpkDCSThbGSaf-2BjsHLwouHM23BQLSVaVh0b5zRtCy9VkjmhMGVAI8u98RKk-3D&amp;source=gmail&amp;ust=1679337600035000&amp;usg=AOvVaw1JKkziMVmb39dYli-50CJi\">Hủy đăng ký theo dõi</a></td>\n"
                    + "                    </tr>\n"
                    + "                                        <tr>\n"
                    + "                      <td valign=\"top\" align=\"center\" style=\"font-family:'Hurme Geometric Sans 2',Arial,sans-serif;font-size:10px;line-height:12px;color:#455358;font-weight:bold\"><a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PGpnPzxUSckOM4ciCqggyLS-2Bd0DE2onD6N-2BoJXWBxClYPTh_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJz6htH8DjXi3zaExxVyCu9BvjKkFvs5ZSR0jPts3cJTuXUrRE6a7JdvdqR2I1ryQQgwwgUHbw16KPpWnm1GDuv2k0L7DDljBXhregSv0a-2Bj9HGy-2BfdwqyIV4Qe31rk1T8QOefWwVI-2FGSqcMIAPVa56s-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PGpnPzxUSckOM4ciCqggyLS-2Bd0DE2onD6N-2BoJXWBxClYPTh_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJz6htH8DjXi3zaExxVyCu9BvjKkFvs5ZSR0jPts3cJTuXUrRE6a7JdvdqR2I1ryQQgwwgUHbw16KPpWnm1GDuv2k0L7DDljBXhregSv0a-2Bj9HGy-2BfdwqyIV4Qe31rk1T8QOefWwVI-2FGSqcMIAPVa56s-3D&amp;source=gmail&amp;ust=1679337600036000&amp;usg=AOvVaw13afg-Pw2PTzdveqrKOicw\">Điều khoản dịch vụ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href=\"https://ablink.account.quizlet.com/ls/click?upn=1ttzInotVPLKQtnqnDVt4PQ0VEULm4DYx0oXJCnM6GhGf2HP9pPFKzO2U0uK2IEmmi7q_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ1UgOIddFBVSk4uP3INhyKkWByyDgcwbWzq6MJhub0K6NA8ccRWp92cq3bA2X0jsnfTo8f-2BsOsCZr-2B8v9bGJhCVpzqSJIJynueFpEF-2BIsQVahhCrNXI0VrbbxWhsnn3vxHxwJe4gEO6auS-2FHGyJ5eDc-3D\" style=\"text-decoration:none;color:#455358\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://ablink.account.quizlet.com/ls/click?upn%3D1ttzInotVPLKQtnqnDVt4PQ0VEULm4DYx0oXJCnM6GhGf2HP9pPFKzO2U0uK2IEmmi7q_yG8cC4-2BxL8WsG4bK-2Ffo6klhJzJQ4ndyjhUt8g8BMBEykgE70MyicFpWuXPAzzwGjuREEz1rDk7KaYt7T0ywPLZ7sqT9q71d6N9DwkrSo1G7lZELebNsz9TaT3h3hbtkvSPu43YijDntEqJTDV5kLm0USrSszlOYWjlo5SGa4cdZ9HcWeAEzhw15eRk2oHvht3gC1bAaF9nf6I-2Fgvi2lr1fxvTiC8PqHnXSMA26ES4ev2KEgh96lL77UEVDBscg3S6tLL-2FpxMMfBZ9RKz9rjwBULRdJekgPEaOipAZr0Uz-2B8SoRp9SbUbcwZTJUB0oHMOdgFVT2Ko6auuvlXCFHAUOsVkNtj7qtDmcleXnoieFNJzBX6aL-2FJkIIxwL6F7zQcgz7cC9FWm763aSL3Iw76N5rPgR1Qkh1l76F-2Fe3ZJ0RkqYkdopyblrn4Ob3lGxfM70XqOFVWyG53ZChZcucBZWCB-2Bkq4lT6SsnkUnhrAA5uuCg-2BQZpEuSSFUaHFoV7AE8vn0CbOtmm3FSho-2FjkBV7oJ1UgOIddFBVSk4uP3INhyKkWByyDgcwbWzq6MJhub0K6NA8ccRWp92cq3bA2X0jsnfTo8f-2BsOsCZr-2B8v9bGJhCVpzqSJIJynueFpEF-2BIsQVahhCrNXI0VrbbxWhsnn3vxHxwJe4gEO6auS-2FHGyJ5eDc-3D&amp;source=gmail&amp;ust=1679337600036000&amp;usg=AOvVaw3_rUmzSH8GF4d9FpUWmHes\">Chính sách quyền riêng tư</a></td>\n"
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
                    + "          <td class=\"m_4444567503209527307em_hide\" style=\"line-height:1px;min-width:600px;font-family:'Hurme Geometric Sans 2','Trebuchet MS',Arial,sans-serif\" bgcolor=\"#ffffff\"><img alt=\"\" src=\"https://ci6.googleusercontent.com/proxy/P6c11i3gpJc_W5S5bdIfR_iqMI5UM3sB5Vfn1XKzpjXvYbmVKLOYHI_KGQ=s0-d-e1-ft#http://images/spacer.gif\" height=\"1\" width=\"600\" style=\"max-height:1px;min-height:1px;display:block;width:600px;min-width:600px;outline:none!important;border:0\" border=\"0\" class=\"CToWUd\" data-bit=\"iit\" jslog=\"138226; u014N:xr6bB; 53:W2ZhbHNlLDJd\"></td>\n"
                    + "        </tr>\n"
                    + "      </tbody></table></td>\n"
                    + "  </tr>\n"
                    + "</tbody></table>\n"
                    + "\n"
                    + "</td></tr></tbody></table>";
            message.setContent(share, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
