package com.example.bj_isfp_backend.domain.life.service;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import com.example.bj_isfp_backend.domain.commment.domain.repository.CommentRepository;
import com.example.bj_isfp_backend.domain.commment.domain.repository.vo.CommentListVO.CommentVO;
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
    private final CommentRepository commentRepository;

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
        LifeVO lifeVO = lifeRepository.queryLifeDetails(lifeId);
        List<CommentVO> commentVO = commentRepository.queryCommentList(lifeId);

        lifeVO = LifeVO.builder()
                .content(lifeVO.getContent())
                .category(lifeVO.getCategory())
                .createTime(lifeVO.getCreateTime())
                .location(lifeVO.getLocation())
                .lifeImage(lifeVO.getLifeImage())
                .writer(lifeVO.getWriter())
                .build();

        lifeVO.getComment().addAll(commentVO);

        return lifeVO;
    }

    @Override
    @Transactional
    public void deleteLife(Long lifeId) {

        User user = userFacade.getCurrentUser();
        Life life = lifeFacade.getLifeById(lifeId);
        Comment comment = commentRepository.findAllByLife(life)
                .orElse(null);

        if (!life.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        if (comment != null) {
            commentRepository.delete(comment);
        }

        lifeRepository.delete(life);
    }
}
