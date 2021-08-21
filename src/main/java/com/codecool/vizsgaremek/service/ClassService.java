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
        log.info("(!getClassByName!)Something went wrong when looking for class by given name :" + className);
        return classResponse;
    }

    public Class getClassById(Long id) {
        Class classResponse;
        List<Class> classResponseList;
        classResponseList = classRepository.findAll();
        for (Class aClass : classResponseList) {
            if (aClass.getId().equals(id)) {
                classResponse = aClass;
                log.info("Class Found! id: " + id);
                return classResponse;
            }
        }
        log.info("(!GetClassByID!) something went wrong when looking for id:" + id);
        throw new ClassException(id);

    }

    public void deleteClass(long id) {
        try {
            classRepository.deleteById(id);
        } catch (ClassException e) {
            log.info("Can't delete class , with student's inside !");
            log.info(e.getMessage());
        }
    }

    public void updateClass(Long id, Class update) {
        classRepository.findById(id).map(classE -> {
            classE.setId(update.getId());
            classE.setName(update.getName());
            return classRepository.save(classE);
        });

    }

}
