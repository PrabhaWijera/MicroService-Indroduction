package com.example.prabhas.userserver.Controller;


import com.example.prabhas.userserver.dto.UserDto;
import com.example.prabhas.userserver.res.Response;
import com.example.prabhas.userserver.services.UserService;
import jakarta.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user")
public class UserContrller {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/Usersave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveGuide(@RequestBody UserDto userDto){
        System.out.println("User save controller"+userDto.toString());
        return userService.save(userDto);

    }


}
