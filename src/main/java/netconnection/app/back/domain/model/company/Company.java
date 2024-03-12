package netconnection.app.back.domain.model.company;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.Entity;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.validation.Notification;

import java.util.UUID;

public class Company extends Entity {

    private String id;
    private CNPJ cnpj;
    private String name;
    private Phone phone;
    private String email;

    public Company(String _id, CNPJ _cnpj, String _name, Phone _phone, String _email){
        super(_id, new Notification());

        this.setCnpj(_cnpj);
        this.setName(_name);
        this.setPhone(_phone);
        this.setEmail(_email);

    }

    private void setCnpj(CNPJ cnpj) {
        if(cnpj == null){
            this.notification.addError("CNPJ must not be null");
            return;
        }
        if(cnpj.isDisable()){
            this.notification.addError("CNPJ must not be disable");
        }
        this.cnpj = cnpj;
    }

    private void setName(String name) {
        if(name == null){
            this.notification.addError("Name must not be null");
            return;
        }
        if(StringUtils.isEmpty(name)) {
            this.notification.addError("Name must not be empty");
        }
        this.name = name;
    }

    private void setPhone(Phone phone) {
        if(phone == null){
            this.notification.addError("Phone must not be null");
        }
        this.phone = phone;
    }

    private void setEmail(String email) {

        if (email == null) {
            this.notification.addError("Email must not be null");
            return;
        }

        if(StringUtils.isEmpty(email)){
            this.notification.addError("Email must not be empty");

        }

        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            this.notification.addError("Email format invalid");
        }

        this.email = email;
    }




    public String getId() {
        return this.id;
    }

    public Phone getPhoneNumber() {
        return this.phone;
    }

    public void updatePhoneNumber(Phone newPhoneNumber) {
        this.phone = newPhoneNumber;
    }

    public String getCNPJNumber() {
        return this.cnpj.number;

    }
}
