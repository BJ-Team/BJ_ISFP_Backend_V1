package com.example.bj_isfp_backend.domain.life.domain.repository;

import com.example.bj_isfp_backend.domain.life.domain.Life;
import org.springframework.data.repository.CrudRepository;

public interface LifeRepository extends CrudRepository<Life, Long>, LifeRepositoryCustom {
}
