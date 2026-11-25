package ru.kafpin.laboratoriya;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LaboratoriyaApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void formGeneratesGroupAndPortalLogin() throws Exception {
        mvc.perform(get("/form")).andExpect(status().isOk()).andExpect(view().name("main-form"));
        mvc.perform(post("/form")
                .param("id", "12").param("name", "Анна").param("surname", "Соколова")
                .param("patronymic", "Игоревна").param("email", "anna@example.com").param("enrollmentYear", "2020"))
                .andExpect(status().isOk()).andExpect(view().name("result"))
                .andExpect(content().string(containsString("ПИНз-120")))
                .andExpect(content().string(containsString("student-pinz120-12")));
    }

    @Test
    void invalidFormIsDisplayedAgain() throws Exception {
        mvc.perform(post("/form").param("id", "-1").param("email", "incorrect"))
                .andExpect(status().isOk()).andExpect(view().name("main-form"))
                .andExpect(model().attributeHasFieldErrors("student", "id", "email", "enrollmentYear"));
    }
}
