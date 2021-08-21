package com.codecool.vizsgaremek;

import com.codecool.vizsgaremek.modell.Class;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ClassTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
        this.baseUrl = "http://localhost:" + port + "/class";
    }

    @Test
    public void addNewClass() {
        Class testClass = new Class(1L, "1.A");
        Class result = testRestTemplate.postForObject(baseUrl + "/add", testClass, Class.class);
        assertEquals(testClass.getName(), result.getName());
    }

    @Test
    public void getSongs() {
        List<Class> songList = List.of(testRestTemplate.getForObject(baseUrl + "/getAllClass", Class[].class));
        assertEquals(0, songList.size());
    }

    @Test
    public void getClassById() {
        Class testClass = new Class(null, "1.A");
        testClass = testRestTemplate.postForObject(baseUrl + "/add", testClass, Class.class);
        Class result = testRestTemplate.getForObject(baseUrl + "/getClassById/" + testClass.getId(), Class.class);
        assertEquals(testClass.getId(), result.getId());
    }

    @Test
    public void update() {
        Class testClass = new Class(null, "1.A");
        testClass = testRestTemplate.postForObject(baseUrl + "/add", testClass, Class.class);
        testClass.setName("Updated name");
        testRestTemplate.put(baseUrl + "/updateClass/" + testClass.getId(), testClass);
        Class updatedClass = testRestTemplate.getForObject(baseUrl + "/getClassById/" + testClass.getId(), Class.class);
        assertEquals("Updated name", updatedClass.getName());
    }

    @Test
    public void delete() {
        Class testClass1 = new Class(null, "2.A");
        Class testClass2 = new Class(null, "7.B");
        Class testClass3 = new Class(null, "5.C");

        List<Class> testClasses = new ArrayList<>();

        testClasses.add(testClass1);
        testClasses.add(testClass2);
        testClasses.add(testClass3);

        testClasses.forEach(testClass -> testClass.setId(testRestTemplate.postForObject(baseUrl + "/add", testClass, Class.class).getId())
        );

        testRestTemplate.delete(baseUrl + "/deleteClass/" + testClass2.getId());
        testClasses.remove(testClass2);

        List<Class> remainingClass = List.of(testRestTemplate.getForObject(baseUrl + "/getAllClass", Class[].class));

        assertEquals(testClasses.size(), remainingClass.size());

        for (int i = 0; i < testClasses.size(); i++) {
            assertEquals(testClasses.get(i).getName(), remainingClass.get(i).getName());
        }
    }


}
