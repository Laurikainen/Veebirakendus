package TronGame.Tron.Entities;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {

    public void sendEmail(String email) {

        System.out.println(email);
        
        final String username = System.getenv("email_user");
        final String password = System.getenv("email_password");

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tron.online.heroku@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, true));
            message.setSubject("Tron Online login");
            String msg = "Your profile picture has been changed on Tron Online (https://tron-online.herokuapp.com)";
            message.setText(msg);
            Transport.send(message);
        }
        catch (MessagingException e) {
            System.out.println(e);
        }
    }
}
