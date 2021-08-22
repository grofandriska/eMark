package com.codecool.vizsgaremek.Unit;


import com.codecool.vizsgaremek.controller.StudentController;
import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void findAll() throws Exception {

        Class classOne = new Class(1L, "1.A");
        Student student = new Student(1L, classOne, "Petike", "Male");
        Student studentTwo = new Student(2L, classOne, "Fecó", "Male");
        Student studentThree = new Student(3L, classOne, "Roli", "Male");

        when(studentService.getAll()).thenReturn(new ArrayList<>(List.of(student, studentTwo, studentThree)));

        mockMvc.perform(get("/student/getAllStudent")).andExpect(status().is(400));
        mockMvc.perform(get("/student/getAll")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(student.getId().intValue())))
                .andExpect(jsonPath("$[0].studentName", is(student.getStudentName())))
                .andExpect(jsonPath("$[0].className.id", is(student.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[0].gender", is(student.getGender())))


                .andExpect(jsonPath("$[1].id", is(studentTwo.getId().intValue())))
                .andExpect(jsonPath("$[1].studentName", is(studentTwo.getStudentName())))
                .andExpect(jsonPath("$[1].className.id", is(studentTwo.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[1].gender", is(studentTwo.getGender())))

                .andExpect(jsonPath("$[2].id", is(studentThree.getId().intValue())))
                .andExpect(jsonPath("$[2].studentName", is(studentThree.getStudentName())))
                .andExpect(jsonPath("$[2].className.id", is(studentThree.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[2].gender", is(studentThree.getGender())));
    }

    @Test
    public void findStudentById() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Student student = new Student(1L, classOne, "Petike", "Male");
        mockMvc.perform(get("/student/get" + student.getId())).andExpect(status().is(400));
        mockMvc.perform(get("/student/" + student.getId())).andExpect(status().isOk());
        when(studentService.getStudentById(1L)).thenReturn(student);
    }

    @Test
    public void addStudentReturnsSame() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Student student = new Student(1L, classOne, "Petike", "Male");
        when(studentService.save(student)).thenReturn(student);
        mockMvc.perform(post("/students/add", classOne)).andExpect(status().is(404));
    }

    @Test
    public void getStudentByClass() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Class classTwo = new Class(2L, "2.A");

        Student student = new Student(1L, classOne, "Petike", "Male");
        Student studentTwo = new Student(2L, classTwo, "Zolika", "Male");
        Student studentThree = new Student(3L, classTwo, "Sanyika", "Male");

        when(studentService.getStudentsByClassId(classTwo.getId())).thenReturn(new ArrayList<>(List.of(studentTwo, studentThree)));
        mockMvc.perform(get("/student/getClass")).andExpect(status().is(400));
        mockMvc.perform(get("/student/class/" + classTwo.getId())).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id", is(studentTwo.getId().intValue())))
                .andExpect(jsonPath("$[0].studentName", is(studentTwo.getStudentName())))
                .andExpect(jsonPath("$[0].className.id", is(studentTwo.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[0].gender", is(studentTwo.getGender())))

                .andExpect(jsonPath("$[1].id", is(studentThree.getId().intValue())))
                .andExpect(jsonPath("$[1].studentName", is(studentThree.getStudentName())))
                .andExpect(jsonPath("$[1].className.id", is(studentThree.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[1].gender", is(studentThree.getGender())))
        ;
    }

    @Test
    public void getStudentByGender() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Class classTwo = new Class(2L, "2.A");

        Student student = new Student(1L, classOne, "Petike", "Male");
        Student studentTwo = new Student(2L, classTwo, "Zolika", "Male");
        Student studentThree = new Student(3L, classTwo, "Anna", "Female");

        when(studentService.getStudentsByGender(student.getGender())).thenReturn(new ArrayList<>(List.of(student, studentTwo)));
        mockMvc.perform(get("/gender" + student.getGender())).andExpect(status().is(404));
        mockMvc.perform(get("/student/gender/" + student.getGender())).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id", is(student.getId().intValue())))
                .andExpect(jsonPath("$[0].studentName", is(student.getStudentName())))
                .andExpect(jsonPath("$[0].className.id", is(student.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[0].gender", is(student.getGender())))

                .andExpect(jsonPath("$[1].id", is(studentTwo.getId().intValue())))
                .andExpect(jsonPath("$[1].studentName", is(studentTwo.getStudentName())))
                .andExpect(jsonPath("$[1].className.id", is(studentTwo.getClassName().getId().intValue())))
                .andExpect(jsonPath("$[1].gender", is(studentTwo.getGender())));
    }

    @Test
    public void AddStudentReturnsSameStudent() {
        Class classOne = new Class(1L, "1.A");
        Student student = new Student(1L, classOne, "Petike", "Male");
        when(studentService.save(student)).thenReturn(student);
    }

    @Test
    public void findStudentByIdAndUrlIsOk() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Student student = new Student(1L, classOne, "Petike", "Male");
        mockMvc.perform(get("/student/get" + student.getId())).andExpect(status().is(400));
        mockMvc.perform(get("/student/" + student.getId())).andExpect(status().isOk());
        when(studentService.getStudentById(1L)).thenReturn(student);
    }


}
