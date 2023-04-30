package com.ryan.spring_boot_rest_api.service;

import com.ryan.spring_boot_rest_api.domain.User;
import com.ryan.spring_boot_rest_api.dto.CreatUserDto;
import com.ryan.spring_boot_rest_api.dto.SuccessResponse;
import com.ryan.spring_boot_rest_api.dto.UpdateUserDto;
import com.ryan.spring_boot_rest_api.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public UserService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
        System.out.println("주입된 구현체 조회 -> " +  userRepositoryInterface.getClass());
    }

//    @Autowired
//    public UserService(@Qualifier("memoryRepository") UserRepositoryInterface userRepositoryInterface) {
//        this.userRepositoryInterface = userRepositoryInterface;
//    }



    /**
     * @author Ryan
     * @description 유저 생성 컨트롤러
     *
     * @path /user/create
     *
     * @return User Id
     */
    public SuccessResponse onCreateUser(CreatUserDto creatUserDto){

        int id = creatUserDto.getId();
        String name = creatUserDto.getName();

        int userId = this.userRepositoryInterface.save(id, name);

        return new SuccessResponse(true, userId);
    }


    /**
     * @author Ryan
     * @description 전체 유저 조회
     *
     * @path /user/list
     *
     * @return User[]
     */
    public SuccessResponse getUserList(){
        List<User> userList = new ArrayList<>(this.userRepositoryInterface.findAllByUser());
        return new SuccessResponse(true, userList);
    }

    /**
     * @author Ryan
     * @description 단일 유저 조회
     *
     * @path /user/:id
     *
     * @return User
     */
    public SuccessResponse getUser(int id){
        User byUser = this.userRepositoryInterface.findByUser(id);

        return new SuccessResponse(true, byUser);
    }

    /**
     * @author Ryan
     * @description 유저 정보 수정
     *
     * @path /update
     *
     * @return User Id
     */
    public SuccessResponse updateUser(UpdateUserDto updateUserDto){

        int id = updateUserDto.getId();
        String name = updateUserDto.getName();

        User user = this.userRepositoryInterface.update(id, name);

        return new SuccessResponse(true, user);
    }


    /**
     * @author Ryan
     * @description 특정 유저 삭제
     *
     * @path /delete
     *
     * @return Boolean
     */
    public SuccessResponse deleteUser(int id){

        Boolean success = this.userRepositoryInterface.delete(id);

        return new SuccessResponse(success, null);
    }
}
