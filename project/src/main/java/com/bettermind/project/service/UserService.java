package com.bettermind.project.service;

import com.bettermind.project.dto.UserDto;
import com.bettermind.project.entity.User;
import com.bettermind.project.reposity.UserRepo;
import com.bettermind.project.util.VarList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class  UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveUser(UserDto userDto){
        if(userRepo.existsById(userDto.getId())){
           return VarList.RSP_DUPLICATED;
        }else{
            userRepo.save(modelMapper.map(userDto, User.class ));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateUser(UserDto userDto){
        if(userRepo.existsById(userDto.getId())){
            userRepo.save(modelMapper.map(userDto, User.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<UserDto> getAllUser(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<UserDto>>(){
        }.getType());
    }
    public UserDto searchUser(int id){
        if (userRepo.existsById(id)) {
            User user = userRepo.findById(id).orElse(null);
            return modelMapper.map(user, UserDto.class);
        }else{
            return null;
        }
    }
    public String deleteUser(int id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
