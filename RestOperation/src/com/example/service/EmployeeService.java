package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {

	public void createEmployee(Employee employee) throws SQLException;

	public void deleteEmployee(int id) throws SQLException;

	public void updateEmployee(Employee employee, int id) throws SQLException;

	public List<Employee> getEmployeeList(Employee employee) throws SQLException;

	public Employee getEmployeeById(Employee employee, int id) throws SQLException;

}
