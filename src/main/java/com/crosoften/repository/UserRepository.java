package com.crosoften.repository;

import com.crosoften.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    Iterable<User> findAll();

    @Override
    <S extends User> S save(S s);

    @Override
    void delete(User user);

    @Override
    long count();


}
