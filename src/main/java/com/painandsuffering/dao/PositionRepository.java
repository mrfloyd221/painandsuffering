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
        positions.add(new Position(0, "pizza", 50));
        positions.add(new Position(1, "coffee", 600));
        positions.add(new Position(2, "tea", 55));
        positions.add(new Position(3, "whiskey", 100));
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
    }    @Override
    public List<Position> getAllPositions() {
        return positions;
    }
    @Override
    public boolean createPosition(Position position){
        if(!positions.contains(position)){
            positions.add(position);
            return true;
        }
        return false;


    }
    @Override
    public boolean updatePosition(Position position){
        if(positions.contains(positions.get(position.getId()))){
            positions.get(position.getId()).setName(position.getName());
            return true;
        }
        return false;
    }
    @Override
    public boolean deletePosition(int id){
        positions.remove(id);
        return true;
    }

}
