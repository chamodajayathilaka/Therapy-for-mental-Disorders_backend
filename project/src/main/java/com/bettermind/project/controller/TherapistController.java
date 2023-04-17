package com.bettermind.project.controller;


import com.bettermind.project.dto.ResponceDTO;
import com.bettermind.project.dto.TherapistDTO;
import com.bettermind.project.service.TherapistService;
import com.bettermind.project.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/therapist")
@CrossOrigin
public class TherapistController {
    @Autowired
    private TherapistService therapistService;

    @Autowired
    private ResponceDTO responceDTO;


    @PostMapping(value = "/saveTherapist")
    public ResponseEntity saveTherapist(@RequestBody TherapistDTO therapistDTO){
        try{
            String res=therapistService.saveTherapist(therapistDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(therapistDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("06")){
                responceDTO.setCode(VarList.RSP_DUPLICATED);
                responceDTO.setMessage("Therapist Registered");
                responceDTO.setContent(therapistDTO);
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

    @PutMapping(value = "/updateTherapist")
    public ResponseEntity updateTherapist(@RequestBody TherapistDTO therapistDTO){
        try{
            String res=therapistService.updateTherapist(therapistDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(therapistDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("Not a registered user");
                responceDTO.setContent(therapistDTO);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            }else{
                responceDTO.setCode(VarList.RSP_FAIL);
                responceDTO.setMessage("Error");
                responceDTO.setContent(null);
                return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
            
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllTherapist")
    public ResponseEntity getAllTherapist() {
        try{
            List<TherapistDTO> therapistDTOList = therapistService.getAllUser();
            responceDTO.setCode(VarList.RSP_SUCCESS);
            responceDTO.setMessage("Success");
            responceDTO.setContent(therapistDTOList);
            return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchTherapist/{idTherapist}")
    public ResponseEntity searchTherapist(@PathVariable int idTherapist) {
        try{
            TherapistDTO therapistDTO = therapistService.searchTherapist(idTherapist);
            if(therapistDTO != null){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(therapistDTO);
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
    @DeleteMapping ("/deleteTherapist/{idTherapist}")
    public ResponseEntity deleteTherapist(@PathVariable int idTherapist) {
        try{
            String res = therapistService.deleteTherapist(idTherapist);
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
