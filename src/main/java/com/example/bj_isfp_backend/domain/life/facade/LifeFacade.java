package com.example.bj_isfp_backend.domain.life.facade;

import com.example.bj_isfp_backend.domain.life.domain.Life;
import com.example.bj_isfp_backend.domain.life.domain.repository.LifeRepository;
import com.example.bj_isfp_backend.domain.life.exception.LifeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LifeFacade {

    private final LifeRepository lifeRepository;

    public Life getLifeById(Long lifeId) {
        return lifeRepository.findById(lifeId)
                .orElseThrow(() -> LifeNotFoundException.EXCEPTION);
    }
}
