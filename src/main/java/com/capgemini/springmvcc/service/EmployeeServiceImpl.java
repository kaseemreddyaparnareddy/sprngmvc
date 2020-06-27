package com.capgemini.springmvcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvcc.dao.EmployeeDAO;
import com.capgemini.springmvcc.dao.EmployeeDAOImpl;
import com.capgemini.springmvcc.dto.EmployeeBean;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO empdao;

	public EmployeeBean getEmployeeByid(int Id) {

		return empdao.getEmployeeByid(Id);
	}

	public boolean addEmployee(EmployeeBean bean) {

		return empdao.addEmployee(bean);
	}

	public boolean updateEmployee(EmployeeBean bean) {

		return empdao.updateEmployee(bean);
	}

	public boolean deleteEmployee(int Id) {

		return empdao.deleteEmployee(Id);
	}

	public List<EmployeeBean> getAllEmployees() {

		return empdao.getAllEmployees();
	}

}
