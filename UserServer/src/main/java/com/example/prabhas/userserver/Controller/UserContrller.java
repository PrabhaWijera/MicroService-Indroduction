package com.example.prabhas.userserver.Controller;


import com.example.prabhas.userserver.dto.UserDto;
import com.example.prabhas.userserver.fiegn.ItemFiegn;
import com.example.prabhas.userserver.res.Response;
import com.example.prabhas.userserver.services.UserService;
import jakarta.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("api/v1/user")
public class UserContrller {

    @Autowired
    private UserService userService;
        @Autowired
    private ItemFiegn itemFiegn;

        @Autowired
        private RestTemplate restTemplate;
    @PostMapping(path = "/Usersave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveGuide(@RequestBody UserDto userDto){
        System.out.println("User save controller"+userDto.toString());
        return userService.save(userDto);

    }
    @GetMapping(path = "/test")
    public String getItem(){
        return itemFiegn.getItem();
    }

    @GetMapping(path = "/saveIT")
    public String get_Items(){
        return restTemplate.getForObject("http://localhost:8082/api/api/v1/item/saveIT",String.class);
    }

    @GetMapping(path="/CusfromTSave")
    public String fromCus_Item(){
        return itemFiegn.fromCus_Item();
    }

    @PostMapping(path = "/saveCusITM", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto saveItemFromCus(@RequestBody UserDto userDto){
        return itemFiegn.saveItemFromCus(userDto);
    }


}
