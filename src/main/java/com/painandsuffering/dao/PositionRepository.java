package com.painandsuffering.dao;

import com.painandsuffering.model.Position;

import java.util.List;
import org.springframework.stereotype.Repository;
/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class PositionRepository implements PositionDAO {
    @Override
    public Position getPositionById(int id) {
        return null;
    }

    @Override
    public Position getPositionByName(String name) {
        return null;
    }

    @Override
    public List<Position> getAllPositions() {
        return null;
    }
}
