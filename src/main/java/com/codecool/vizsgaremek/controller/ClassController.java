package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.dto.ClassDto;
import com.codecool.vizsgaremek.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("getAllClass")
    public List<Class> listAll() {
        return classService.listAllClass();
    }

    @PostMapping("/add")
    public Class add(@RequestBody Class classEntity)  {
        return classService.addClass(classEntity);
    }

    @DeleteMapping("deleteClass/{id}")
    public void delete(@PathVariable("id") Long id) {
        classService.deleteClass(id);
    }

    @GetMapping("getClassById/{id}")
    public Class getClassById (@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @GetMapping("getClassByName/{name}")
    public Class getClassByName(@PathVariable("name") String name) {
        return classService.getClassByName(name);
    }

    @PutMapping("/updateClass/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Class classEntity) {
        classService.updateClass(id, classEntity);
    }
}
