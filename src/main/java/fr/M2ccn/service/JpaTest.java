package fr.M2ccn.service;


import java.util.List;

import fr.M2ccn.DAO.EntiteImp;
import fr.M2ccn.Entité.Department;
import fr.M2ccn.Entité.Employee;

public class JpaTest {

	public static void main(String[] args) {

		EntiteImp emp = new EntiteImp();
		
			Department d1 = new Department("Informatique");
			emp.addDepartment(d1);
			
			Department d2 = new Department("Finance");
			emp.addDepartment(d2);
			
			Department d3 = new Department("RH");
			emp.addDepartment(d3);
			
			emp.addEmployee(new Employee("Jakab Gipsz",d1));
			emp.addEmployee(new Employee("Captain Nemo",d2));
			emp.addEmployee(new Employee("ines",d3));
			System.out.println("----------------------");
			List<Employee> prods =emp.Employes();
			for (Employee empl : prods) {
				System.out.println(empl.getName());
			}
			
	}
}

	
