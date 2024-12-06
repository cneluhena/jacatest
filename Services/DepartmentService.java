package com.chamod.Services;

import com.chamod.DTO.DepartmentDTO;
import com.chamod.Model.Department;
import com.chamod.Repository.DepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class DepartmentService {
    @Inject
    DepartmentRepository departmentRepository;


    public Department saveDepartment(DepartmentDTO depDTO) {
        Department department = new Department();
        department.setDepId(depDTO.getDepartmentId());
        department.setDepName(depDTO.getDepartmentName());
        departmentRepository.persist(department);
        return department;
    }


    public Department updateDepartment(DepartmentDTO depDTO) {
        Department dep = departmentRepository.findById(depDTO.getDepartmentId().longValue());
        if (dep != null) {
            dep.setDepName(depDTO.getDepartmentName());
        }
        return dep;
    }



    public Department deleteDepartment(Integer depId) {
        Department dep = departmentRepository.findById(depId.longValue());
        if (dep != null) {
            departmentRepository.delete(dep);

        }
        return dep;

    }

}
