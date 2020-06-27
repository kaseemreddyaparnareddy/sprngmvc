package com.capgemini.springmvcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.springmvcc.dto.EmployeeBean;
import com.capgemini.springmvcc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/searchEmployeeForm")
	public String dispalySearchEmployeeForm() {

		return "searchEmployee";
	}

	@GetMapping("/searchEmp")
	public String searchEmployee(@RequestParam(name = "empId") int empIdVal, ModelMap modelMap) {
		EmployeeBean bean = employeeService.getEmployeeByid(empIdVal);
		if (bean != null) {
			modelMap.addAttribute("empInfo", bean);
		} else {
			modelMap.addAttribute("errmsg", "Employee Details not found");

		}
		return "searchEmployee";
	}

	@GetMapping("/addEmployeeForm")
	public String displayAddEmployee() {

		return "addEmployee";
	}

	@PostMapping("/addEmp")
	public String addEmployee(EmployeeBean bean, ModelMap modelMap) {

		boolean isAdded = employeeService.addEmployee(bean);

		if (isAdded) {
			modelMap.addAttribute("msg", "Employee Added succesfully");

		} else {
			modelMap.addAttribute("errMsg", "Unable to Add Employee Details");
		}
		return "addEmployee";
	}

	@GetMapping("/updateEmployeeForm")
	public String dispalyUpadteEmployee() {

		return "updateEmployee";
	}

	@GetMapping("/updateEmp")
	public String updateEmployee(EmployeeBean bean, ModelMap modelMap) {

		boolean updated = employeeService.updateEmployee(bean);
		if (updated) {
			modelMap.addAttribute("msg", "Employee Details Updated");
		} else {
			modelMap.addAttribute("errMsg", "Employee Details not Updated");
		}
		return "updateEmployee";
	}

	@GetMapping("/deleteEmployeeForm")
	public String dispalyDeleteEmployee() {

		return "deleteEmployee";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmployee(int empId, ModelMap modelMap) {

		boolean updated = employeeService.deleteEmployee(empId);
		if (updated) {
			modelMap.addAttribute("msg", "Employee Details deleted");
		} else {
			modelMap.addAttribute("errMsg", "Employee Details not deleted");
		}
		return "deleteEmployee";

	}

	@GetMapping("/getAllEmployees")
	public String dispalyAllEmployee() {

		return "allEmployeeDetails";
	}

	@GetMapping("/allEmp")
	public String allEmployee(EmployeeBean bean, ModelMap modelMap) {

		List<EmployeeBean> bean1 = employeeService.getAllEmployees();
		if (bean1 != null && !bean1.isEmpty()) {
			modelMap.addAttribute("msg", bean1);
		} else {
			modelMap.addAttribute("errMsg", "Employee Details not deleted");
		}

		return "allEmployeeDetails";

	}
}
