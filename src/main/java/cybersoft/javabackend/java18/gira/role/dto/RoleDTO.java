package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleCode;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    // Data transfer Object
    private UUID id;
    @Size(min = 5, max = 100, message = "{role.name.size}")
    @NotBlank
    @UniqueRoleName(message = "{role.name.existed}")
    private String name;
    @Size(min = 5, max = 10, message = "{role.code.size}")
    @NotBlank
    @UniqueRoleCode(message = "{role.code.existed}")
    private String code;
    @NotBlank(message = "{role.description.blank}")
    private String description;
}
