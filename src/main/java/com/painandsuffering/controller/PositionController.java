package com.painandsuffering.controller;


        import com.fasterxml.jackson.annotation.JsonView;
        import com.painandsuffering.model.Position;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import com.painandsuffering.service.ShopService;
        import com.painandsuffering.dao.*;
        import java.util.List;
        import com.painandsuffering.controller.Views;
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
    @JsonView(Views.Public.class)
    @RequestMapping(value="/shop/positions/", method = RequestMethod.GET, produces = "application/json")
    List<Position> getAllPositions(){
       return positionsRepository.getAllPositions();
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.POST)
    ResponseEntity<Position> addNewPosition(@RequestBody Position pos){
        positionsRepository.Add(pos);
        return new ResponseEntity<Position>(pos, HttpStatus.OK);
    }
}
