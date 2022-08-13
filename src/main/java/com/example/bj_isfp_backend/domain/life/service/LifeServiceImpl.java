package com.example.bj_isfp_backend.domain.life.service;

import com.example.bj_isfp_backend.domain.life.domain.Life;
import com.example.bj_isfp_backend.domain.life.domain.repository.LifeRepository;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO.LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO.LifeResponse;
import com.example.bj_isfp_backend.domain.life.facade.LifeFacade;
import com.example.bj_isfp_backend.domain.life.presentation.dto.request.LifeRequest;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.exception.InvalidUserException;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LifeServiceImpl implements LifeService {

    private final UserFacade userFacade;
    private final LifeFacade lifeFacade;
    private final LifeRepository lifeRepository;

    @Override
    @Transactional
    public void createLife(LifeRequest lifeRequest) {

        User user = userFacade.getCurrentUser();

        lifeRepository.save(
                Life.builder()
                        .content(lifeRequest.getContent())
                        .category(lifeRequest.getCategory())
                        .location(user.getLocation())
                        .lifeImage(lifeRequest.getLifeImage())
                        .user(user)
                        .build()
        );
    }

    @Override
    public void updateLife(Long lifeId, LifeRequest lifeRequest) {

        User user = userFacade.getCurrentUser();
        Life life = lifeFacade.getLifeById(lifeId);

        if (!life.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        life.updateLife(
                lifeRequest.getContent(),
                lifeRequest.getCategory(),
                user.getLocation(),
                lifeRequest.getLifeImage());
    }

    @Override
    public LifeListVO queryLife() {
        List<LifeResponse> lifeList = lifeRepository.queryLifeList();

        return LifeListVO.builder()
                .lifeResponses(lifeList)
                .build();
    }

    @Override
    public LifeVO queryLifeDetails(Long lifeId) {
        return lifeRepository.queryLifeDetails(lifeId);
    }

    @Override
    @Transactional
    public void deleteLife(Long lifeId) {

        User user = userFacade.getCurrentUser();
        Life life = lifeFacade.getLifeById(lifeId);

        if (!life.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        lifeRepository.delete(life);
    }
}
