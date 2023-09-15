package pro.sky.Coursework2.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AmountMoreThanRequiredException extends RuntimeException {
}
