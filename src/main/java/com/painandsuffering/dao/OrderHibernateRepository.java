package com.jsonfloyd.dao;

import com.jsonfloyd.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository
@Transactional
public class  OrderHibernateRepository implements OrderDao{


   @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void removeOrderById(int id) {
        entityManager.remove(getOrderById(id));
    }

    @Override
    public void updateOrder(Order order) throws Exception{
        if(isOrderExist(order.getUserId(), order.getPositionId())){

            throw new Exception("Order already exist");
        }
        else{
            entityManager.merge(order);
        }
       /* Order target = getOrderById(order.getId());
        target.setUserId(order.getUserId());
        target.setPositionId(order.getPositionId());
        entityManager.flush();*/
    }

    @Override
    public Order getOrderById(int id) {
        return entityManager.find(Order.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getOrdersByUserId(int userId) {
        String hql = "FROM Order o WHERE o.userId=:userId";
        return entityManager.createQuery(hql, Order.class).setParameter("userId", userId).getResultList();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getAllOrders() {
        String hql = "FROM Order";
        return entityManager.createQuery(hql, Order.class).getResultList();
    }
    @Override
    public boolean isOrderExist(int userId, int positionId){
        String hql = "FROM Order as o WHERE o.userId = ? and o.positionId = ?";
        int count = entityManager.createQuery(hql).setParameter(1, userId).setParameter(2, positionId).getResultList().size();
        return count > 0;
    }

}
