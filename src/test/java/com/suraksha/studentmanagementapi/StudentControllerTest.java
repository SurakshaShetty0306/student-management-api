package com.suraksha.studentmanagementapi;

import com.suraksha.studentmanagementapi.controller.StudentController;
import com.suraksha.studentmanagementapi.entity.Student;
import com.suraksha.studentmanagementapi.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StudentControllerTest {

    private MockMvc mockMvc;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = mock(StudentService.class);

        StudentController controller =
                new StudentController(studentService);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void shouldGetAllStudents() throws Exception {

        when(studentService.getAllStudents())
                .thenReturn(List.of(new Student(
                        "Rahul Kumar",
                        "rahul@example.com",
                        "Computer Science and Engineering",
                        21,
                        null
                )));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }
}