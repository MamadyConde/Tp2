package fr.M2ccn.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.M2ccn.DAO.EntiteImp;
import fr.M2ccn.Entité.Department;
import fr.M2ccn.Entité.Employee;

@Path("/entreprise")
public class EntiteResource {
	private EntiteImp emp;
	
	public EntiteResource() {
		emp = new EntiteImp();
	}
	@GET
	public String hello(){
		return "Hello Word";
	}
	@GET
	@Path("/liste/Employee")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getListeEmployee(){
		return emp.Employes();	
	}
	@GET
	@Path("/liste/Departement")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getListeDepartement(){
		return emp.departments();	
	}
	@POST
	@Path("AjouteDepartement")
	@Consumes(MediaType.APPLICATION_JSON)
	public String ajouterdapartment(Department dep) {
		emp.addDepartment(dep);
		return "Un nouveau Departement créé";
	}
	@POST
	@Path("AjouteEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public String ajouterEmploye(Employee E) {
		emp.addEmployee(E);;
		return "Welcome";
	}
	@GET
	@Path("ChercherEmployee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee ChercherEmployee(@PathParam(value="id")Long id) {
		 
		return emp.EmployeeparNom(id);
	}
}
