package com.chamod.Controllers;


import com.chamod.DTO.DepartmentDTO;
import com.chamod.Model.Department;
import com.chamod.Services.DepartmentService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;

@Path("/department")
public class DepartmentController {
    @Inject
    DepartmentService departmentService;

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addDepartment(DepartmentDTO departmentDTO){
            Department dep = departmentService.saveDepartment(departmentDTO);
            return Response.status(Response.Status.CREATED).entity(dep).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDepartment(DepartmentDTO departmentDTO){
        Department dep = departmentService.updateDepartment(departmentDTO);
        return Response.status(Response.Status.CREATED).entity(dep).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteDepartment(@PathParam("id") int id){
        Department dep = departmentService.deleteDepartment(id);
        return Response.status(Response.Status.OK).entity(dep).build();
    }


}
