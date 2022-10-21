package az.company.accounts.excetion;

import az.company.accounts.excetion.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionResponse accountNotFound(NotFoundException exception) {
        log.info("NotFoundException: " + exception);
        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .code(exception.getCode())
                .build();
    }

}
