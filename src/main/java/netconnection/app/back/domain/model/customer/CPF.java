package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;

import java.time.LocalDate;

public class CPF {

    private String number;
    private LocalDate emission;

    public CPF(String _number, LocalDate _emission) {
        this.setNumber(_number);
        this.setEmission(_emission);

    }

    private void setNumber(String number) {
        if(StringUtils.isEmpty(number)) throw new IllegalArgumentException("CPF not must be null");

        if (!this.isNumberValid(number)) throw new IllegalArgumentException("CPF not is valid");

        this.number = number;
    }

    private void setEmission(LocalDate emission) {
        if (emission == null){
            throw new IllegalArgumentException("Emission Date must not be empty");
        }
        this.emission = emission;
    }


    private boolean isNumberValid(String number) {


        // Remover caracteres não numéricos
        number = number.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (number.length() != 11)
            return false;

        // Verificar se todos os dígitos são iguais
        if (number.matches("(\\d)\\1{10}"))
            return false;

        // Calcular e verificar o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(number.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;
        if (digitoVerificador1 != Character.getNumericValue(number.charAt(9)))
            return false;

        // Calcular e verificar o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(number.charAt(i)) * (11 - i);
        }

        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;
        if (digitoVerificador2 != Character.getNumericValue(number.charAt(10)))
            return false;

        return true;
    }


}
