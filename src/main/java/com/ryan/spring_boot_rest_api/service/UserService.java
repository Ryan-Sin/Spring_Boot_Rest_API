package com.ryan.spring_boot_rest_api.service;

import com.ryan.spring_boot_rest_api.domain.User;
import com.ryan.spring_boot_rest_api.dto.CreatUserDto;
import com.ryan.spring_boot_rest_api.dto.SuccessResponse;
import com.ryan.spring_boot_rest_api.dto.UpdateUserDto;
import com.ryan.spring_boot_rest_api.repository.UserDiskRepository;
import com.ryan.spring_boot_rest_api.repository.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryInterface userRepository;

    @Autowired
    private final UserDiskRepository userDiskRepository;


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

        int userId = this.userDiskRepository.save(id, name);

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
        List<User> userList = new ArrayList<>(this.userDiskRepository.findAllByUser());
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
        User byUser = this.userDiskRepository.findByUser(id);

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

        User user = this.userDiskRepository.update(id, name);

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

        Boolean success = this.userDiskRepository.delete(id);

        return new SuccessResponse(success, null);
    }
}
