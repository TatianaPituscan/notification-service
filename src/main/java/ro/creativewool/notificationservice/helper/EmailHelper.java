package ro.creativewool.notificationservice.helper;

import org.springframework.stereotype.Component;
import ro.creativewool.notificationservice.data.EmailRequest;
import ro.creativewool.notificationservice.properties.EmailProperties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Component
public class EmailHelper {

    public Message createMessage(EmailRequest emailRequest, Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress (emailRequest.getFrom()));
        message.setRecipients (
                Message.RecipientType.TO, InternetAddress.parse(emailRequest.getTo()));
        message.setSubject(emailRequest.getSubject());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(emailRequest.getMessage(),"text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        return message;
    }

    public Session createSession(EmailProperties properties) {
        return Session.getInstance(properties.toProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getUsername(), properties.getPassword());
            }

        });
    }
}