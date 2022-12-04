package com.ryan.spring_boot_rest_api.repository;

import com.ryan.spring_boot_rest_api.domain.User;

import java.util.Collection;

public interface UserRepositoryInterface {
    int save(int id, String name);
    User findByUser(int id);
    Collection<User> findAllByUser();
    User update(int id, String name);
    Boolean delete(int id);
}
