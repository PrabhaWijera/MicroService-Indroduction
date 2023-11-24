package com.example.prabhas.userserver.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("item-service")
public interface ItemFiegn {
    @GetMapping(path = "api/v1/item/test")
    public String getItem();

}
