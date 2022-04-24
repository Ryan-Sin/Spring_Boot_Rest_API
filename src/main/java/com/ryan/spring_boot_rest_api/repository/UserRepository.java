package com.ryan.spring_boot_rest_api.repository;

import com.ryan.spring_boot_rest_api.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    Map<Integer, User> memoryDB = new ConcurrentHashMap<>();

    /**
     * @author Ryan
     * @description 유저 등록
     *
     * @param id 유저 아이디
     * @param name 유저 이름
     *
     * @return id 유저 아이디
     */
    public int save(int id, String name){

        User user = new User();
        user.setId(id);
        user.setName(name);

        this.memoryDB.put(id, user);

        return id;
    }

    /**
     * @author Ryan
     * @description 단일 유저 조회
     *
     * @return User 유저
     */
    public User findByUser(int id){
        return this.memoryDB.get(id);
    }

    /**
     * @author Ryan
     * @description 유저 정보 전체 조회
     *
     * @return User[] 유저 리스트
     */
    public Collection<User> findAllByUser(){
        return this.memoryDB.values();
    }


    /**
     * @author Ryan
     * @description 유저 수정
     *
     * @return User 유저
     */
    public User update(int id, String name){

        User user = this.memoryDB.get(id);
        user.setName(name);

        return user;
    }


    /**
     * @author Ryan
     * @description 유저 삭제
     *
     * @param id 유저 고유 아이디
     *
     * @return Boolean 성공 여부
     */
    public Boolean delete(int id){

        User user = this.memoryDB.remove(id);

        //삭제 하려는 유저가 없다면 에러 처리
        if(user == null){
            return false;
        }

        return true;
    }

}
