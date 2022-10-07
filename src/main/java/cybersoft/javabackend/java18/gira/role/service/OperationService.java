package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.GennericService;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface OperationService extends GennericService<Operation, OperationDTO, UUID> {
}

@org.springframework.stereotype.Service
@Transactional
class OperationServiceImpl implements OperationService {
    private OperationRepository repository;
    private ModelMapper modelMapper;

    public OperationServiceImpl(OperationRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JpaRepository<Operation, UUID> getRepository() {
        return repository;
    }

    @Override
    public ModelMapper getMapper() {
        return modelMapper;
    }

}
