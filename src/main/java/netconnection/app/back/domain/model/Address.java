package netconnection.app.back.domain.model;

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

    private void validate() {
        if(this.description.isEmpty()){
            throw new IllegalArgumentException("Description must not be empty");
        }

        if(this.complement.isEmpty()){
            throw new IllegalArgumentException("Complement must not be empty");
        }

        if(this.city.isEmpty()){
            throw new IllegalArgumentException("City must not be empty");
        }
        if(this.cep.isEmpty()){
            throw new IllegalArgumentException("CEP must not be empty");
        }
        if(this.cep.matches("\\d{5}-\\d{3}")){
            throw new IllegalArgumentException("Formatter CEP invalid");
        }

    }
}
