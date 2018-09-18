package fr.M2ccn.DAO;

import java.util.List;
import fr.M2ccn.Entité.Employee;
import fr.M2ccn.Entité.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;




public class EntiteImp implements EntiteDAO {
	private EntityManager entityManager;
	
	public EntiteImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		entityManager = emf.createEntityManager();
		
		
	}

	public void addEmployee(Employee E) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(E);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		

	}
	

	public void addDepartment(Department D) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(D);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	public List<Employee> Employes() {
		//creer un objet Query en utilisant le methode createQuery() de entityManager
		// avec la requete JPA appelé HQL ou JPA QL sans connaitre les tables mais que les classes
		
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> liste = query.getResultList();
		return liste;
	}
	public List<Department> departments() {
		//creer un objet Query en utilisant le methode createQuery() de entityManager
		// avec la requete JPA appelé HQL ou JPA QL sans connaitre les tables mais que les classes
		
		Query query=entityManager.createQuery("select d from Department d");
		List<Department> liste = query.getResultList();
		return liste;
	}
	public Employee EmployeeparNom(Long id){
		Employee employechercher  =entityManager.find(Employee.class, id);
		return employechercher ;
		
	}
	/*public List<Employee> Employeepariddepart(int id){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> emp  = cb.createQuery();
		Root<Employee> from = emp.from(Employee.class);
		emp.select(from)
		.where(from.get("department").in(id));
		TypedQuery query = entityManager.createQuery(emp);
		return query.getResultList();
		
	}
	
	public List<Employee> Employee() {
	//creation d'une criteria builder
	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	//creation d'une criteriaQuery
	   CriteriaQuery<Object> emp  = cb.createQuery();
	   //creation de la requete au sein de criteriaQuery(select*From Employee e as from
	   Root<Employee> from = emp.from(Employee.class);
	   emp.select(from);
	   //transmission du CriteriaQuery a l'entityManager qui construit la 
	   //requete sql et retourne un TypedQuery
	   TypedQuery query = entityManager.createQuery(emp);
	   //Lancement du TypedQuery qui retourne le resultat de la requete
	   //Object resulset = typedQuery.getSingleResult();
	   //	System.out.println(resulset);
	return query.getResultList();
}*/
	    
}
