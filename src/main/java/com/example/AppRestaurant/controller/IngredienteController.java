package com.example.AppRestaurant.controller;

import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.ControllerEXcption;
import com.example.AppRestaurant.facade.IngredienteFcdInterface;
import com.example.AppRestaurant.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredienteController {
@Autowired
    private IngredienteFcdInterface Fcd;

@PostMapping("/ingrediente/all")
public ResponseEntity<Message> selectall()throws ControllerEXcption{
Message message=new Message("0","TRUE", null);
try{
    List<IngredienteDto> list= Fcd.selectall();
    message.setData(list);
}catch (Exception Ex){
    throw new ControllerEXcption(Ex);
}
return ResponseEntity.ok(message);
}
    @GetMapping("/ingrediente/delete/{i}")
public ResponseEntity<Message> delete(@PathVariable int i) throws ControllerEXcption{
    Message message=new Message("0","TRUE", null);
    try{
     Fcd.delete(i);

    }catch (Exception Ex){
        throw new ControllerEXcption(Ex);
    }
    return ResponseEntity.ok(message);
}
    @PostMapping("/ingrediente/save")
    public ResponseEntity<Message> save(@RequestBody IngredienteDto I) throws ControllerEXcption{
        Message message=new Message("0","TRUE", null);
        try{
            Fcd.save(I);

        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }

}
