package com.chamod.Controllers;


import com.chamod.DTO.DepartmentDTO;
import com.chamod.DTO.EmployeeDTO;
import com.chamod.Model.Department;
import com.chamod.Model.Employee;
import com.chamod.Services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;


    @GET
    @Path("/get/{id}")
    public Response getEmployee(@PathParam("id") int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        return Response.status(Response.Status.OK).entity(employee).build();

    }




    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO2 = employeeService.saveEmployee(employeeDTO);
        return Response.status(Response.Status.CREATED).entity(employeeDTO2).build();
    }


    @PATCH
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(EmployeeDTO employeeDTO) {
        Employee employee = employeeService.update(employeeDTO);
        return Response.status(Response.Status.OK).entity(employee).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteEmployee(@PathParam("id") int id) {
        Employee emp = employeeService.deleteEmployee(id);
        return Response.status(Response.Status.OK).entity(emp).build();
    }

}
