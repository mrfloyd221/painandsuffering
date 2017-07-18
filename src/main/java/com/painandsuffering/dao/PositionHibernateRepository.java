package com.painandsuffering.dao;

import com.painandsuffering.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Primary
@Transactional
public class PositionHibernateRepository implements PositionDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Product getPositionById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product getPositionByName(String name) {
        return entityManager.find(Product.class, name);
    }

    @Override
    public List<Product> getAllPositions() {
        String hql = "FROM Position";
        return entityManager.createQuery(hql, Product.class).getResultList();
    }

    @Override
    public boolean createPosition(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    public boolean updatePosition(Product product) {
        if(isPositionExist(product.getName(), product.getPrice())){
            entityManager.merge(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePosition(int id) {
        Product product = entityManager.find(Product.class, id);
        if(product == null)
            return false;
        entityManager.remove(product);
        return true;
    }
    private boolean isPositionExist(String name, int price) {
        String hql = "FROM Position as p WHERE p.name = :name and p.price = :price";
        int count = entityManager.createQuery(hql).setParameter("name", name).setParameter("price", price).getResultList().size();
        return count > 0;
    }
}
