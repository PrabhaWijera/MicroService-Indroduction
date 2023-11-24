package com.example.prabha.itemserver.service;

import com.example.prabha.itemserver.dao.ItemRepo;
import com.example.prabha.itemserver.dto.ItemDto;
import com.example.prabha.itemserver.entity.ItemEntitys;
import com.example.prabha.itemserver.res.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceimpl implements ItemService{
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;
    @Override
    public ResponseEntity<Response> save(ItemDto itemDto) {
        if (search(itemDto.getId()).getBody().getData()==null){
            itemRepo.save(modelMapper.map(itemDto, ItemEntitys.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save ");
    }

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<ItemEntitys> userEntity=itemRepo.findById(id);
        if (userEntity.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(),"Success service",modelMapper.map(userEntity.get(),ItemDto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), " NOT Found Error",null);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(statusCode));
    }
}
