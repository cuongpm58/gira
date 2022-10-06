package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.stream.XMLInputFactory;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {
    @Column(name = RoleEntity.Role.NAME, unique = true)
//    @Size(min = 1, max = 100, message = "role name must have length between {min} and {max}")
    @Length(min = 5, max = 100, message = "role name must have length between {min} and {max}")
    private String name;
    @Column(name = RoleEntity.Role.CODE)
    @Length(min = 3, max = 10, message = "role name must have length between {min} and {max}")
    private String code;
    @Column(name = RoleEntity.Role.DESCRIPTION)
    @NotBlank
    private String desciption;

    @Override
    public boolean equals(Object obj) {
        Role role = (Role)obj;
        return super.equals(obj)
                && this.name.equals(role)
                && this.code.equals(role);
    }
}
