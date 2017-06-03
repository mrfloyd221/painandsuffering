package com.painandsuffering.dao;

import com.painandsuffering.model.Position;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class PositionRepository implements PositionDAO {
    List<Position> positions;

    public PositionRepository() {
        this.positions = new ArrayList<Position>();
        positions.add(new Position(0, "pizza"));
        positions.add(new Position(1, "coffee"));
        positions.add(new Position(2, "tea"));
        positions.add(new Position(3, "whiskey"));
    }

    @Override
    public Position getPositionById(int id) {
        return positions.get(id);
    }

    @Override
    public Position getPositionByName(String name) {
        for(Position pos : positions){
            if(pos.getName().equals(name))
                return pos;
        }
        return null;
    }

    @Override
    public List<Position> getAllPositions() {
        return positions;
    }
    public void Add(Position position){
        positions.add(position);
    }
    public void DeleteById(int id){
        positions.remove(id);
    }
    public void DeleteByName(String name){
        for(Position pos : positions){
            if(pos.getName().equals(name))
                positions.remove(pos);
        }
    }
}
