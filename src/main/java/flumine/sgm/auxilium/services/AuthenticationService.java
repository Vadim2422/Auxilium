package flumine.sgm.auxilium.services;

import flumine.sgm.auxilium.auth.AuthenticationRequest;
import flumine.sgm.auxilium.auth.AuthenticationResponse;
import flumine.sgm.auxilium.auth.RegisterRequest;
import flumine.sgm.auxilium.exceptions.BadTokenException;
import flumine.sgm.auxilium.exceptions.ResourceNotFoundException;
import flumine.sgm.auxilium.models.UserModel;
import flumine.sgm.auxilium.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Validated
public class AuthenticationService {
    private final UserService userService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(@Valid AuthenticationRequest request) {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getLogin(),
                            request.getPassword()
                    )
            );

        var user = userService.loadByUsernameOrEmail(request.getLogin());
        return create_tokens(user);
    }

    public AuthenticationResponse create_tokens(UserModel user)
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("token_type", "Bearer");
        String access_token = jwtService.generateAccessToken(claims, user);
        return AuthenticationResponse.builder()

                .access_token(access_token)
                .refresh_token(jwtService.generateRefreshToken(claims, user))
                .expired_in(jwtService.extractExpiration(access_token))
                .build();
    }

    public String get_token_from_request(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");
        if (token == null)  throw new BadTokenException();
        return request.getHeader("Authorization").replace("Bearer ", "");
    }

    public UserModel get_user_from_request(HttpServletRequest request)
    {
        String token = get_token_from_request(request);
        String username = jwtService.extractUsername(token);
        return userService.loadByUsername(username);
    }

    public void register(RegisterRequest request) throws MessagingException {

//        userService.existByEmail(request.getEmail());
//        userService.existByUsername(request.getUsername());

        UserModel user = userService.checkExistUser(request.getUsername(), request.getEmail());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRoles(new HashSet<>() {{add(user_role);}});
        userRepository.save(user);
        emailService.sendEmail(request.getEmail(), request.getUsername(), "http://localhost:80/auth/confirm_email/" + jwtService.generateAccessToken(new HashMap<>(), user));
    }

//    public void set_role(String user, ERole role) {
//        var userModel = userService.loadByUsernameOrEmail(user);
//        Set<RoleModel> roles = userModel.getRoles();
//        RoleModel user_role = roleRepository.findByRole(role).orElse(new RoleModel());
//        roles.add(user_role);
//        userModel.setRoles(roles);
//        userRepository.save(userModel);
//
//    }

    public void confirm_email(String token) {

       String username = jwtService.extractUsername(token);
       UserModel user = userRepository.findByUsernameIgnoreCase(username).orElseThrow(()-> new ResourceNotFoundException("User not found"));
       user.setEnabled(true);
       userRepository.save(user);
    }

}

