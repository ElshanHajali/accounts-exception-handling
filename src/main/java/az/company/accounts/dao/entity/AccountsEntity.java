package az.company.accounts.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;

    @Column(name = "customer_id")
    @Max(value = 10_000, message = "Customer Id must be less than 10_000")
    @Positive(message = "Customer Id must be positive number")
    private Long customerId;

    @Column(name = "account_type")
    @Size(min = 4,max = 16, message = "Size must be between 4 and 16")
    @NotBlank(message = "Account type cannot be either empty or blank")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "created_at")
    @CreationTimestamp //created_at timestamptz default now()
    private LocalDateTime createdAt; //yyyy-MM-dd-HH-mm-ss.zzz

}
