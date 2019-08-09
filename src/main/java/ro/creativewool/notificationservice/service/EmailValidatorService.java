package ro.creativewool.notificationservice.service;

import org.springframework.stereotype.Service;
import ro.creativewool.notificationservice.data.EmailRequest;
import ro.creativewool.notificationservice.exception.UnprocessableEntity;
import ro.creativewool.notificationservice.exception.ValidationFail;
import ro.creativewool.notificationservice.helper.StringsHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailValidatorService {

    private StringsHelper stringsHelper;
    private String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

   public EmailValidatorService(StringsHelper stringsHelper) {
    this.stringsHelper = stringsHelper;
   }

    public void validate(EmailRequest emailRequest) {
        List<ValidationFail> fails = new ArrayList<>();

        if (stringsHelper.isNullOrEmpty(emailRequest.getTo())) {
            fails.add(new ValidationFail("to", "cannot be null or empty"));
        } else if (!emailRequest.getTo().matches(emailRegex)) {
            fails.add((new ValidationFail("to", "does not seems to be a e-mail address")));
        }

        if (stringsHelper.isNullOrEmpty(emailRequest.getFrom())) {
            fails.add(new ValidationFail("from", "cannot be null or empty"));
        } else if (!emailRequest.getFrom().matches(emailRegex)) {
            fails.add((new ValidationFail("from", "does not seems to be a e-mail address")));
        }

        if (stringsHelper.isNullOrEmpty(emailRequest.getSubject())) {
            fails.add(new ValidationFail("subject", "cannot be null or empty"));
        }

        if (stringsHelper.isNullOrEmpty(emailRequest.getMessage())) {
            fails.add(new ValidationFail("message", "cannot be null or empty"));
        }

        if (fails.size() > 0) {
            throw new UnprocessableEntity(fails);
        }
    }
}
