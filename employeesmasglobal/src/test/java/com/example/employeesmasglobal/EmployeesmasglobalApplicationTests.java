package com.example.employeesmasglobal;

import com.example.employeesmasglobal.routes.Router;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
class EmployeesmasglobalApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void createEmployee() throws Exception{
		mock.perform(post(Router.BASE + Router.CREATE_EMPLOYEE)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"cc\": \"1234\", \"firstName\": \"Manuel\",\"hourly\": true\",\"hourlySalary\": 15000,\"lastName\": \"Garcia\",\"position\": \"Developer\"}")
		).andDo(print());
	}

	@Test
	@Order(1)
	void callEmployees() throws Exception {
		mock.perform(get(Router.BASE+Router.EMPLOYEES)).andDo(print());
	}

}
