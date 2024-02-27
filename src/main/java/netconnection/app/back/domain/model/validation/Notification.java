package netconnection.app.back.domain.model.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notification implements NotificationInterface{
    private List<Error> errors = new ArrayList<>();


    @Override
    public void addError(String message) {
        addError(message, null);
    }

    @Override
    public void addError(String message, Exception e) {
        errors.add(new Error(message, e));
    }

    @Override
    public boolean hasErrors() {
        return ! errors.isEmpty();
    }

    @Override
    public String errorMessage() {
        return errors.stream()
                .map(e -> e.message)
                .collect(Collectors.joining(", "));
    }

    private static class Error {
        String message;
        Exception cause;

        private Error(String message, Exception cause) {
            this.message = message;
            this.cause = cause;
        }
    }
}
