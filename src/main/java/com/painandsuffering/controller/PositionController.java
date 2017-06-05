package com.painandsuffering.controller;


        import com.painandsuffering.model.Position;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
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
    Position getPositionById(@PathVariable int id) {
        return positionsRepository.getPositionById(id);
    }

    @RequestMapping(value="/shop/positions/", method = RequestMethod.GET, produces = "application/json")
    List<Position> getAllPositions(){
       return positionsRepository.getAllPositions();
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.POST)
    ResponseEntity<Position> addNewPosition(@RequestBody Position pos){

        if(positionsRepository.Add(pos))
        return new ResponseEntity<Position>(pos, HttpStatus.OK);
        return new ResponseEntity<Position>(pos, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/positions/{id}", method = RequestMethod.PUT)
    ResponseEntity<Position> updatePositionById(@PathVariable int id, @RequestBody Position pos){
        if(positionsRepository.Update(id, pos))
            return new ResponseEntity<Position>(pos, HttpStatus.OK);
        return new ResponseEntity<Position>(pos, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/positions/{id}", method = RequestMethod.DELETE)
    HttpStatus deletePositionById(@PathVariable int id){

        positionsRepository.DeleteById(id);
        return HttpStatus.OK;
    }
    @RequestMapping(value="/shop/positions/{name}", method = RequestMethod.DELETE, produces = "application/json")
    boolean deletePositionByName(@PathVariable String name){
        positionsRepository.DeleteByName(name);
        return true;
    }
}
