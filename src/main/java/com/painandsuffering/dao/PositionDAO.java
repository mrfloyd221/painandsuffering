package com.painandsuffering.dao;
import com.painandsuffering.model.Position;
import java.util.List;
/**
 * Created by mrflo on 28.05.2017.
 */
public interface PositionDAO {
    Position getPositionById(int id);
    Position getPositionByName(String name);
    List<Position> getAllPositions();
}
