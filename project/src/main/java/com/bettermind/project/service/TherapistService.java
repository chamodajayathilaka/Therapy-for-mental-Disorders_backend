package com.bettermind.project.service;

import com.bettermind.project.dto.TherapistDTO;
import com.bettermind.project.entity.Therapist;
import com.bettermind.project.reposity.TherapistRepo;
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
public class TherapistService {
    @Autowired
    private TherapistRepo therapistRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveTherapist(TherapistDTO therapistDto){
        if(therapistRepo.existsById(therapistDto.getIdTherapist())){
            return VarList.RSP_DUPLICATED;
        }else{
            therapistRepo.save(modelMapper.map(therapistDto, Therapist.class ));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateTherapist(TherapistDTO therapistDto){
        if(therapistRepo.existsById(therapistDto.getIdTherapist())){
            therapistRepo.save(modelMapper.map(therapistDto, Therapist.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<TherapistDTO> getAllUser(){
        List<Therapist> therapistList = therapistRepo.findAll();
        return modelMapper.map(therapistList,new TypeToken<ArrayList<TherapistDTO>>(){
        }.getType());
    }
    public TherapistDTO searchTherapist(int idTherapist){
        if (therapistRepo.existsById(idTherapist)) {
            Therapist therapist = therapistRepo.findById(idTherapist).orElse(null);
            return modelMapper.map(therapist, TherapistDTO.class);
        }else{
            return null;
        }
    }
    public String deleteTherapist(int idTherapist){
        if(therapistRepo.existsById(idTherapist)){
            therapistRepo.deleteById(idTherapist);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
