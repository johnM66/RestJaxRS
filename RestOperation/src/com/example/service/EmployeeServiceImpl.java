package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao employeeDao;
	@Override
	public void createEmployee(Employee employee) throws SQLException {
		employeeDao.createEmployee(employee);

	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		employeeDao.deleteEmployee(id);

	}

	@Override
	public void updateEmployee(Employee employee, int id) throws SQLException {
		employeeDao.updateEmployee(employee, id);

	}

	@Override
	public List<Employee> getEmployeeList(Employee employee) throws SQLException {
		return employeeDao.getEmployeeList(employee);

	}

	@Override
	public Employee getEmployeeById(Employee employee, int id) throws SQLException {

		return employeeDao.getEmployeeById(employee, id);
	}



}
