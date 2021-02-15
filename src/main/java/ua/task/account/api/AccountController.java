package ua.task.account.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.task.account.dto.AccountDto;
import ua.task.account.model.Account;
import ua.task.account.service.AccountService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping("/account")
    public Id newAccount(@RequestBody @Valid AccountDto dto) {
        return new Id(service.newAccount(dto).toString());
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable UUID id) {
        return service.getAccount(id);
    }

    @PutMapping("/account/{id}")
    public Account putAccount(@RequestBody AccountDto dto, @PathVariable("id") UUID id) {
        var account = Account.fromDto(dto);
        account.setId(id);
        return service.update(account);
    }

    @PostMapping("/account/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
