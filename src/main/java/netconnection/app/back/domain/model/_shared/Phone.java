package netconnection.app.back.domain.model._shared;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.ValueObject;
import netconnection.app.back.domain.model.validation.Notification;

public class Phone extends ValueObject {

    private String phoneOne;
    private String phoneTwo;
    private String phoneThree;

    public Phone (String phoneOne){
        super(new Notification());
        this.setPhoneOne(phoneOne);

    }

    public Phone (String phoneOne, String phoneTwo){
        super(new Notification());
        this.setPhoneOne(phoneOne);
        this.setPhoneTwo(phoneTwo);


    }

    public Phone (String phoneOne, String phoneTwo , String phoneThree){
        super(new Notification());
        this.setPhoneOne(phoneOne);
        this.setPhoneTwo(phoneTwo);
        this.setPhoneThree(phoneThree);

    }

    private void setPhoneOne(String phoneOne) {
        if (StringUtils.isEmpty(phoneOne)) {
            this.notification.addError("Phone Number One should not be empty");
            return;
        }
        if (!isNumberValid(phoneOne)) this.notification.addError("Ilegal Phone Number One");

        this.phoneOne = phoneOne;
    }

    private void setPhoneTwo(String phoneTwo) {
        if ( StringUtils.isEmpty(phoneTwo)){
            this.notification.addError("Phone Number Two should not be empty");
            return;
        }
        if (!isNumberValid(phoneTwo)) this.notification.addError("Ilegal Phone Number Two");

        this.phoneTwo = phoneTwo;
    }

    private void setPhoneThree(String phoneThree) {
        if (  StringUtils.isEmpty(phoneThree)){
            this.notification.addError("Phone Number Three should not be empty");
            return;
        }
        if (!isNumberValid(phoneThree)) this.notification.addError("Ilegal Phone Number Three");

        this.phoneThree = phoneThree;
    }

    private boolean isNumberValid(String number){
        //remove qualquer caracter, coloca dentro do padrão e verifica se é valido.
        number = number.replaceAll("/\\D/g", "");

       if (number.length() != 11) return false;

       return true;

    }


}
