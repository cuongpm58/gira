package cybersoft.javabackend.java18.gira.common.util;

import cybersoft.javabackend.java18.gira.common.model.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

@UtilityClass
public class ResponseUtil {
    public static ResponseEntity<ResponseDTO> get(Object result, HttpStatus httpStatus){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(result)
                        .hasErrors(false)
                        .erros(Collections.emptyList())
                        .timeStamp(DateTimeUtils.now())
                        .status(httpStatus.value())
                        .build(),
                httpStatus
        );
    }

    public static ResponseEntity<ResponseDTO> error(
            ConstraintViolationException exception, HttpStatus httpStatus){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .erros(ExceptionUtil.getErrors(exception))
                        .timeStamp(DateTimeUtils.now())
                        .status(httpStatus.value())
                        .build(),
                httpStatus
        );
    }

    public static ResponseEntity<ResponseDTO> error(
            RuntimeException exception, HttpStatus httpStatus){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .erros(ExceptionUtil.getErrors(exception))
                        .timeStamp(DateTimeUtils.now())
                        .status(httpStatus.value())
                        .build(),
                httpStatus
        );
    }

    public static ResponseEntity<ResponseDTO> error(
            MethodArgumentNotValidException exception, HttpStatus httpStatus){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .erros(ExceptionUtil.getErrors(exception))
                        .timeStamp(DateTimeUtils.now())
                        .status(httpStatus.value())
                        .build(),
                httpStatus
        );
    }
}
