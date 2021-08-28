package br.dev.projeto.query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import br.dev.projeto.entities.Funcionarios;
import br.dev.projeto.hibernate.HibernateUtils;

public class QueryObjectDemo {

	public static void main(String[] args) {

		 SessionFactory factory = HibernateUtils.getSessionFactory();
		 
	       Session session = factory.getCurrentSession();
	 
	       try {
	            
	           // All the action with DB via Hibernate
	           // must be located in one transaction.
	           // Start Transaction.            
	           session.getTransaction().begin();
	 
	    
	            
	           // Create an HQL statement, query the object.
	           // Equivalent to the SQL statement:
	           // Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
	           String sql = "Select e from " + Funcionarios.class.getName() + " e "
	                   + " order by e.empName, e.empNo ";
	 
	   
	           // Create Query object.
	           Query<Funcionarios> query = session.createQuery(sql);
	 
	    
	           // Execute query.
	           List<Funcionarios> funcionarios = query.getResultList();
	 
	           for (Funcionarios func : funcionarios) {
	               System.out.println("Emp: " + func.getFuncionarioNo() + " : "
	                       + func.getFuncionarioNome());
	           }
	  
	           // Commit data.
	           session.getTransaction().commit();
	       } catch (Exception e) {
	           e.printStackTrace();
	           // Rollback in case of an error occurred.
	           session.getTransaction().rollback();
	       }
	   }
}
