package netconnection.app.back.domain.model.customer;

import io.micrometer.common.util.StringUtils;

import java.time.LocalDate;

public class CPF {

    private String number;
    private LocalDate emission;

    public CPF(String _number, LocalDate _emission) {
        this.number = _number;
        this.emission = _emission;

        this.validate();
    }

    private void validate() {

        if (!this.isNumberValid()) {
            throw new IllegalArgumentException("CPF not is valid");
        }

        if (this.emission == null){
            throw new IllegalArgumentException("Emission Date must not be empty");
        }
    }

    private boolean isNumberValid() {

        if(StringUtils.isEmpty(this.number)) return false;

        // Remover caracteres não numéricos
        this.number = this.number.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (this.number.length() != 11)
            return false;

        // Verificar se todos os dígitos são iguais
        if (this.number.matches("(\\d)\\1{10}"))
            return false;

        // Calcular e verificar o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(this.number.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;
        if (digitoVerificador1 != Character.getNumericValue(this.number.charAt(9)))
            return false;

        // Calcular e verificar o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(this.number.charAt(i)) * (11 - i);
        }

        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;
        if (digitoVerificador2 != Character.getNumericValue(this.number.charAt(10)))
            return false;

        return true;
    }


}
