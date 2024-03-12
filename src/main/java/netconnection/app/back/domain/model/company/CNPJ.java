package netconnection.app.back.domain.model.company;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model.validation.Notification;
import netconnection.app.back.domain.model.ValueObject;

public class CNPJ extends ValueObject {
    String number;

    String corporateName;

    Address address;

    STATUS_COMPANY status;

    public CNPJ(String _number, String _corporateName, Address _address, STATUS_COMPANY _status){
        super(new Notification());
       this.setNumber(_number);
       this.setCorporateName(_corporateName);
       this.setAddress(_address);
       this.setStatus(_status);


    }

    private void setNumber(String number) {
        if(StringUtils.isEmpty(number)) {
            this.notification.addError("CNPJ number should not be empty.");
            return ;
        }
        if(!this.validadeNumber(number)) this.notification.addError("Invalid CNPJ number.");

        this.number = number;
    }

    private void setCorporateName(String corporateName) {
        if(StringUtils.isEmpty(corporateName)) this.notification.addError("Corporate Name is not valid.");

        this.corporateName = corporateName;
    }

    private void setAddress(Address address) {
        if(address == null) this.notification.addError("Address should not be null.");

        this.address = address;
    }

    private void setStatus(STATUS_COMPANY status) {
        if(status == null)this.notification.addError("Status should not be null.");

        this.status = status;
    }



    private boolean validadeNumber(String number) {



        number = number.replaceAll("[\\./\\-]", "");


        if (number.equals("00000000000000") || number.equals("11111111111111") ||
                number.equals("22222222222222") || number.equals("33333333333333") ||
                number.equals("44444444444444") || number.equals("55555555555555") ||
                number.equals("66666666666666") || number.equals("77777777777777") ||
                number.equals("88888888888888") || number.equals("99999999999999") ||
                (number.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {

                num = (int)(number.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(number.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == number.charAt(12)) && (dig14 == number.charAt(13)))
                return(true);
            else return(false);
        } catch (RuntimeException erro) {
            return(false);
        }
    }


    public boolean isDisable() {
        return  this.status.equals(STATUS_COMPANY.DISABLE);
    }


}
