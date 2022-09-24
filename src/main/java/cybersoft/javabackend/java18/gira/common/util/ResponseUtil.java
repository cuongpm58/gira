package cybersoft.javabackend.java18.gira.common.util;

import cybersoft.javabackend.java18.gira.common.model.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
