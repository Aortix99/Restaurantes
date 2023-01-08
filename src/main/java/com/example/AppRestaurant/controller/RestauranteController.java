package com.example.AppRestaurant.controller;

import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.ControllerEXcption;
import com.example.AppRestaurant.facade.RestauranteFcdInterface;
import com.example.AppRestaurant.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestauranteController {
    @Autowired
    private RestauranteFcdInterface Fcd;

    @PostMapping("/restaurante/all")
    public ResponseEntity<Message> selectall()throws ControllerEXcption {
        Message message=new Message("0","TRUE", null);
        try{
            List<RestauranteDto> list= Fcd.selectall();
            message.setData(list);
        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
    @GetMapping("/restaurante/delete/{i}")
    public ResponseEntity<Message> delete(@PathVariable int i) throws ControllerEXcption{
        Message message=new Message("0","TRUE", null);
        try{
            Fcd.delete(i);

        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
    @PostMapping("/restaurante/save")
    public ResponseEntity<Message> save(@RequestBody RestauranteDto R) throws ControllerEXcption{
        Message message=new Message("0","TRUE", null);
        try{
            Fcd.save(R);

        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
}
