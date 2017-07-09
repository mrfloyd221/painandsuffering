package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Primary
@Transactional
public class  OrderHibernateRepository implements OrderDAO {


@PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean createOrder(Order order) {
        entityManager.persist(order);
        return true;
    }

    @Override
    public boolean deleteOrder(int id) {
        Order order = entityManager.find(Order.class, id);
        if(order == null)
            return false;
        entityManager.remove(order);
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        if (isOrderExist(order.getUser().getId(), order.getPosition().getId())) {
            return false;
        } else {
            entityManager.merge(order);
            return true;
        }
    /* Order target = getOrderById(order.getId());
        target.setUserId(order.getUserId());
        target.setPositionId(order.getPositionId());
        entityManager.flush(); */
    }

        @Override
        public Order getOrderById ( int id){
            return entityManager.find(Order.class, id);
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<Order> getOrdersByUserId ( int userId){
            String hql = "FROM Order o WHERE o.userId=:userId";
            return entityManager.createQuery(hql, Order.class).setParameter("userId", userId).getResultList();
        }
        @SuppressWarnings("unchecked")
        @Override
        public List<Order> getAllOrders () {
            String hql = "FROM Order";
            return entityManager.createQuery(hql, Order.class).getResultList();
        }


    private boolean isOrderExist(int userId, int positionId) {
        String hql = "FROM Order as o WHERE o.user = :userId and o.position = :positionId";
        int count = entityManager.createQuery(hql).setParameter("userId", userId).setParameter("positionId", positionId).getResultList().size();
        return count > 0;
    }
}


