package com.bettermind.project.service;

import com.bettermind.project.dto.TestDTO;
import com.bettermind.project.entity.Test;
import com.bettermind.project.reposity.TestRepo;
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
public class TestService {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveTest(TestDTO testDTO){
        if(testRepo.existsById(testDTO.getId_test())){
            return VarList.RSP_DUPLICATED;
        }else{
            testRepo.save(modelMapper.map(testDTO, Test.class ));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateTest(TestDTO testDTO){
        if(testRepo.existsById(testDTO.getId_test())){
            testRepo.save(modelMapper.map(testDTO, Test.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<TestDTO> getAllTest(){
        List<Test> testList = testRepo.findAll();
        return modelMapper.map(testList,new TypeToken<ArrayList<TestDTO>>(){
        }.getType());
    }
    public TestDTO searchTest(int idTest){
        if (testRepo.existsById(idTest)) {
            Test test = testRepo.findById(idTest).orElse(null);
            return modelMapper.map(test, TestDTO.class);
        }else{
            return null;
        }
    }
    public String deleteTest(int idTest){
        if(testRepo.existsById(idTest)){
            testRepo.deleteById(idTest);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}

