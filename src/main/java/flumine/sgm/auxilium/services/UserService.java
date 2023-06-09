package flumine.sgm.auxilium.services;


import flumine.sgm.auxilium.exceptions.ResourceAlreadyExistException;
import flumine.sgm.auxilium.exceptions.ResourceNotFoundException;
import flumine.sgm.auxilium.models.UserModel;
import flumine.sgm.auxilium.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public void existByUsername (String username)
    {
        if (userRepository.existsByUsernameIgnoreCase(username))
            throw new ResourceAlreadyExistException(String.format("User with username '%s' already exist", username));
    }

    public void existByEmail (String email)
    {
        if (userRepository.existsByEmailIgnoreCase(email))
            throw new ResourceAlreadyExistException(String.format("User with email '%s' already exist", email));
    }

    public void checkExistUser(String username, String email)
    {
        UserModel user = userRepository.findByUsernameIgnoreCase(username).orElse(null);
        if (user != null && user.getEnabled()) throw new ResourceAlreadyExistException("Username already exist");
        user = userRepository.findByEmailIgnoreCase(email).orElse(null);
        if (user != null && user.getEnabled()) throw new ResourceAlreadyExistException("Email already exist");
    }

    public UserModel loadByUsernameOrEmail(String user) {
        return userRepository.findByEmailIgnoreCaseOrUsernameIgnoreCase(user, user).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserModel loadByUsernameAndEmail(String username, String email) {
        UserModel user1 = userRepository.findByUsernameIgnoreCase(username).orElse(null);
        UserModel user2 = userRepository.findByEmailIgnoreCase(email).orElse(null);
        if (user1 != null) return user1;
        if (user2 != null) return user2;
        return new UserModel();
    }

    public UserModel loadByUsername(String user) {
        return userRepository.findByUsernameIgnoreCase(user).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserModel loadByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
