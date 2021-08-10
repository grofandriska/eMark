package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.ClassDto;

import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public ClassMapper() {
    }

    public ClassDto convertClassToDto(Class classEntity) {
        ClassDto classDtoResponse = new ClassDto();
        classDtoResponse.setId(classEntity.getId());
        classDtoResponse.setClassName(classEntity.getName());
        return classDtoResponse;
    }

    public Class convertClassDtoToEntity(ClassDto classEntity) {
        Class classResponse = new Class();
        classResponse.setId(classEntity.getId());
        classResponse.setName(classEntity.getClassName());
        Teacher teacher = new Teacher();
        teacher.setId(classEntity.getId());
        return classResponse;
    }
}
