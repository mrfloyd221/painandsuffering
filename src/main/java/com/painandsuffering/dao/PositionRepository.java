package com.painandsuffering.dao;

import com.painandsuffering.model.Product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class PositionRepository implements PositionDAO {
    List<Product> products;

    public PositionRepository() {
        this.products = new ArrayList<Product>();
        products.add(new Product(0, "pizza", 50));
        products.add(new Product(1, "coffee", 600));
        products.add(new Product(2, "tea", 55));
        products.add(new Product(3, "whiskey", 100));
    }

    @Override
    public Product getPositionById(int id) {
        return products.get(id);
    }

    @Override
    public Product getPositionByName(String name) {
        for(Product pos : products){
            if(pos.getName().equals(name))
                return pos;
        }
        return null;
    }    @Override
    public List<Product> getAllPositions() {
        return products;
    }
    @Override
    public boolean createPosition(Product product){
        if(!products.contains(product)){
            products.add(product);
            return true;
        }
        return false;


    }
    @Override
    public boolean updatePosition(Product product){
        if(products.contains(products.get(product.getId()))){
            products.get(product.getId()).setName(product.getName());
            return true;
        }
        return false;
    }
    @Override
    public boolean deletePosition(int id){
        products.remove(id);
        return true;
    }

}
