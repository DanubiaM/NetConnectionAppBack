package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.Entity;
import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.validation.Notification;

public class Customer extends Entity {

    private Name name;

    private String email;

    private CPF cpf;

    private Phone phone;

    private Address address;


    public Customer(String _id, Name _name, String _email, CPF _cpf, Phone _phone, Address _address){
        super(_id, new Notification());
        this.setName(_name);
        this.setEmail(_email);
        this.setCpf(_cpf);
        this.setPhone(_phone);
        this.setAddress(_address);

        valid();
    }

    private void valid() {
        if(notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());
    }



    private void setName(Name name) {
        if(name == null){
            notification.addError("Name must not be null");

        }
        this.name = name;
    }

    private void setEmail(String email) {
        if(StringUtils.isEmpty(email)){
            notification.addError("E-mail must not be empty");

        }
        this.email = email;
    }

    private void setCpf(CPF cpf) {

        if(cpf == null){
            notification.addError("CPF must not be null");

        }
        this.cpf = cpf;
    }

    private void setPhone(Phone phone) {
        if(phone == null){
            notification.addError("Phone number must not be empty");

        }
        this.phone = phone;
    }

    private void setAddress(Address address) {
        if(address == null){
            notification.addError("Address number must not be empty");

        }
        this.address = address;
    }



    public Address getAddress() {
        return address;
    }


}
