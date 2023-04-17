package com.bettermind.project.controller;

import com.bettermind.project.dto.ResponceDTO;
import com.bettermind.project.dto.TestDTO;
import com.bettermind.project.service.TestService;
import com.bettermind.project.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private ResponceDTO responceDTO;


    @PostMapping(value = "/saveTest")
    public ResponseEntity saveTest(@RequestBody TestDTO testDTO){
        try{
            String res=testService.saveTest(testDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(testDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("06")){
                responceDTO.setCode(VarList.RSP_DUPLICATED);
                responceDTO.setMessage("Test Registered");
                responceDTO.setContent(testDTO);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }else{
                responceDTO.setCode(VarList.RSP_FAIL);
                responceDTO.setMessage("Error");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping(value = "/updateTest")
    public ResponseEntity updateTest(@RequestBody TestDTO testDTO){
        try{
            String res=testService.updateTest(testDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(testDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("Not a registered user");
                responceDTO.setContent(testDTO);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }else{
                responceDTO.setCode(VarList.RSP_FAIL);
                responceDTO.setMessage("Error");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllTest")
    public ResponseEntity getAllTest() {
        try{
            List<TestDTO> testDTOList = testService.getAllTest();
            responceDTO.setCode(VarList.RSP_SUCCESS);
            responceDTO.setMessage("Success");
            responceDTO.setContent(testDTOList);
            return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchTest/{idTest}")
    public ResponseEntity searchTest(@PathVariable int idTest) {
        try{
            TestDTO testDTO = testService.searchTest(idTest);
            if(testDTO != null){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(testDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else{
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("No user in this id");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(ex);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping ("/deleteTest/{idTest}")
    public ResponseEntity deleteTest(@PathVariable int idTest) {
        try{
            String res = testService.deleteTest(idTest);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else{
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("No user in this id");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(ex);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
