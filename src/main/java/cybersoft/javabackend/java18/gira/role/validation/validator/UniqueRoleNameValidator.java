package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
    private String msg;
    private RoleRepository repository;

    public UniqueRoleNameValidator(RoleRepository repository){
        this.repository = repository;
    }
    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
        msg = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Role> roleOpt = repository.findByName(name);

        if(roleOpt.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(msg)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
