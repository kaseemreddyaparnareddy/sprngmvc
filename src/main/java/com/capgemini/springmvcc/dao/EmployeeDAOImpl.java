package com.capgemini.springmvcc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.capgemini.springmvcc.dto.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeBean getEmployeeByid(int empId) {
		EmployeeBean employeeInfoBean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false",
					"aparna", "route");
			pstmt = connection.prepareStatement("select * from employeeinfo where id=?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employeeInfoBean = new EmployeeBean();
				employeeInfoBean.setEmpId(rs.getInt("empId"));
				employeeInfoBean.setAge(rs.getInt("age"));
				employeeInfoBean.setEmpName(rs.getString("empName"));
				employeeInfoBean.setDesignation(rs.getString("designation"));
				employeeInfoBean.setPassword(rs.getString("password"));
				employeeInfoBean.setSalary(rs.getDouble("salary"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return employeeInfoBean;
	}

	public boolean addEmployee(EmployeeBean bean) {

		String query1 = "insert into employeeinfo values(?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false",
					"aparna", "route");

			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);

			preparedStatement1.setInt(1, bean.getEmpId());
			preparedStatement1.setString(2, bean.getEmpName());
			preparedStatement1.setInt(3, bean.getAge());
			preparedStatement1.setDouble(4, bean.getSalary());
			preparedStatement1.setString(5, bean.getDesignation());
			preparedStatement1.setString(6, bean.getPassword());

			int result = preparedStatement1.executeUpdate();

			if (result != 0) {
				System.out.println("values are inserted succefully");
				return true;
			}

			connection.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;

	}

	public boolean updateEmployee(EmployeeBean bean) {
		EmployeeBean emppbean = null;
		boolean isUpdated = false;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false",
					"aparna", "route");
			PreparedStatement pstmt = connection.prepareStatement("update employeeinfo set name=? where id=? ");
			pstmt.setString(1, bean.getEmpName());
			pstmt.setInt(2, bean.getEmpId());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("values are updated succefully");
				isUpdated = true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return isUpdated;
	}

	public boolean deleteEmployee(int empId) {

		boolean isDeleted = false;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false",
					"aparna", "route");
			PreparedStatement pstmt1 = connection.prepareStatement("delete from  employeeinfo  where id=?");

			pstmt1.setInt(1, empId);

			int result = pstmt1.executeUpdate();
			if (result > 0) {
				System.out.println("values deleted succefully");
				isDeleted = true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return isDeleted;
	}

	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> listInfo = new ArrayList<EmployeeBean>();

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false",
					"aparna", "route");
			PreparedStatement pstmt1 = connection.prepareStatement("select * from employeeinfo");
			rs = pstmt1.executeQuery();

			while (rs.next()) {
				EmployeeBean bean2 = new EmployeeBean();

				bean2.setEmpName(rs.getString("empName"));
				bean2.setAge(rs.getInt("age"));
				bean2.setPassword(rs.getString("password"));
				bean2.setDesignation(rs.getString("designation"));
				bean2.setSalary(rs.getDouble("salary"));
				bean2.setEmpId(rs.getInt("empId"));

				listInfo.add(bean2);
			}
			return listInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return null;

	}

}
