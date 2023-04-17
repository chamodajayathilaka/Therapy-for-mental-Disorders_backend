package com.bettermind.project.service;


import com.bettermind.project.dto.TreatmentDTO;
import com.bettermind.project.entity.Treatment;
import com.bettermind.project.reposity.TreatmentRepo;
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
public class TreatmentService {
    @Autowired
    private TreatmentRepo treatmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveTreatment(TreatmentDTO treatmentDTO){
        if(treatmentRepo.existsById(treatmentDTO.getId_treatment())){
            return VarList.RSP_DUPLICATED;
        }else{
            treatmentRepo.save(modelMapper.map(treatmentDTO, Treatment.class ));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateTreatment(TreatmentDTO treatmentDTO){
        if(treatmentRepo.existsById(treatmentDTO.getId_treatment())){
            treatmentRepo.save(modelMapper.map(treatmentDTO, Treatment.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<TreatmentDTO> getAllTreatment(){
        List<Treatment> treatmentList = treatmentRepo.findAll();
        return modelMapper.map(treatmentList,new TypeToken<ArrayList<TreatmentDTO>>(){
        }.getType());
    }
    public TreatmentDTO searchTreatment(int idTreatment){
        if (treatmentRepo.existsById(idTreatment)) {
            Treatment treatment = treatmentRepo.findById(idTreatment).orElse(null);
            return modelMapper.map(treatment, TreatmentDTO.class);
        }else{
            return null;
        }
    }
    public String deleteTreatment(int idTreatment){
        if(treatmentRepo.existsById(idTreatment)){
            treatmentRepo.deleteById(idTreatment);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
