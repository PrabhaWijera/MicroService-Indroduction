package com.example.prabha.itemserver.controller;

import com.example.prabha.itemserver.dto.ItemDto;
import com.example.prabha.itemserver.res.Response;
import com.example.prabha.itemserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping(path = "/Usersave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveGuide(@RequestBody ItemDto itemDto){
        System.out.println("Item save controller"+itemDto.toString());
        return itemService.save(itemDto);

    }
}