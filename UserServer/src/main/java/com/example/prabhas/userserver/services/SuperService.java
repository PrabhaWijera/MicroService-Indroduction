package com.example.prabhas.userserver.services;

import com.example.prabhas.userserver.dto.SuperDto;
import com.example.prabhas.userserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService  <T extends SuperDto, ID>{

    ResponseEntity<Response> save(T t);
    ResponseEntity<Response> search(String id);
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);

}
