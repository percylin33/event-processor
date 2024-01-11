package com.intech.eventprocessor.service.impl;

import com.intech.eventprocessor.pojo.User;
import com.intech.eventprocessor.repository.UserRepositori;
import com.intech.eventprocessor.service.UserService;
import com.intech.eventprocessor.util.FacturaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.intech.eventprocessor.Constantes.Constantes;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositori UserRepositori ;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Registro interno de un usuario {} ", requestMap);
        try{
            if (validateSignUpMap(requestMap)){
                User user = UserRepositori.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)){
                    UserRepositori.save(getUserFromMap(requestMap));
                    return FacturaUtils.getResponseEntity("Usuario Registrado con exito ", HttpStatus.CREATED);
                }else {
                    return FacturaUtils.getResponseEntity("El usuario con ese email ya existe ", HttpStatus.BAD_REQUEST);
                }
            }else {
                return FacturaUtils.getResponseEntity(Constantes.INVALID_DATA,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return FacturaUtils.getResponseEntity(Constantes.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignUpMap(Map<String, String> requestMap){
        if(requestMap.containsKey("nombre") && requestMap.containsKey("numeroDeContacto") && requestMap.containsKey("email") && requestMap.containsKey("password")){
            return true;
        }
        return false;
    }

    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setNombre(requestMap.get("nombre"));
        user.setApellido(requestMap.get("apellido"));
        user.setNickname(requestMap.get("nickname"));
        user.setEdad(requestMap.get("edad"));
        user.setDni(requestMap.get("dni"));
        user.setRol(requestMap.get("rol"));
        user.setPassword(requestMap.get("password"));
        user.setMail(requestMap.get("mail"));
        user.setId_Registro(requestMap.get("id_Registro"));
        return user;
    }
}
