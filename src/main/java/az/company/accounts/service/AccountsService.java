package az.company.accounts.service;

import az.company.accounts.model.request.AccountsRequest;
import az.company.accounts.model.response.AccountsResponse;

import java.util.List;

public interface AccountsService {

    List<AccountsResponse> getAccounts();
    AccountsResponse getAccount(long id);
    List<AccountsResponse> getAccountsByCustomer(long customerId, String accountType);
    void saveAccount(AccountsRequest accountsEntity);
    void updateAccount(long accountId, AccountsRequest request);
    void deleteAccount(long id);
    void updateBranchAddress(long id, String branchAddress);

}
