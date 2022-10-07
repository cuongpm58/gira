package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.GennericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleWithOperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public interface RoleService extends GennericService<Role, RoleDTO, UUID> {
    RoleDTO save(RoleDTO roleDTO);

    Role update(Role role, String code);
    void delete(String code);

    RoleWithOperationDTO addOperation(UUID roleId, List<UUID> ids);

    @Service
    @Transactional
    class RoleServiceImpl implements RoleService{
        private final RoleRepository repository;
        private final GiraMapper giraMapper;
        private OperationService operationService;

        public RoleServiceImpl(RoleRepository repository, GiraMapper giraMapper, OperationService operationService){
            this.repository = repository;
            this.giraMapper = giraMapper;
            this.operationService = operationService;
        }

        @Override
        public JpaRepository<Role, UUID> getRepository() {
            return this.repository;
        }

        @Override
        public ModelMapper getMapper() {
            return giraMapper;
        }

        @Override
        @Transactional(readOnly = true)
        public List<Role> findAll() {
            return repository.findAll();
        }

        @Override
        public RoleDTO save(RoleDTO roleDTO) {
            Role model = getMapper().map(roleDTO, Role.class);
            Role savedModel = repository.save(model);
            return getMapper().map(savedModel, RoleDTO.class);
        }

        @Override
        public Role update(Role role, String code) {
            Role curRole = repository.findByCode(code);
            curRole.setName(role.getName());
            curRole.setDesciption(role.getDesciption());
            return repository.save(curRole);
        }

        @Override
        public void delete(String code) {
            repository.deleteByCode(code);
        }

        @Override
        public RoleWithOperationDTO addOperation(UUID roleId, List<UUID> operationIds) {
            Role curRole = repository.findById(roleId)
                    .orElseThrow(() ->
                            new ValidationException(List.of(new ErrorMessage("Role is not existed"))));
            List<Operation> operations = operationService.findByIds(operationIds);
            operations.forEach(operation -> curRole.addOperation(operation));
            return giraMapper.map(curRole, RoleWithOperationDTO.class);
        }
    }
}
