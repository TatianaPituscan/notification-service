package ro.creativewool.notificationservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.creativewool.notificationservice.data.EmailRequest;
import ro.creativewool.notificationservice.repository.EmailRepository;
import ro.creativewool.notificationservice.service.EmailService;
import ro.creativewool.notificationservice.service.EmailValidatorService;

@RequestMapping("email")
@RestController
public class EmailController {

    private EmailService emailService;
    private EmailRepository emailRepository;
    private EmailValidatorService emailValidatorService;

    public EmailController(EmailService emailService, EmailRepository emailRepository, EmailValidatorService emailValidatorService) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
        this.emailValidatorService = emailValidatorService;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailValidatorService.validate(emailRequest);

        return emailService.register(emailRequest).getId();
    }

        @GetMapping("{id}")
        public EmailRequest getByID(@PathVariable String id) {
            return emailRepository.getById(id);
        }

}
