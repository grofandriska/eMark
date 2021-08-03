package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    @Autowired
    ModelMapper modelMapper;

    public TeacherMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TeacherDto teacherToDto(Teacher teacher){
        return modelMapper.map(teacher,TeacherDto.class);
    }

    public Teacher teacherDtoToEntity(TeacherDto teacherDto){
        return modelMapper.map(teacherDto,Teacher.class);
    }


}
