package com.codecool.vizsgaremek;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class StudentTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
        this.baseUrl = "http://localhost:" + port + "/student";
    }

    @Test
    public void addNewStudent() {
        Class testClass = new Class(1L, "1.A");
        testRestTemplate.postForObject("http://localhost:" + port + "/class/add", testClass, Class.class);

        Student studentTest = new Student(1L, testClass, "Kis Géza", "Male");

        Student resultStud = testRestTemplate.postForObject(baseUrl + "/add", studentTest, Student.class);
        assertEquals(studentTest.getStudentName(), resultStud.getStudentName());
    }

    @Test
    public void getStudents() {
        List<Student> studentsList = List.of(testRestTemplate.getForObject(baseUrl + "/getAll", Student[].class));
        assertEquals(0, studentsList.size());
    }

    @Test
    public void getStudentById() {
        Class testClass = new Class(1L, "1.A");
        testRestTemplate.postForObject("http://localhost:" + port + "/class/add", testClass, Class.class);

        Student studentTest = new Student(1L, testClass, "Kis Géza", "Male");
        studentTest = testRestTemplate.postForObject(baseUrl + "/add", studentTest, Student.class);
        Student result = testRestTemplate.getForObject(baseUrl + "/" + studentTest.getId(), Student.class);
        assertEquals(studentTest.getId(), result.getId());

    }

    @Test
    public void update() {
        Class testClass = new Class(1L, "1.A");
        testRestTemplate.postForObject("http://localhost:" + port + "/class/add", testClass, Class.class);

        Student newStudent = new Student(1L, testClass, "Kis Géza", "Male");

        newStudent = testRestTemplate.postForObject(baseUrl + "/add", newStudent, Student.class);

        newStudent.setStudentName("Nagy Laci");

        testRestTemplate.put(baseUrl + "/update/" + newStudent.getId(), newStudent);

        Student updatedStudent = testRestTemplate.getForObject(baseUrl + "/" + newStudent.getId(), Student.class);

        assertEquals("Nagy Laci", updatedStudent.getStudentName());
    }

    @Test
    public void delete() {
        Class testClass = new Class(1L, "1.A");
        testRestTemplate.postForObject("http://localhost:" + port + "/class/add", testClass, Class.class);

        Student newStudent = new Student(1L, testClass, "Kis Géza", "Male");
        Student newStudent2 = new Student(2L, testClass, "Kis Petya", "Male");
        Student newStudent3 = new Student(3L, testClass, "Kis András", "Male");

        List<Student> testStudents = new ArrayList<>();

        testStudents.add(newStudent);
        testStudents.add(newStudent2);
        testStudents.add(newStudent3);

        testStudents.forEach(testStud -> testStud.setId(testRestTemplate.postForObject(baseUrl + "/add", testStud, Student.class).getId())
        );

        testRestTemplate.delete(baseUrl + "/delete/" + newStudent2.getId());
        testStudents.remove(newStudent2);

        List<Student> remainingStudents = List.of(testRestTemplate.getForObject(baseUrl + "/getAll", Student[].class));

        assertEquals(testStudents.size(), remainingStudents.size());

        for (int i = 0; i < testStudents.size(); i++) {
            assertEquals(testStudents.get(i).getStudentName(), remainingStudents.get(i).getStudentName());
        }
    }

}
