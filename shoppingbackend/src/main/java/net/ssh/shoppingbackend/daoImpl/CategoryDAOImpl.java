package net.ssh.shoppingbackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dto.Category;


@Repository(value = "CategoryDAOImpl")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> getCustomers() {
		String selectActive = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActive);
		query.setParameter("active",true);
		return query.getResultList();
		
	}


	@Override
	public Category getById(int id) {
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		
	}


	@Override

	public boolean insert(Category category) {
		
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean update(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
}
