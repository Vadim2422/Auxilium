package flumine.sgm.auxilium.services;

import flumine.sgm.auxilium.auth.AuthenticationRequest;
import flumine.sgm.auxilium.auth.AuthenticationResponse;
import flumine.sgm.auxilium.auth.RegisterRequest;
import flumine.sgm.auxilium.exceptions.BadTokenException;
import flumine.sgm.auxilium.exceptions.ResourceNotFoundException;
import flumine.sgm.auxilium.models.UserModel;
import flumine.sgm.auxilium.models.VerificationToken;
import flumine.sgm.auxilium.repositories.UserRepository;
import flumine.sgm.auxilium.repositories.VerificationTokenRepository;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    private final VerificationTokenRepository verificationTokenRepository;

    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmationService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String authenticate(@Valid AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        var user = userService.loadByUsernameOrEmail(request.getLogin());
        return create_token(user);
    }

    public String create_token(UserModel user)
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("token_type", "Bearer");
        return jwtService.generateUserToken(claims, user);
    }

    public String get_token_from_request(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");
        if (token == null)  throw new BadTokenException("Bad token");
        return request.getHeader("Authorization").replace("Bearer ", "");
    }

    public UserModel get_user_from_request(HttpServletRequest request)
    {
        String token = get_token_from_request(request);
        String username = jwtService.extractUsername(token);
        return userService.loadByUsername(username);
    }

    public void register(RegisterRequest request) throws MessagingException {



        userService.checkExistUser(request.getUsername(), request.getEmail());
        UserModel user = userService.loadByUsernameAndEmail(request.getUsername(), request.getEmail());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        emailService.sendEmail(request.getEmail(), user);
    }


    public String confirm_email(String token) {

        VerificationToken verificationToken = verificationTokenRepository.findByToken(token).orElseThrow(() -> new BadTokenException("Bad token"));
        UserModel user = userRepository.findById(verificationToken.getUser_id()).orElseThrow(() -> {
            throw new ResourceNotFoundException("User not found");
        });
        user.setEnabled(Boolean.TRUE);
        userRepository.save(user);
        verificationTokenRepository.delete(verificationToken);
        return create_token(user);
    }

    public Cookie get_cookies(String token) {
        Cookie userTokenCookie = new Cookie("user_token", token);
        userTokenCookie.setMaxAge(15 * 60 * 1000);
        userTokenCookie.setHttpOnly(true);
        userTokenCookie.setSecure(true);
        return userTokenCookie;
    }

}

