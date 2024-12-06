package com.chamod.Services;

import com.chamod.DTO.EmployeeDTO;
import com.chamod.Model.Department;
import com.chamod.Model.Employee;
import com.chamod.Repository.DepartmentRepository;
import com.chamod.Repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class EmployeeService {

    @Inject
    DepartmentRepository departmentRepository;

    @Inject
    EmployeeRepository employeeRepository;


    //saving employee
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        Department department = departmentRepository.findById(employeeDTO.getDepId().longValue());
        EmployeeDTO employeeDTO2 = new EmployeeDTO();

        if (department != null) {
            employee.setName(employeeDTO.getEmployeeName());
            employee.setDepartment(department);
            employeeRepository.persist(employee);
            employeeDTO2.setEmployeeName(employee.getName());
            return employeeDTO2;

        }
        return employeeDTO2;
    }

    public Employee updateDepartment(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getEmployeeId().longValue());

        Department department = departmentRepository.findById(employeeDTO.getDepId().longValue());
        if (employee != null && department != null) {
            employee.setDepartment(department);
        }
        return employee;

    }

    public Employee update(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getEmployeeId().longValue());
        if (employee != null) {
            if (employeeDTO.getEmployeeName() != null){
                employee.setName((employeeDTO.getEmployeeName()));

            }

            if (employeeDTO.getDepId() != null) {
                Department department = departmentRepository.findById(employeeDTO.getDepId().longValue());
                employee.setDepartment(department);
            }
        }
        return employee;
    }


    public Employee deleteEmployee(Integer employeeId) {
        Employee emp = employeeRepository.findById(employeeId.longValue());
        if (emp != null) {
            employeeRepository.delete(emp);
        }
        return emp;
    }

    public EmployeeDTO getEmployee(Integer employeeId) {
        Employee emp = employeeRepository .findById(employeeId.longValue());
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (emp != null) {
            employeeDTO.setEmployeeName(emp.getName());
            employeeDTO.setEmployeeId(emp.getEmployeeId());
            employeeDTO.setDepId(emp.getDepartment().getDepId());
        }
        return employeeDTO;

    }




}
