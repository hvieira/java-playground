package org.hvieira.tutorial;

import java.util.UUID;

import org.hvieira.tutorial.adapters.EmployeeRepository;
import org.hvieira.tutorial.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:integration-testing-application.properties")
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    MockMvc mvc;

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

		Employee employee = createTestEmployee(new Employee(UUID.randomUUID(), "Test 1", 100000));

		mvc.perform(get("/employees")
				.header(HttpHeaders.AUTHORIZATION, "Bearer dummy")
				)
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].id", hasItem(employee.getId().toString())))
				.andExpect(jsonPath("$[*].name", hasItem(employee.getName())))
				.andExpect(jsonPath("$[*].monthlySalary", hasItem(employee.getMonthlySalary())))
				;
	}

	private Employee createTestEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
