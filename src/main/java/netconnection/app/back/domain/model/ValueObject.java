package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.validation.NotificationInterface;

public abstract class ValueObject {
    protected NotificationInterface notification;

    public ValueObject(NotificationInterface notification){
        this.notification = notification;
    }

    public boolean hasError(){
        return notification.hasErrors();
    }

    public String errorMessages(){
        return notification.errorMessage();
    }

}
