package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {

    @Autowired
    ModelMapper modelMapper;

    public MarkMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MarkDto convertMarkToDto(Mark mark){
        return modelMapper.map(mark, MarkDto.class);
    }

    public Mark convertMarkDtoToEntity(MarkDto mark){
        return modelMapper.map(mark, Mark.class);
    }
}
