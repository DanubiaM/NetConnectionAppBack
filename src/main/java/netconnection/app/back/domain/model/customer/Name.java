package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.ValueObject;
import netconnection.app.back.domain.model.validation.Notification;

public class Name extends ValueObject {

    private String firstName;

    private String secondName;

    private String thirdName;

    public Name(String _first, String _secondName, String _thirdName){
        super(new Notification());
        this.setFirstName(_first);
        this.setSecondName(_secondName);
        this.setThirdName(_thirdName);
        valid();
    }

    public Name(String _first, String _thirdName){
        super(new Notification());
        this.setFirstName(_first);
        this.setThirdName(_thirdName);
        valid();
    }

    private void valid() {
        if(notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());
    }

    private void setFirstName(String firstName) {
        if(StringUtils.isEmpty(firstName)) notification.addError("Fist Name must not be empty");
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        if(StringUtils.isEmpty(secondName)) notification.addError("Second Name must not be empty");

        this.secondName = secondName;
    }

    private void setThirdName(String thirdName) {
        if(StringUtils.isEmpty(thirdName)) notification.addError("third Name must not be empty");
        this.thirdName = thirdName;
    }
}
