package netconnection.app.back.domain.model;


import io.micrometer.common.util.StringUtils;

public class Address {
    private String description;

    private String complement;

    private String city;

    private String cep;

    public Address(String _description, String _complement, String _city, String _cep) {
        this.description = _description;
        this.complement = _complement;
        this.city = _city;
        this.cep = _cep;

        this.validate();

    }

    private boolean isCEPValid() {

        if (!this.cep.contains("-")) {
            this.cep = this.cep.substring(0, 5) + "-" + this.cep.substring(5);
        }
        return this.cep.matches("\\d{5}-\\d{3}");
    }

    private void validate() {
        if(StringUtils.isEmpty(this.description) ){
            throw new IllegalArgumentException("Description must not be empty");
        }

        if(StringUtils.isEmpty(this.complement)){
            throw new IllegalArgumentException("Complement must not be empty");
        }

        if(StringUtils.isEmpty(this.city)){
            throw new IllegalArgumentException("City must not be empty");
        }
        if(StringUtils.isEmpty(this.cep)){
            throw new IllegalArgumentException("CEP must not be empty");
        }
        if(!isCEPValid()){
            throw new IllegalArgumentException("Formatter CEP invalid");
        }

    }
}
