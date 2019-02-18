package com.example.controlller;

import java.sql.SQLException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@Path("/emp")
public class RestController {
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";
	EmployeeService employeeService;

	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployee(Employee employee) throws SQLException {
		return employeeService.getEmployeeList(employee);
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/employeesById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeById(Employee employee, @PathParam("id") int id) throws SQLException {
		return (List<Employee>) employeeService.getEmployeeById(employee, id);
	}

	@POST
	@Path("/employeeCreate")
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Employee employee) throws SQLException {
		employeeService.createEmployee(employee);

	}

	@DELETE
	@Path("/employeeDelete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") int id) throws SQLException {
		employeeService.deleteEmployee(id);

	}

	@PUT
	@Path("/employeeUpdate/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Employee employee, @PathParam("id") int id) throws SQLException {
		employeeService.updateEmployee(employee, id);

	}

}
