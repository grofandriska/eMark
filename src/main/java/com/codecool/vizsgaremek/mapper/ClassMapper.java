package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.ClassDto;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    @Autowired
    ModelMapper modelMapper;

    public ClassMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClassDto convertClassToDto(Class classEntity){
        return modelMapper.map(classEntity, ClassDto.class);
    }

    public Class convertClassDtoToEntity(ClassDto classEntity){
        return modelMapper.map(classEntity,Class.class);
    }

}
