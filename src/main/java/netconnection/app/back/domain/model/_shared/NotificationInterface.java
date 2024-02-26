package netconnection.app.back.domain.model._shared;

public interface NotificationInterface {
    public void addError(String message);

    public void addError(String message, Exception e);

    public boolean hasErrors();
    public String errorMessage();

}
