package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.ClassDto;

import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public ClassMapper() {
    }

    public ClassDto convertClassToDto(Class param) {
        ClassDto result = new ClassDto();
        result.setId(param.getId());
        result.setClassName(param.getName());
        return result;
    }

    public Class convertClassDtoToEntity(ClassDto param) {
        Class result = new Class();
        result.setId(param.getId());
        result.setName(param.getClassName());
        return result;
    }
}
