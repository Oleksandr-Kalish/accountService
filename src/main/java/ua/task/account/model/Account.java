package ua.task.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import ua.task.account.dto.AccountDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstName;
    private String last_name;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    public static Account fromDto(AccountDto dto) {
        var account = new Account();
        account.id = UUID.randomUUID();
        account.birthDate = dto.getBirthDate();
        account.firstName = dto.getFirstName();
        account.last_name = dto.getLast_name();
        account.maritalStatus = dto.getMaritalStatus();
        return account;
    }
}
