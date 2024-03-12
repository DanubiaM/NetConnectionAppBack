package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;

public class Customer {

    private String id;
    private Name name;

    private String email;

    private CPF cpf;

    private Phone phone;

    private Address address;


    public Customer(String _id, Name _name, String _email, CPF _cpf, Phone _phone, Address _address){
        this.setId(_id);
        this.setName(_name);
        this.setEmail(_email);
        this.setCpf(_cpf);
        this.setPhone(_phone);
        this.setAddress(_address);

    }

    private void setId(String id) {
        if(StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("ID must not be empty");
        }
        this.id = id;
    }

    private void setName(Name name) {
        if(name == null){
            throw new IllegalArgumentException("Name must not be null");

        }
        this.name = name;
    }

    private void setEmail(String email) {
        if(StringUtils.isEmpty(email)){
            throw new IllegalArgumentException("E-mail must not be empty");

        }
        this.email = email;
    }

    private void setCpf(CPF cpf) {

        if(cpf == null){
            throw new IllegalArgumentException("CPF must not be null");

        }
        this.cpf = cpf;
    }

    private void setPhone(Phone phone) {
        if(phone == null){
            throw new IllegalArgumentException("Phone number must not be empty");

        }
        this.phone = phone;
    }

    private void setAddress(Address address) {
        if(address == null){
            throw new IllegalArgumentException("Address number must not be empty");

        }
        this.address = address;
    }

    public String getId() {
        return id;
    }


    public Address getAddress() {
        return address;
    }


}
