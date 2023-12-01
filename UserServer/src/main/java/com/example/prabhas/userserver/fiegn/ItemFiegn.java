package com.example.prabhas.userserver.fiegn;

import com.example.prabhas.userserver.dto.UserDto;
import com.example.prabhas.userserver.res.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("item-service")
public interface ItemFiegn {
    @GetMapping(path = "api/v1/item/test")
    public String getItem();

    @GetMapping(path="api/v1/item/CusfromTSave")
    public String fromCus_Item();


    @PostMapping(path = "api/v1/item/saveCusITM", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public   UserDto saveItemFromCus(@RequestBody UserDto userDto);

}
