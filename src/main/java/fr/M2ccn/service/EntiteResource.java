package fr.M2ccn.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Path("/liste")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getListeEmployee(){
		return emp.Employes();
		
	}
	@GET
	@Path("AjouteDepartement/{dep}")
	public String ajouterdapartment(@PathParam(value="dep") Department dep) {
		emp.addDepartment(dep);
		return "Un nouveau Departement créé";
	}
}
