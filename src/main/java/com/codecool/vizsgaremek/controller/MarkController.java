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

    @PostMapping("addMark")
    public void add(@RequestBody MarkDto mark) {
        markService.add(mark);
    }

    @GetMapping("getMarkById/{id}")
    public MarkDto getMarkById(@PathVariable Long id) {
        return markService.getMarkById(id);
    }

    @GetMapping("getAllMark")
    public List<MarkDto> getMarkList() {
        return markService.getMarkList();
    }

    @DeleteMapping("deleteMarkById/{id}")
    public void delete(@PathVariable Long id) {
        markService.deleteMarkByID(id);
    }

    @PutMapping("updateMarkById/{id}")
    public void update(@PathVariable Long id, @RequestBody Mark mark) {
        markService.update(id, mark);
    }

    @GetMapping("getAverage/{id}")
    public Double getStudentAverage(@PathVariable Long id) {
        return markService.getStudentAverage(id);
    }

    @GetMapping("getAverage/{id}/{subject}")
    public Double getStudentAvarageBySubject(@PathVariable Long id, @PathVariable String subject) {
        return markService.getStudentAverageBySubject(id, subject);
    }
}
