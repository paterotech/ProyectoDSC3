package edu.udea.main.servicios;

import edu.udea.main.entidades.User;
import edu.udea.main.repositorios.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceUser {

    private UserRepo userRepo;

    public ServiceUser(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User crearUser(User newUser){
        return this.userRepo.save(newUser);
    }


    public User findUserByEmail(String email){
        return this.userRepo.findByEmail(email);
    }

    public User obtenerOCrearUser(Map<String, Object> dataUser){
        String email = (String) dataUser.get("email");

        User user = findUserByEmail(email);
        if(user==null){
            String nickname = (String) dataUser.get("nickname");
            String image = (String) dataUser.get("picture");
            String auth0Id = (String) dataUser.get("sub");

            User newUser = new User(nickname=nickname,email=email,image=image,auth0Id=auth0Id);
            return crearUser(newUser);
        }
        return user;
    }

}
