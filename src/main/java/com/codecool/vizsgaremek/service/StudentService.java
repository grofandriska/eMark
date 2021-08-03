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

    public void save(Student student) {
        studentRepository.save(student);
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

    ///TEST CATCH
    public void updateStudent(Long id, Student studentUpdate) {
        try {
            studentRepository.findById(id).map(student -> {
                student.setStudentName(studentUpdate.getStudentName());
                student.setStudentClass(studentUpdate.getStudentClass());
                return studentRepository.save(student);
            });
        } catch (StudentException e) {
            System.out.println(e);
            throw new StudentException(id);
        }

    }
}
