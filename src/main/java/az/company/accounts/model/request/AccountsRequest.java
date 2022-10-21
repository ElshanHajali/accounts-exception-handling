package az.company.accounts.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountsRequest {

    private Long customerId;
    private String accountType;
    private String branchAddress;

//{
//    "customerId" : ,
//    "accountType" : "",
//    "branchAddress" : ""
//}
}
