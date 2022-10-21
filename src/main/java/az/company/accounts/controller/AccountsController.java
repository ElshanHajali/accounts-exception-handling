package az.company.accounts.controller;

import az.company.accounts.model.request.AccountsRequest;
import az.company.accounts.model.response.AccountsResponse;
import az.company.accounts.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    //////////////Fetch////////////////////
    @GetMapping
    public List<AccountsResponse> getAccounts() {
        return accountsService.getAccounts();
    }

    @GetMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountsResponse findAccountById(@PathVariable("accountId") long id) {
        return accountsService.getAccount(id);
    }

    @GetMapping("/headers")
    public Map<String, String> getHeader(
            @RequestHeader Map<String, String> header
    ) {
        return header;
    }

    @GetMapping("/customers/{customerId}")
    public List<AccountsResponse> getAccountByCustomerId(
            @PathVariable("customerId") long id,
            @RequestParam(value = "account-type") String accountType
    ) {
        return accountsService.getAccountsByCustomer(id, accountType);
    }

    //////////////Management////////////////////
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(
            @Valid @RequestBody AccountsRequest request
    ) {
        accountsService.saveAccount(request);
    }

    @PatchMapping("/{accountId}/branchAddress")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBranch(
            @PathVariable("accountId") long id,
            @RequestParam(value = "value") @NotNull String branchAddress
    ) {
        accountsService.updateBranchAddress(id, branchAddress);
    }

    @DeleteMapping("{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("accountId") long id){
        accountsService.deleteAccount(id);
    }

    @PutMapping("{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(
            @PathVariable("accountId") long id,
            @Valid @RequestBody AccountsRequest request
    ) {
        accountsService.updateAccount(id, request);
    }
}
