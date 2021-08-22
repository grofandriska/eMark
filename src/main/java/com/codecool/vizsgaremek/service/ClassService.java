package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.ClassException;
import com.codecool.vizsgaremek.mapper.ClassMapper;
import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.dto.ClassDto;
import com.codecool.vizsgaremek.repository.ClassRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ClassService {

    ClassRepository classRepository;

    ClassMapper classMapper;

    public ClassService(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    public Class addClass(Class newClass) {
        return classRepository.save(newClass);
    }

    public List<Class> listAllClass() {
        return classRepository.findAll();
    }

    public Class getClassByName(String className) {
        Class classResponse = new Class();
        List<Class> classResponseList;
        classResponseList = classRepository.findAll();
        for (Class classEntity : classResponseList) {
            if (classEntity.getName().equals(className)) {
                classResponse = classEntity;
                return classResponse;
            }
        }
        log.info("  (!getClassByName!)  Class not found by :" + className);
        throw new RuntimeException("Can't get class by this name !");

    }

    public Class getClassById(Long id) {
        try {
            Class classResponse;
            classResponse = classRepository.findById(id).get();
            return classResponse;
        } catch (RuntimeException e) {
            log.info("Class not found ! "+ e );
        }
        throw new ClassException(id);
    }

    public void deleteClass(long id) {
        try {
            classRepository.deleteById(id);
        } catch (ClassException e) {
            log.info("Can't delete class , with student's inside !yet...");
            log.info(e.getMessage());
            throw new ClassException(id);
        }
    }

    public void updateClass(Long id, Class update) {
        try {
            classRepository.findById(id).map(classE -> {
                classE.setId(update.getId());
                classE.setName(update.getName());
                return classRepository.save(classE);
            });

        } catch (ClassException e) {
            log.info("Couldn't update " + id + "id class , see details.");
            System.out.println(e);
            throw new ClassException(id);
        }
    }

}
