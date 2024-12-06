package com.chamod.Repository;

import com.chamod.Model.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;


@ApplicationScoped
public class DepartmentRepository implements PanacheRepository<Department> {

}
