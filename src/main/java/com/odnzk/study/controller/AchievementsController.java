package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.AchievementDto;
import com.odnzk.study.model.entity.AchievementEntity;
import com.odnzk.study.service.AchievementService;
import com.odnzk.study.util.mapper.AchievementMapper;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.ACHIEVEMENTS)
public class AchievementsController {
    private final AchievementService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        Set<Integer> unlockedId = userDetails.getUser().getAchievements().stream().map(AchievementEntity::getId).collect(Collectors.toSet());
        List<AchievementDto> merged = service.getAll().stream().map(it -> AchievementMapper.from(it, unlockedId.contains(it.getId()))).toList();
        Set<String> categories = merged.stream().map(AchievementDto::getCategory).collect(Collectors.toSet());
        model.addAttribute("categories", categories);
        model.addAttribute("achievements", merged);
        return "achievements";
    }

}
