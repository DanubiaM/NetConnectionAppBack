package netconnection.app.back.application.dtos;

import java.time.LocalDate;

public record CustomerDTO(String name, String email, String cpf, LocalDate emission, String phone, String description,
                          String complement, String city, String cep) {
}
