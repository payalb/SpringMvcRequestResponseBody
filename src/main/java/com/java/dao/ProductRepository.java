/*package com.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dto.Product;

@Repository
public class ProductRepository {

	@Autowired SessionFactory factory;
	
	
	public List<Product> getProducts(){
		Session sf= factory.openSession();
		List<Product> list= sf.createCriteria(Product.class).list();
		sf.close();
		return list;
	}
	
	
	public int saveProduct(Product product){
		Session s= factory.openSession();
		s.beginTransaction();
		int id=(int) s.save(product);
		s.getTransaction().commit();
		s.close();
		return id;
	}


	public void deleteProduct(int id) {
		Session s= factory.openSession();
		s.beginTransaction();
		s.remove(s.load(Product.class, id));
		s.getTransaction().commit();
		s.close();
		
	}


	public void updateProduct(Product product) {
		Session s= factory.openSession();
		s.beginTransaction();
		 s.update(product);
		s.getTransaction().commit();
		s.close();
		
	}
}
*/