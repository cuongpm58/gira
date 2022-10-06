package cybersoft.javabackend.java18.gira.common.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@UtilityClass
public class ExceptionUtil {
    private static final String DEFAULT_UNEXPECTED_MSG = "Ops! Something wrong happens...";

    public List<String> getErrors(ConstraintViolationException exception){
        return exception.getConstraintViolations().stream()
                .map(violation -> violation.getMessage())
                .toList();
    }

    public List<String> getErrors(RuntimeException exception){
        return List.of(DEFAULT_UNEXPECTED_MSG);
    }

    public List<String> getErrors(MethodArgumentNotValidException exception){
        return exception.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .toList();
    }
}
