package ro.creativewool.notificationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)

    public class UnprocessableEntity extends RuntimeException {
    private List<ValidationFail> fails;

    public UnprocessableEntity(List<ValidationFail> fails) {
        this.fails = fails;
    }
    public List<ValidationFail> getFails() {
        return fails;
    }

    @Override
    public String getMessage() {
        return Arrays.toString(fails.toArray());
    }
}

