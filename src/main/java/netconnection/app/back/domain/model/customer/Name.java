package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;

public class Name {

    private String firstName;

    private String secondName;

    private String thirdName;

    public Name(String _first, String _secondName, String _thirdName){
        this.setFirstName(_first);
        this.setSecondName(_secondName);
        this.setThirdName(_thirdName);
    }

    public Name(String _first, String _thirdName){
        this.setFirstName(_first);
        this.setThirdName(_thirdName);
    }


    private void setFirstName(String firstName) {
        if(StringUtils.isEmpty(firstName)) throw new IllegalArgumentException("Fist Name must not be empty");
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        if(StringUtils.isEmpty(secondName)) throw new IllegalArgumentException("Second Name must not be empty");

        this.secondName = secondName;
    }

    private void setThirdName(String thirdName) {
        if(StringUtils.isEmpty(thirdName)) throw new IllegalArgumentException("third Name must not be empty");
        this.thirdName = thirdName;
    }
}
