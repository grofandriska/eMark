package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.service.MarkService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @Operation(summary = "Add a mark")
    @PostMapping("addMark")
    public void add(@RequestBody MarkDto mark) {
        markService.add(mark);
    }

    @Operation(summary = "Get a mark by id")
    @GetMapping("getMarkById/{id}")
    public MarkDto getMarkById(@PathVariable Long id) {
        return markService.getMarkById(id);
    }

    @Operation(summary = "Get all mark")
    @GetMapping("getAllMark")
    public List<MarkDto> getMarkList() {
        return markService.getMarkList();
    }

    @Operation(summary = "Delete a mark by id")
    @DeleteMapping("deleteMarkById/{id}")
    public void delete(@PathVariable Long id) {
        markService.deleteMarkByID(id);
    }

    @Operation(summary = "Update a mark by id")
    @PutMapping("updateMarkById/{id}")
    public void update(@PathVariable Long id, @RequestBody Mark mark) {
        markService.update(id, mark);
    }

    @Operation(summary = "Get average for student by id")
    @GetMapping("getAverage/{id}")
    public Double getStudentAverage(@PathVariable Long id) {
        return markService.getStudentAverage(id);
    }

    @Operation(summary = "Get average for student by id and subject")
    @GetMapping("getAverage/{id}/{subject}")
    public Double getStudentAverageBySubject(@PathVariable Long id, @PathVariable String subject) {
        return markService.getStudentAverageBySubject(id, subject);
    }
}
