package com.example.employeesmasglobal;

import com.example.employeesmasglobal.entities.EmployeeEntity;
import com.example.employeesmasglobal.routes.Router;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class EmployeesmasglobalApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	void createEmployee() throws Exception{
		EmployeeEntity employee = new EmployeeEntity();
		employee.setCC("244534");
		employee.setFirstName("Test 1");
		employee.setLastName("Name 1");
		employee.setPosition("Developer");
		employee.setHourly(false);
		employee.setHourlySalary(10.0);
		String jsonString = asJsonString(employee);

		 mock.perform(post(Router.BASE + Router.CREATE_EMPLOYEE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)
		)
				.andExpect(status().isOk());
	}

	@Test
	void callEmployees() throws Exception {
		mock.perform(get(Router.BASE+Router.EMPLOYEES)).andDo(print());
	}

	@Test
	void callEmployeeByCC() throws Exception{
		String id = "1234";
		mock.perform(get(Router.BASE+Router.EMPLOYEE.replace("{CC}",id)))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void deleteEmployeeByCC() throws Exception{
		String id = "4321";
		mock.perform(delete(Router.BASE+Router.DELETE_EMPLOYEE.replace("{CC}",id)))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

	@Test
	void modifyEmployeeByCC() throws Exception{
		EmployeeEntity employee = new EmployeeEntity();
		employee.setCC("1234");
		employee.setFirstName("Test 1");
		employee.setLastName("Name 1");
		employee.setPosition("Developer");
		employee.setHourly(false);
		employee.setHourlySalary(10.0);
		String jsonString = asJsonString(employee);

		mock.perform(put(Router.BASE + Router.UPDATE_EMPLOYEE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)
		)
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
