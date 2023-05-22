package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.entity.AchievementEntity;
import com.odnzk.study.service.UserAchievementService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.ACHIEVEMENTS)
public class AchievementsController {
    UserAchievementService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<AchievementEntity> achievements = userDetails.getUser().getAchievements();
        List<String> categories = achievements.stream().map(AchievementEntity::getCategory).toList();
        model.addAttribute("categories", categories);
        model.addAttribute("achievement", achievements);
        return "achievements";
    }

}
