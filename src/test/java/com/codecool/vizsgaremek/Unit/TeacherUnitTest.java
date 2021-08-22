package com.codecool.vizsgaremek.Unit;

import com.codecool.vizsgaremek.controller.TeacherController;
import com.codecool.vizsgaremek.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TeacherController.class)
public class TeacherUnitTest {

    @MockBean
    private TeacherService service;

    @Autowired
    private MockMvc mockMvc;




}
