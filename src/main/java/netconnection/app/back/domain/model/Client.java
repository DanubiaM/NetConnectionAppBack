package netconnection.app.back.domain.model;

import lombok.Getter;

public class Client {

    private String id;
    private String name;

    private String email;

    private CPF cpf;

    private String phone;

    private Address address;

    public Client(){

    }

    public Client(String _id, String _name, String _email, CPF _cpf, String _phone, Address _address){
        this.id = _id;
        this.name = _name;
        this.email = _email;
        this.cpf = _cpf;
        this.phone= _phone;
        this.address =_address;


        this.validate();

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }



    private void validate() {
        if(this.id.isEmpty()){
            throw new IllegalArgumentException("ID must not be empty");

        }
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("Name must not be empty");

        }
        if (this.email.isEmpty()){
            throw new IllegalArgumentException("Email must not be empty");

        }
        if(this.phone.isEmpty()){
            throw new IllegalArgumentException("Phone number must not be empty");

        }
    }

}
