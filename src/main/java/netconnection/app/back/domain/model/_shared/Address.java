package netconnection.app.back.domain.model._shared;


import io.micrometer.common.util.StringUtils;

public class Address extends ValueObject{
    private String description;

    private String complement;

    private String city;

    private String cep;

    public Address(String _description, String _complement, String _city, String _cep) {
        super(new Notification());

        this.setDescription(_description);
        this.setComplement(_complement);
        this.setCity(_city);
        this.setCep(_cep);


    }

    private void setDescription(String description) {
        if(StringUtils.isEmpty(description) ){
            this.notification.addError("Description must not be empty");
        }
        this.description = description;
    }

    private void setComplement(String complement) {
        if(StringUtils.isEmpty(complement)){
            this.notification.addError("Complement must not be empty");
        }
        this.complement = complement;
    }

    private void setCity(String city) {
        if(StringUtils.isEmpty(city)){
            this.notification.addError("City must not be empty");
        }
        this.city = city;
    }

    private void setCep(String cep) {
        if(StringUtils.isEmpty(cep)){
            this.notification.addError("CEP must not be empty");
        }
        if(!isCEPValid(cep)){
            this.notification.addError("Invalid Format CEP");
        }
        this.cep = cep;
    }

    private boolean isCEPValid(String cep) {

        if (!cep.contains("-")) {
            cep = this.cep.substring(0, 5) + "-" + cep.substring(5);
        }
        return cep.matches("\\d{5}-\\d{3}");
    }


}
