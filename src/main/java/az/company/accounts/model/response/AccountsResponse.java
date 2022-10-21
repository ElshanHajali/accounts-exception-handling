package az.company.accounts.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountsResponse {

    private Long customerId;
    private String accountType;
    private String branchAddress;
    private LocalDateTime createdAt; //yyyy-MM-dd-HH-mm-ss.zzz

}
