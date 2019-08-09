package ro.creativewool.notificationservice.helper;

import org.springframework.stereotype.Component;

@Component
public class StringsHelper {

    public boolean isNullorEmpty(String string) {
            return string == null || string.replaceAll ( " ", " " ).equals ("");
    }
}
