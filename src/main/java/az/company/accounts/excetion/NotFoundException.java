package az.company.accounts.excetion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class NotFoundException extends RuntimeException {
    private final String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
