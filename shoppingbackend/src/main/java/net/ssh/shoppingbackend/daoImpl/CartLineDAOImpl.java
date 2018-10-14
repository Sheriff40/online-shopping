package net.ssh.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.CartLine;

@Repository(value = "CartLineDAOImpl")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insert(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public CartLine getById(int id) {
		try {
			String sql = "FROM CartLine WHERE id = :id";
			return (CartLine) sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id)
					.getSingleResult();

		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public List<CartLine> getCartLine() {
		String sql = "FROM CartLine";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();

	}

	@Override
	public List<CartLine> getAvailableLine() {
		String sql = "FROM CartLine WHERE isAvailable = :available";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();

	}

	@Override
	public CartLine getByProductAndCartId(int cartId, int productId) {
		try {
			String sql = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
			return (CartLine) sessionFactory.getCurrentSession().createQuery(sql).setParameter("cartId", cartId)
					.setParameter("productId", productId).getSingleResult();

		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<CartLine> getByCartId(int cartId) {
		try {
			String sql = "FROM CartLine WHERE cartId = :cartId";
			return sessionFactory.getCurrentSession().createQuery(sql, CartLine.class).setParameter("cartId", cartId)
					.getResultList();

		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {

		CartLine cartline = this.getById(id);

		try {
			sessionFactory.getCurrentSession().delete(cartline);
			return true;
		} catch (Exception ex) {
			return false;

		}
	}

}
