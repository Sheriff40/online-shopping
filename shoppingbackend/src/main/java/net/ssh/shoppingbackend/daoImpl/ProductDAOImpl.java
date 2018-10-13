package net.ssh.shoppingbackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Product;

@Repository("ProductDAOImpl")
@Transactional
public class ProductDAOImpl implements productDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		
		String getProducts = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(getProducts);
		return query.getResultList();
	
	}

	@Override
	public Product getById(int id) {
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
	}

	@Override
	public boolean insert(Product product) {
		try
		{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getActiveProducts() {
		String getProducts = "FROM Product WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(getProducts);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId) 
	{
		String getProducts = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(getProducts)
		.setParameter("active",true)
		.setParameter("categoryId",categoryId)
		.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String getProducts = "FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(getProducts)
		.setParameter("active",true)
		.setFirstResult(0)
		.setMaxResults(count)
		.getResultList();
	}

	
}
