package ro.creativewool.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.creativewool.notificationservice.helper.EmailHelper;
import ro.creativewool.notificationservice.properties.EmailProperties;
import ro.creativewool.notificationservice.repository.EmailRepository;
import ro.creativewool.notificationservice.data.EmailRequest;

import javax.mail.*;
import javax.mail.MessagingException;

@Service
public class EmailService {

    private Logger log = LoggerFactory.getLogger(getClass());
    private EmailRepository emailRepository;
    private EmailHelper emailHelper;
    private EmailProperties emailProperties;

    public EmailService(EmailRepository emailRepository, EmailHelper emailHelper, EmailProperties emailProperties) {
        this.emailRepository = emailRepository;
        this.emailHelper = emailHelper;
        this.emailProperties = emailProperties;
    }

    public EmailRequest register(EmailRequest emailRequest) {
        emailRequest = emailRepository.save(emailRequest);

        try {
            sendEmail(emailRequest);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }
        return emailRequest;
    }

    private void sendEmail(EmailRequest emailRequest) throws MessagingException {
        Session session = emailHelper.createSession(emailProperties);
        Message message = emailHelper.createMessage(emailRequest, session);

        Transport.send(message);
    }

}
