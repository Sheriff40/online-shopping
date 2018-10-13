package net.ssh.shoppingbackend.daoImpl;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ssh.shoppingbackend.dao.userDAO;
import net.ssh.shoppingbackend.dto.Address;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.User;

@Repository(value = "userDAOImpl")
@Transactional
public class userDAOImpl implements userDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) {
		
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
	}

	@Override
	public User getUserByEmail(String email) {
		String getByEmail = "FROM User WHERE email = :email";
		try
		{
			return sessionFactory.getCurrentSession().createQuery(getByEmail,User.class).setParameter("email",email)
			.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Address getBillingAddress(User user) {
	
		String sql = "FROM Address WHERE user = :user AND billing=:billing";
		try
		{
			return sessionFactory.getCurrentSession().createQuery(sql,Address.class).setParameter("user",user).
			setParameter("billing", true).getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getShippingAddress(User user) {
		String sql = "FROM Address WHERE user = :user AND shipping=:shipping";
		try
		{
			return sessionFactory.getCurrentSession().createQuery(sql,Address.class).setParameter("user",user).
			setParameter("shipping", true).getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}



}
