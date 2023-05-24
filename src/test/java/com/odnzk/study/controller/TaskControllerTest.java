package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.TaskFormDto;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    // todo
//    @PatchMapping()
//    public String update(@RequestParam("id") Long id) {
//        service.updateIsCompletedState(id);
//        return "redirect:" + TodoListerEndpoint.PROJECTS;
//    }
//
//    @PostMapping()
//    public String add(TaskFormDto taskFormDto) {
//        service.create(taskFormDto);
//        return "redirect:" + TodoListerEndpoint.PROJECTS;
//    }
//
//    // todo map to  /delete?id=${project.id}
//    @DeleteMapping()
//    public String delete(@RequestParam("id") Long id) {
//        service.deleteById(id);
//        return "redirect:" + TodoListerEndpoint.PROJECTS;
//    }
}
