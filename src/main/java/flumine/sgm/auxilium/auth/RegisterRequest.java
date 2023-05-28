package flumine.sgm.auxilium.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "username should not be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$", message = "username can contain letters, numbers and underscores, length [3, 16]")
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
