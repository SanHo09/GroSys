/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sang
 */
public class Xmail {
    private final String APP_EMAIL = "sangpvps18851@fpt.edu.vn";
    private final String APP_PASSWORD = "tmxrybxpksaxohxw";

    public String getAPP_EMAIL() {
        return APP_EMAIL;
    }

    public String getAPP_PASSWORD() {
        return APP_PASSWORD;
    }
    
    public static void sendMail(String RECEIVE, String subject, String message) {
        Xmail mail = new Xmail();
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth","true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.port", 587);
            Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mail.getAPP_EMAIL(), mail.getAPP_PASSWORD());
                    }
                });
            MimeMessage mess = new MimeMessage(session);
            mess.setRecipients(Message.RecipientType.CC, InternetAddress.parse(RECEIVE));
            mess.setSubject(subject);
            mess.setText(message);

            Transport.send(mess);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
