package flumine.sgm.auxilium.auth;


import flumine.sgm.auxilium.services.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    @Value("${redirect_url}")
    private String redirect;

    private final AuthenticationService service;

//    @GetMapping("/")
//    public ResponseEntity<?> index() {
//        return ResponseEntity.ok("Its work");
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody @Valid RegisterRequest request
    ) throws MessagingException {
        service.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ) {
        String token = service.authenticate(request);
        Cookie cookies = service.get_cookies(token);
        response.addCookie(cookies);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/confirm_email")
    public void confirm_email (
            @RequestParam String token, HttpServletResponse response) throws IOException {

        String user_token = service.confirm_email(token);
        Cookie cookies = service.get_cookies(user_token);
        response.addCookie(cookies);





        response.sendRedirect(redirect);
    }





}

