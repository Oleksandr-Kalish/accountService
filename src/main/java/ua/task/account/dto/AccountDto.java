package ua.task.account.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import ua.task.account.model.MaritalStatus;

import javax.validation.constraints.Email;
import java.time.LocalDate;

@Data
@Builder
public class AccountDto {
    @NonNull
    private String firstName;
    @NonNull
    @Email
    private String email;
    @NonNull
    private String last_name;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private MaritalStatus maritalStatus;
}
