package com.ryan.spring_boot_rest_api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    public int id; // 유저 아이디
    public String name; // 유저 이름
}