import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class JavaMailUtil {
public static void sendMail(String recepient, String id, String authId) throws Exception {

    Properties properties=new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    String myAccountEmail="ehealthcaremanagementsystem@gmail.com";
    String password="tekciejizalgbjnb";
    Session session=Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
        }
    });
    
    Message message=prepareMessage(session,myAccountEmail,recepient, id, authId);
    Transport.send(message);
    System.out.println("Message Sent successfully");
}

private static Message prepareMessage(Session session,String from,String to, String id, String authId) {
    Message message = new MimeMessage(session);
    try {
        
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Your ID no");
        message.setText("Hello, "+id+" is your ID no, and auth code is "+authId+" please enter those on the fields and remember for future use!");
        return message;
    } catch (AddressException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}