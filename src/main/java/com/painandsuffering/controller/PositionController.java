package com.painandsuffering.controller;


        import com.painandsuffering.model.Product;
        import com.painandsuffering.model.Product;
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
    private PositionDAO positionsRepository;


    private
    @RequestMapping(value="/shop/positions/{id}", method = RequestMethod.GET , produces = "application/json")
    Product getPositionById(@PathVariable int id) {
        return positionsRepository.getPositionById(id);
    }

    @RequestMapping(value="/shop/positions/", method = RequestMethod.GET, produces = "application/json")
    List<Product> getAllPositions(){
       return positionsRepository.getAllPositions();
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.POST)
    ResponseEntity<Product> addNewPosition(@RequestBody Product pos){

        if(positionsRepository.createPosition(pos))
        return new ResponseEntity<Product>(pos, HttpStatus.OK);
        return new ResponseEntity<Product>(pos, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/positions/", method = RequestMethod.PUT)
    ResponseEntity<Product> updatePositionById(@RequestBody Product pos){
        if(positionsRepository.updatePosition(pos))
            return new ResponseEntity<Product>(pos, HttpStatus.OK);
        return new ResponseEntity<Product>(pos, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/positions/{id}", method = RequestMethod.DELETE)
    HttpStatus deletePositionById(@PathVariable int id){
        positionsRepository.deletePosition(id);
        return HttpStatus.OK;
    }

}
