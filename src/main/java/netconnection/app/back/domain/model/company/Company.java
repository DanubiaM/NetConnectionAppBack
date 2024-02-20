package netconnection.app.back.domain.model.company;

import io.micrometer.common.util.StringUtils;

import java.util.UUID;

public class Company {

    private String id = UUID.randomUUID().toString();
    private CNPJ cnpj;
    private String name;
    private String phone;
    private String email;

    public Company(CNPJ _cnpj, String _name, String _phone, String _email){
        this.cnpj = _cnpj;
        this.name = _name;
        this.phone = _phone;
        this.email = _email;

        this.validate();

    }

    private void validate() {

        if(this.cnpj.isDisable()){
            throw new IllegalArgumentException("CNPJ must not be disable");
        }

        if(StringUtils.isEmpty(this.name)){
            throw new IllegalArgumentException("Name must not be empty");
        }

        if(StringUtils.isEmpty(this.phone)){
            throw new IllegalArgumentException("Phone must not be empty");
        }

        if(StringUtils.isEmpty(this.email)){
            throw new IllegalArgumentException("Email must not be empty");
        }


    }


    public String getId() {
        return this.id;
    }
}
