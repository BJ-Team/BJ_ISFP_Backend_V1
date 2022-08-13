package com.example.bj_isfp_backend.domain.life.presentation;

import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO.LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO;
import com.example.bj_isfp_backend.domain.life.presentation.dto.request.LifeRequest;
import com.example.bj_isfp_backend.domain.life.service.LifeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/life")
public class LifeController {

    private final LifeService lifeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void makePost(@RequestBody @Valid LifeRequest lifeRequest) {
        lifeService.createLife(lifeRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{life-id}")
    public void deleteLife(@PathVariable(name = "life-id") Long lifeId) {
        lifeService.deleteLife(lifeId);
    }

    @GetMapping("/list")
    public LifeListVO queryLife() {
        return lifeService.queryLife();
    }

    @GetMapping("/list/{life-id}")
    public LifeVO queryLifeDetails(@PathVariable(name = "life-id") Long lifeId) {
        return lifeService.queryLifeDetails(lifeId);
    }

    @PatchMapping("/{life-id}")
    public void updateLife(@PathVariable(name = "life-id") Long postId, LifeRequest lifeRequest) {
        lifeService.updateLife(postId, lifeRequest);
    }
}
