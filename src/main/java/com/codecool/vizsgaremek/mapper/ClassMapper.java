package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Class;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.ClassDto;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public ClassMapper() {
    }

    @Synchronized
    public ClassDto convertClassToDto(Class classEntity) {
        ClassDto classDtoResponse = new ClassDto();
        classDtoResponse.setClassName(classEntity.getName());
        classDtoResponse.setHeadmasterId(classEntity.getTeacher().getId());
        classDtoResponse.setId(classEntity.getId());
        return classDtoResponse;
    }

    @Synchronized
    public Class convertClassDtoToEntity(ClassDto classEntity) {
        Class classResponse = new Class();
        classResponse.setId(classEntity.getId());
        classResponse.setName(classEntity.getClassName());
        Teacher teacher = new Teacher();
        teacher.setId(classEntity.getHeadmasterId());
        classResponse.setTeacher(teacher);
        return classResponse;

    }

}
