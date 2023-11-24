package com.example.prabhas.userserver.services;

import com.example.prabhas.userserver.dao.UserRepo;
import com.example.prabhas.userserver.dto.SuperDto;
import com.example.prabhas.userserver.dto.UserDto;
import com.example.prabhas.userserver.entity.UserEntity;
import com.example.prabhas.userserver.res.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;


/*    @Override
    public ResponseEntity<Response> save(SuperDto superDto) {
        if (search(userDto.getId()).getBody().getData()==null){
            userRepo.save(modelMapper.map(userDto, UserEntity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save user");
    }*/

    @Override
    public ResponseEntity<Response> save(UserDto userDto) {
        if (search(userDto.getId()).getBody().getData()==null){
            userRepo.save(modelMapper.map(userDto, UserEntity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save user");
    }

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<UserEntity> userEntity=userRepo.findById(id);
        if (userEntity.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(),"Success service",modelMapper.map(userEntity.get(),UserDto.class));
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
