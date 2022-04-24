package com.ryan.spring_boot_rest_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
    public int id; // 유저 아이디
    public String name; // 유저 이름
}
