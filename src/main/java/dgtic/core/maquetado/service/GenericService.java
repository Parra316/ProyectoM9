package dgtic.core.maquetado.service;

import java.util.List;

public interface GenericService<T, ID> {
    T getById(ID id);
    List<T> findAll();
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
