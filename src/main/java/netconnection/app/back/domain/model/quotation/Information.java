package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.ValueObject;
import netconnection.app.back.domain.model.validation.Notification;

public class Information  extends ValueObject {
    private String title;
    private String description;

    public Information (String _title, String _description){
        super(new Notification());
        this.setDescription(_description);
        this.setTitle(_title);

        valid();
    }
    private void valid() {
        if(this.notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());

    }

    private void setTitle(String title) {
        if(StringUtils.isEmpty(title)) notification.addError("Title must not be empty");
        this.title = title;
    }

    private void setDescription(String description) {
        if(StringUtils.isEmpty(description)) notification.addError("Description must not be empty");

        this.description = description;
    }
}
