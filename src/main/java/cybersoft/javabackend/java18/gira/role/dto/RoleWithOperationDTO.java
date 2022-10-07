package cybersoft.javabackend.java18.gira.role.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class RoleWithOperationDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
    private Set<OperationDTO> operations;
}
