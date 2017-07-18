package com.painandsuffering.dao;
import com.painandsuffering.model.Product;
import java.util.List;
/**
 * Created by mrflo on 28.05.2017.
 */
public interface PositionDAO {
    Product getPositionById(int id);
    Product getPositionByName(String name);
    List<Product> getAllPositions();
    boolean createPosition(Product product);
    boolean updatePosition(Product product);
    boolean deletePosition(int id);
}
