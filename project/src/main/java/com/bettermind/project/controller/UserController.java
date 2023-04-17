package com.bettermind.project.controller;

        import com.bettermind.project.dto.ResponceDTO;
        import com.bettermind.project.dto.UserDto;
        import com.bettermind.project.service.UserService;
        import com.bettermind.project.util.VarList;
        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResponceDTO responceDTO;

    @PostMapping(value = "/saveUser")
    public ResponseEntity saveUser(@RequestBody UserDto userDto){
        try{
            String res=userService.saveUser(userDto);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(userDto);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("06")){
                responceDTO.setCode(VarList.RSP_DUPLICATED);
                responceDTO.setMessage("User Registered");
                responceDTO.setContent(userDto);
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

    @PutMapping(value = "/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDto userDto){
        try{
            String res=userService.updateUser(userDto);
            if(res.equals("00")){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(userDto);
                return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responceDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responceDTO.setMessage("Not a registered user");
                responceDTO.setContent(userDto);
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
    @GetMapping("/getAllUser")
    public ResponseEntity getAllUser() {
        try{
            List<UserDto> userDtoList = userService.getAllUser();
            responceDTO.setCode(VarList.RSP_SUCCESS);
            responceDTO.setMessage("Success");
            responceDTO.setContent(userDtoList);
            return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            responceDTO.setCode(VarList.RSP_ERROR);
            responceDTO.setMessage(ex.getMessage());
            responceDTO.setContent(null);
            return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchUser/{id}")
    public ResponseEntity searchUser(@PathVariable int id) {
        try{
            UserDto userDto = userService.searchUser(id);
            if(userDto != null){
                responceDTO.setCode(VarList.RSP_SUCCESS);
                responceDTO.setMessage("Success");
                responceDTO.setContent(userDto);
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
    @DeleteMapping ("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try{
            String res = userService.deleteUser(id);
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
