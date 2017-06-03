package com.painandsuffering.controller;


        import com.painandsuffering.model.Position;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import com.painandsuffering.service.ShopService;
        import com.painandsuffering.dao.*;
        import java.util.List;
/**
 * Created by mrflo on 26.05.2017.
 */
@RestController
public class PositionController {
    @Autowired
    private PositionRepository positionsRepository;

    private PositionController(){
        positionsRepository = new PositionRepository();
    }
    private
    @RequestMapping(value="/shop/positions/{id}", method = RequestMethod.GET , produces = "application/json")
    String getPositionById(@PathVariable int id) {
        return positionsRepository.getPositionById(id).toString();
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.GET, produces = "application/json")
    String getAllPositions(){
        List<Position> list = positionsRepository.getAllPositions();
        StringBuilder result = new StringBuilder("[");
        for(Position pos : list){
            result.append(pos.toString()+",");
        }
        result.deleteCharAt(result.lastIndexOf(","));
        result.append("]");
        return result.toString();
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.POST)
    ResponseEntity<Position> addNewPosition(@RequestBody Position pos){
        positionsRepository.Add(pos);
        return new ResponseEntity<Position>(pos, HttpStatus.OK);
    }
}
