package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Service.TABLE_NAME)
public class Service extends BaseEntity {
    @Column(name = RoleEntity.Service.NAME, unique = true)
//    @Size(min = 1, max = 100, message = "role name must have length between {min} and {max}")
    @Length(min = 5, max = 100, message = "role name must have length between {min} and {max}")
    private String name;
    @Column(name = RoleEntity.Service.CODE)
    @Length(min = 3, max = 10, message = "role name must have length between {min} and {max}")
    private String code;
    @Column(name = RoleEntity.Service.DESCRIPTION)
    @NotBlank
    private String desciption;
    @Column(name = RoleEntity.Service.TYPE, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        SAVE_OR_UPDATE,
        FETCH,
        REMOVE,
    }
}
