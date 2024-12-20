package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPhonesVO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
