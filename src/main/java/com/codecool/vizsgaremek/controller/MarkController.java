package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.service.MarkService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("getAll")
    public List<MarkDto> getMarkList() {
        return markService.getMarkList();
    }

    @PostMapping("add")
    public void add(@RequestBody MarkDto mark) {
        markService.add(mark);
    }

    @GetMapping("average/{id}")
    public Double getStudentAverage(@PathVariable Long id) {
        return markService.getStudentAverage(id);
    }

    @GetMapping("getMark/{id}")
    public MarkDto getMarkById(@PathVariable Long id) {
        return markService.getMarkById(id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        markService.deleteMarkByID(id);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable Long id, @RequestBody Mark mark) {
        markService.update(id, mark);
    }

    @GetMapping("get/{id}/{subject}")
    public Double getStudentAverageBySubject(@PathVariable Long id, @PathVariable String subject) {
        return markService.getStudentAverageBySubject(id, subject);
    }

    @GetMapping("get/{id}/{subject}/{month}")
    public Double getStudentAverageBySubject(@PathVariable Long id, @PathVariable String subject, @PathVariable String month) {
        return markService.getStudentAverageBySubjectAndMonth(id, subject, month);
    }
}
