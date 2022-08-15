package com.example.bj_isfp_backend.domain.life.domain.repository;

import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO.LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO.LifeResponse;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.QLifeDetailsVO_LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.QLifeDetailsVO_Writer;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.QLifeListVO_LifeResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.bj_isfp_backend.domain.life.domain.QLife.life;
import static com.example.bj_isfp_backend.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class LifeRepositoryCustomImpl implements LifeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final UserFacade userFacade;

    @Override
    public List<LifeResponse> queryLifeList() {
        User currentUser = userFacade.getCurrentUser();

        return jpaQueryFactory
                .select(new QLifeListVO_LifeResponse(
                        life.content,
                        life.category,
                        life.createTime,
                        life.location,
                        life.lifeImage,
                        life.id
                ))
                .from(life)
                .where(
                        life.location.eq(currentUser.getLocation())
                )
                .orderBy(life.id.desc())
                .fetch();
    }

    @Override
    public LifeVO queryLifeDetails(Long lifeId) {

        return jpaQueryFactory
                .select(new QLifeDetailsVO_LifeVO(
                                life.content,
                                life.category,
                                life.createTime,
                                life.location,
                                life.lifeImage,
                                new QLifeDetailsVO_Writer(
                                        user.id,
                                        user.name,
                                        user.userProfile
                                )
                        )
                )
                .from(life)
                .leftJoin(life.user, user)
                .where(
                        life.id.eq(lifeId)
                )
                .fetchOne();
    }
}
