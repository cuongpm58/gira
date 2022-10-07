package cybersoft.javabackend.java18.gira.common.service;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GennericService <T extends BaseEntity, D, ID>{
    JpaRepository<T, ID> getRepository(); // Factory m
    ModelMapper getMapper();// ethod

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<T> findAll(Pageable page) {
        return getRepository().findAll(page).stream().toList();
    }

    default List<D> findAllDto (Class<D> clazz) {
        return getRepository().findAll().stream().map(model -> getMapper().map(model, clazz)).toList();
    }

    default List<D> findAllDto (Pageable page, Class<D> clazz) {
        return getRepository().findAll(page).stream().map(model -> getMapper().map(model, clazz)).toList();
    }

    default  List<T> findByIds(List<ID> ids) {
        return getRepository().findAllById(ids);
    }

    default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    default T save(T entity){

        return getRepository().save(entity);
    }

    default T save(D dto, Class<T> clazz) {
        T model = getMapper().map(dto, clazz);
        T savedModel = getRepository().save(model);
        return savedModel;
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    default T update(T entity) {
        return getRepository().save(entity);
    }
}
