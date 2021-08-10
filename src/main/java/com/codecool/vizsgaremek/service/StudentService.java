package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.StudentException;
import com.codecool.vizsgaremek.mapper.StudentMapper;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import com.codecool.vizsgaremek.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public void save(StudentDto student) {
        studentRepository.save(studentMapper.convertStudentDtoToEntity(student));
    }

    public List<StudentDto> getAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentListResponse = new ArrayList<>();
        for (Student student : studentList) {
            studentListResponse.add(studentMapper.convertStudentToDto(student));

        }
        return studentListResponse;
    }

    public void deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (StudentException e) {
            throw new StudentException(id);
        }
    }

    public void updateStudent(Long id, Student studentUpdate) {
        try {
            studentRepository.findById(id).map(student -> {
                student.setStudentName(studentUpdate.getStudentName());
                student.setClassID(studentUpdate.getClassID());
                student.setGender(studentUpdate.getGender());
                return studentRepository.save(student);
            });
        } catch (StudentException e) {
            System.out.println(e);
            throw new StudentException(id);
        }
    }

    public List<StudentDto> getStudentsByClassId(Long id) {
        List<Student> list = studentRepository.findAll();
        List<StudentDto> response = new ArrayList<>();
        for (Student student : list) {
            if (student.getClassID().getId().equals(id)) {
                response.add(studentMapper.convertStudentToDto(student));
            }
        }
        return response;
    }

    public List<StudentDto> getStudentsByGender(String gender) {
        List<Student> list = studentRepository.findAll();
        List<StudentDto> response = new ArrayList<>();
        for (Student student : list) {
            if (student.getGender().equals(gender)) {
                response.add(studentMapper.convertStudentToDto(student));
            }
        }
        return response;
    }
}


