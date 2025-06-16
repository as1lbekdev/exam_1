package service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    T add(T t);
    List<T> getAll();
    T update(UUID id,T t);
    void remove(UUID id);
    T getById(UUID id);
}
