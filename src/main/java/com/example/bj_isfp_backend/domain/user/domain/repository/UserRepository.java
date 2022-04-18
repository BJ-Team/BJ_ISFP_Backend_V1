package com.example.bj_isfp_backend.domain.user.domain.repository;

import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

    Optional<User> findByAccountId(String accountId);

    Optional<User> findByName(String name);
}
