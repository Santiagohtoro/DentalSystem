package com.example.OdontologiaIntegrador.Seguridad;

import com.example.OdontologiaIntegrador.model.Rol;
import com.example.OdontologiaIntegrador.model.Usuario;
import com.example.OdontologiaIntegrador.service.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadeDatos implements ApplicationRunner {

    private IUsuarioRepository usuarioRepository;

    @Autowired
    public CargadeDatos(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("user");

        usuarioRepository.save(new Usuario("Admin", "Admin", "admin@gmail.com", password, Rol.ADMIN));
        usuarioRepository.save(new Usuario("User", "User1", "user1@gmail.com", password2,Rol.USER));

    }


}
