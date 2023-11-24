package com.example.prabha.itemserver.service;

import com.example.prabha.itemserver.dto.SuperDto;
import com.example.prabha.itemserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService  <T extends SuperDto, ID>{
    ResponseEntity<Response> save(T t);
    ResponseEntity<Response> search(String id);
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
