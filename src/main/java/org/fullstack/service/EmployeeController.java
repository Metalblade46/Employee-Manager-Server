package org.fullstack.service;

import org.fullstack.Entity.Employee;
import org.fullstack.logic.EmployeeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/employee")
@Transactional
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(){
        return Response.ok(employeeService.findAllEmployees()).build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEmployeeById(@PathParam("id")long id){
        return Response.ok(employeeService.findEmployeebyId(id)).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return Response.ok(newEmployee).build();
    }
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Employee employee){
        Employee newEmployee = employeeService.updateEmployee(employee);
        return Response.ok(newEmployee).build();
    }
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmployeeById(@PathParam("id")long id){
        employeeService.deleteEmployee(id);
        return Response.ok().build();
    }
}
