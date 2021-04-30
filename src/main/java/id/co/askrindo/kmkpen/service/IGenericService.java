package id.co.askrindo.kmkpen.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Anggoro Biandono on 11/01/2018.
 */
public interface IGenericService<T, ID extends Serializable>{
    public List<T> findAll();

    public List<T> findAll(Sort sort);

    public List<T> findAll(Iterable<ID> iterable);

    public <S extends T> S save(S s);

    <S extends T> List<S> saveAll(Iterable<S> iterable);

    <S extends T> S saveAndFlush(S s);

    long count();

    void delete(ID id);

    void delete(T t);

    void deleteInBatch(Iterable<T> iterable);

    void deleteAllInBatch();

    T getOne(ID id);

    Optional<T> findOne(ID id);

    <S extends T> List<S> findAll(org.springframework.data.domain.Example<S> example);

    <S extends T> List<S> findAll(org.springframework.data.domain.Example<S> example, Sort sort);

    public List<T> findByCriteria(Specification<T> builder);
}
