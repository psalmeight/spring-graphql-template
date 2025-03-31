package co.accessthreads.gobeyond.auth;

import co.accessthreads.gobeyond.config.CustomAuthenticationProvider;
import co.accessthreads.gobeyond.config.JwtUtil;
import co.accessthreads.gobeyond.user.User;
import co.accessthreads.gobeyond.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    String login(@RequestBody User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword(), new ArrayList<>()
                )
        );
        return jwtUtil.generateToken(user.getUsername());
    }
}