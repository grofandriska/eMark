package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.TeacherException;
import com.codecool.vizsgaremek.log.Log;
import com.codecool.vizsgaremek.mapper.TeacherMapper;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import com.codecool.vizsgaremek.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public void saveTeacher(TeacherDto teacher) {
        try {
            teacherRepository.save(teacherMapper.convertTeacherDtoToEntity(teacher));
        } catch (RuntimeException e) {
            Log.log.info("Teacher can not be added" + e.getMessage());
        }
    }

    public void updateTeacherById(Long id, Teacher teacherUpdate) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacher.setName(teacherUpdate.getName());
        teacher.setSubject(teacherUpdate.getSubject());
        teacher.setGender(teacherUpdate.getGender());
        teacherRepository.save(teacher);

    }

    public void deleteTeacherById(Long id) {
        try {
            teacherRepository.deleteById(id);
        } catch (TeacherException e) {
            Log.log.info("Something went wrong when deleting Teacher by id :" + id);
            Log.log.info("See details :" + e);
            throw new TeacherException(id);
        }
    }

    public List<TeacherDto> getAllTeacher() {
        List<TeacherDto> teacherListResponse = new ArrayList<>();
        List<Teacher> teacherList = teacherRepository.findAll();
        for (Teacher teacher : teacherList) {
            teacherListResponse.add(teacherMapper.convertTeacherToDto(teacher));
        }
        return teacherListResponse;
    }
}
