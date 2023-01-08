package com.example.AppRestaurant.controller;

import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.ControllerEXcption;
import com.example.AppRestaurant.facade.MenuFdcInterface;
import com.example.AppRestaurant.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class MenuController {
@Autowired
private MenuFdcInterface fcd;

    @PostMapping("/menu/all")
    public ResponseEntity<Message> selectall()throws ControllerEXcption {
        Message message=new Message("0","TRUE", null);
        try{
            List<MenuDto> list= fcd.selectall();
            message.setData(list);
        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
    @GetMapping("/ingrediente/menu/{i}")
    public ResponseEntity<Message> delete(@PathVariable int i) throws ControllerEXcption{
        Message message=new Message("0","TRUE", null);
        try{
            fcd.delete(i);

        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
    @PostMapping("/menu/save")
    public ResponseEntity<Message> save(@RequestBody MenuDto M) throws ControllerEXcption{
        Message message=new Message("0","TRUE", null);
        try{
            fcd.save(M);

        }catch (Exception Ex){
            throw new ControllerEXcption(Ex);
        }
        return ResponseEntity.ok(message);
    }
}
