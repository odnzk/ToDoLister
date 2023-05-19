package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.Achievement;
import com.odnzk.study.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/" + TodoListerEndpoint.ACHIEVEMENTS)
public class AchievementsController {
    UserAchievementService service;

    @GetMapping
    public String getPage(Model model) {
        // todo get userId
        Integer userId = 1;
        List<Achievement> achievements = service.getUserAchievements(userId);
        List<String> categories = achievements.stream().map(Achievement::category).toList();
        model.addAttribute("categories", categories);
        model.addAttribute("achievement", achievements);
        return TodoListerEndpoint.ACHIEVEMENTS;
    }

}
