package com.example.prabha.itemserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable,SuperDto{
    private String id;
    private String name;
}
