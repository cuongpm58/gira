package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.GennericService;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface RoleService extends GennericService<Role, RoleDTO, UUID> {
    Role update(Role role, String code);
    void delete(String code);

    @Service
    @Transactional
    class RoleServiceImpl implements RoleService{
        private final RoleRepository repository;
        private final GiraMapper giraMapper;

        public RoleServiceImpl(RoleRepository repository, GiraMapper giraMapper){
            this.repository = repository;
            this.giraMapper = giraMapper;
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
        public Role save(Role role) {
            return repository.save(role);
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
    }
}
