package netconnection.app.back.application.dtos;

import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CPF;

import java.time.LocalDate;

public record ClientDTO(String name, String email, String cpf, LocalDate emission,String phone, String description,
                        String complement, String city, String cep) {
}
