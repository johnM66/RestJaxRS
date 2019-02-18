package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.DBConnection.MySqlConnection;
import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final String INSERT = "insert into employee(empid, emp_name, emp_age, salary, address,) values(?,?,?,?,?)";
	private static final String DELETE = "delete from employee where empid=?";
	private static final String UPDATE = "update employee set emp_name=?,emp_age=?,salary=?,address=? where empid=? ";
	private static final String FETCH = "select *from employee";
	private static final String FETCH_1 = "select *from employee where emp_id=?";
	@Override
	public void createEmployee(Employee employee) throws SQLException {

		PreparedStatement ps = callPreparedStatement(INSERT);
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getName());
		ps.setInt(3, employee.getAge());
		ps.setLong(4, employee.getSalary());
		ps.setString(5, employee.getAddress());
		int executeUpdate = ps.executeUpdate();
		if (executeUpdate > 0) {
			System.out.println("Created successfully");
		}

	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		if (id != 0) {
		PreparedStatement ps = callPreparedStatement(DELETE);
		ps.setInt(1, id);
		int del = ps.executeUpdate();
		if (del > 0) {
			System.out.println("Created successfully");
		}
		}

	}

	@Override
	public void updateEmployee(Employee employee, int id) throws SQLException {
		PreparedStatement ps = callPreparedStatement(UPDATE);
		ps.setString(1, employee.getName());
		ps.setInt(2, employee.getAge());
		ps.setLong(3, employee.getSalary());
		ps.setString(4, employee.getAddress());
		ps.setInt(5, employee.getId());
		int update = ps.executeUpdate();
		if (update > 0) {
			System.out.println("Created successfully");
		}
	}

	@Override
	public List<Employee> getEmployeeList(Employee employee) throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		PreparedStatement ps = callPreparedStatement(FETCH);
		ResultSet rs = ps.executeQuery();
		employee.setId(rs.getInt("emp_id"));
		employee.setName(rs.getString("emp_name"));
		employee.setAge(rs.getInt("emp_age"));
		employee.setSalary(rs.getLong("salary"));
		employee.setAddress(rs.getString("address"));
		list.add(employee);
		return list;
	}

	@Override
	public Employee getEmployeeById(Employee employee, int id) throws SQLException {
		PreparedStatement ps = callPreparedStatement(FETCH_1);
		ps.setInt(1, id);
		ResultSet executeQuery = ps.executeQuery();
		employee.setId(executeQuery.getInt("emp_id"));
		employee.setName(executeQuery.getString("emp_name"));
		employee.setAge(executeQuery.getInt("emp_age"));
		employee.setSalary(executeQuery.getLong("salary"));
		employee.setAddress(executeQuery.getString("address"));
		return employee;
	}

	private PreparedStatement callPreparedStatement(String sql) throws SQLException {
		Connection connection = MySqlConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		return ps;
	}

}
