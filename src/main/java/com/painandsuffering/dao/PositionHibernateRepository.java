package com.painandsuffering.dao;

import com.painandsuffering.model.Position;
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
    public Position getPositionById(int id) {
        return entityManager.find(Position.class, id);
    }

    @Override
    public Position getPositionByName(String name) {
        return entityManager.find(Position.class, name);
    }

    @Override
    public List<Position> getAllPositions() {
        String hql = "FROM Position";
        return entityManager.createQuery(hql, Position.class).getResultList();
    }

    @Override
    public boolean createPosition(Position position) {
        entityManager.persist(position);
        return true;
    }

    @Override
    public boolean updatePosition(Position position) {
        if(isPositionExist(position.getName(),position.getPrice())){
            entityManager.merge(position);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePosition(int id) {
        Position position = entityManager.find(Position.class, id);
        if(position == null)
            return false;
        entityManager.remove(position);
        return true;
    }
    private boolean isPositionExist(String name, int price) {
        String hql = "FROM Position as p WHERE p.name = :name and p.price = :price";
        int count = entityManager.createQuery(hql).setParameter("name", name).setParameter("price", price).getResultList().size();
        return count > 0;
    }
}
