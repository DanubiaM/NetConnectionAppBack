package netconnection.app.back.domain.model.company;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model._shared.Address;

public class CNPJ {
    String number;

    String corporateName;

    Address address;

    STATUS_COMPANY status;

    public CNPJ(String _number, String _corporateName, Address _address, STATUS_COMPANY _status){
       this.number = _number;
       this.corporateName = _corporateName;
       this.address = _address;
       this.status = _status;

       this.validate();

    }

    private void validate() {

        if(!this.validadeNumber()) {
            throw new IllegalArgumentException("Invalid CNPJ number");
        }

        if(StringUtils.isEmpty(this.corporateName)){
            throw new IllegalArgumentException("Corporate Name is not valid");
        }

        if(this.status == null){
            throw new IllegalArgumentException("Status is not valid");
        }
    }

    private boolean validadeNumber() {

        if(StringUtils.isEmpty(this.number)) return false;

        this.number = this.number.replaceAll("[\\./\\-]", "");


        if (this.number.equals("00000000000000") || this.number.equals("11111111111111") ||
                this.number.equals("22222222222222") || this.number.equals("33333333333333") ||
                this.number.equals("44444444444444") || this.number.equals("55555555555555") ||
                this.number.equals("66666666666666") || this.number.equals("77777777777777") ||
                this.number.equals("88888888888888") || this.number.equals("99999999999999") ||
                (this.number.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {

                num = (int)(this.number.charAt(i) - 48);
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
                num = (int)(this.number.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == this.number.charAt(12)) && (dig14 == this.number.charAt(13)))
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
