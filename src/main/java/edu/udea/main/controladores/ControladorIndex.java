package edu.udea.main.controladores;

import edu.udea.main.entidades.User;
import edu.udea.main.servicios.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndex {

    @Autowired
    ServiceUser serviceUser;


    @GetMapping("/base")
    public String base() {
        return "base";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/bienvenida")
    public String bienvenida(){
        return "bienvenida";
    }

    @GetMapping("/")
    public String bienvenida(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            User user = this.serviceUser.obtenerOCrearUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "bienvenida";
    }

}
