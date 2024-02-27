package netconnection.app.back.domain.model;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.validation.Notification;
import netconnection.app.back.domain.model.validation.NotificationInterface;


public class Entity {
    private String id;
    protected NotificationInterface notification;

    public Entity(String id, NotificationInterface notificationInterface) {
        this.id = id;
        this.notification = notificationInterface;
    }

    public boolean hasError(){
        return notification.hasErrors();
    }

    public String errorMessages(){
        return notification.errorMessage();
    }

    private void setId(String id) {
        if(StringUtils.isEmpty(id) ){
            notification.addError("ID should not be empty");
        }
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id != null ? id.equals(entity.id) : entity.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }





}
