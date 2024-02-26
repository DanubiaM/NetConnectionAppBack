package netconnection.app.back.domain.model._shared;

public abstract class ValueObject {
    protected NotificationInterface notification;

    public ValueObject(NotificationInterface notification){
        this.notification = notification;
    }

}
