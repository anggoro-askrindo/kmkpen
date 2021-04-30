package id.co.askrindo.kmkpen.service.impl.sybase;

import id.co.askrindo.kmkpen.repository.IGenericRepository;
import id.co.askrindo.kmkpen.service.IGenericService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

/**
 * Created by Anggoro Biandono on 11/01/2018.
 */
public class GenericSybaseSqlServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {
    private IGenericRepository<T, ID> repository;

    public GenericSybaseSqlServiceImpl(IGenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<T> findAll(Iterable<ID> iterable) {
        return repository.findAllById(iterable);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public <S extends T> S save(S s) {
        return repository.save(s);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public <S extends T> List<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public <S extends T> S saveAndFlush(S s) {
        return repository.saveAndFlush(s);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public void deleteInBatch(Iterable<T> iterable) {
        repository.deleteInBatch(iterable);
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    public T getOne(ID id) {
        return repository.getOne(id);
    }

    @Override
    public Optional<T> findOne(ID id) {return repository.findById(id);}

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example,sort);
    }

    @Override
    public List<T> findByCriteria(Specification<T> builder) {
        return repository.findAll(builder);
    }
}
