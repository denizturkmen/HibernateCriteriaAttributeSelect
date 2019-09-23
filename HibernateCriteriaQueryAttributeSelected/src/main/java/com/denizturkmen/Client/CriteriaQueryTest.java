package com.denizturkmen.Client;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class CriteriaQueryTest {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(root.get("email")); // özel column seçmek
			//dikket edilmesi gereken string int türümü ona göre createQuery belirtmem lazım
			
			
			Query<String> createQuery = session.createQuery(criteriaQuery);
			List<String> empnamelist = createQuery.getResultList();
			empnamelist.forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
