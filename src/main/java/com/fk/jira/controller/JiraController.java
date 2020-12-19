package com.fk.jira.controller;

import com.fk.jira.dto.EpicDto;
import com.fk.jira.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jira")
public class JiraController {

    @Autowired
    public JiraService jiraService;

    @PostMapping
    public ResponseEntity<EpicDto> createEpic(@RequestBody EpicDto epicDto) {

        EpicDto epicDto1 = jiraService.addEpic(epicDto);
        return new ResponseEntity<>(epicDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EpicDto>> getEpics() {
        return new ResponseEntity<>(jiraService.getEpics().getEpicDtoList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EpicDto> getEpic(@PathVariable String id) {
        return new ResponseEntity<>(jiraService.getEpic(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEpic(@PathVariable String id) {
        jiraService.deleteEpic(id);
    }

    @PatchMapping(value = "/{id}")
    public void updateEpic(@PathVariable String id, @RequestBody EpicDto epicDto) {
        jiraService.updateEpic(epicDto, id);
    }

}
