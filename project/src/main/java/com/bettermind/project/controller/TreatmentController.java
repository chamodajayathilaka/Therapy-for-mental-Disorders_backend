package com.bettermind.project.controller;

import com.bettermind.project.dto.ResponceDTO;
import com.bettermind.project.dto.TreatmentDTO;
import com.bettermind.project.service.TreatmentService;
import com.bettermind.project.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/treatment")
@CrossOrigin
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private ResponceDTO responceDTO;


    @PostMapping(value = "/saveTreatment")
    public ResponseEntity saveTreatment(@RequestBody TreatmentDTO treatmentDTO){
        try{
            String res=treatmentService.saveTreatment(treatmentDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(treatmentDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("06")){
                responceDTO.setCode(VarList.RSP_DUPLICATED);
                responceDTO.setMessage("Therapist Registered");
                responceDTO.setContent(treatmentDTO);
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

    @PutMapping(value = "/updateTreatment")
    public ResponseEntity updateTreatment(@RequestBody TreatmentDTO treatmentDTO){
        try{
            String res=treatmentService.updateTreatment(treatmentDTO);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(treatmentDTO);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("Not a registered user");
                responceDTO.setContent(treatmentDTO);
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
    @GetMapping("/getAllTreatment")
    public ResponseEntity getAllTreatment() {
        try{
            List<TreatmentDTO> treatmentDTOList = treatmentService.getAllTreatment();
            responceDTO.setCode(VarList.RSP_SUCCESS);
            responceDTO.setMessage("Success");
            responceDTO.setContent(treatmentDTOList);
            return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchTreatment/{idTreatment}")
    public ResponseEntity searchTreatment(@PathVariable int idTreatment) {
        try{
            TreatmentDTO treatmentDTO = treatmentService.searchTreatment(idTreatment);
            if(treatmentDTO != null){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(treatmentDTO);
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
    @DeleteMapping ("/deleteTreatment/{idTreatment}")
    public ResponseEntity deleteTreatment(@PathVariable int idTreatment) {
        try{
            String res = treatmentService.deleteTreatment(idTreatment);
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
