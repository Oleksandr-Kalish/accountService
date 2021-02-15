package ua.task.account.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import ua.task.account.dto.AccountDto;
import ua.task.account.model.Account;
import ua.task.account.repositary.AccountRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    @Transactional
    public UUID newAccount(AccountDto dto) {
        return repository.save(Account.fromDto(dto)).getId();
    }

    public Account getAccount(UUID id) {
        return repository.getOne(id);
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    public Account update(Account account) {
        var byId = repository.findById(account.getId());
        if (byId.isPresent()) {
            return repository.save(account);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }
}
