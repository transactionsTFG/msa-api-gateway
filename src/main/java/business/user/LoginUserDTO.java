package business.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "LoginUserDTO", description = "Credenciales de acceso del usuario")
public class LoginUserDTO {
    @Schema(description = "Correo electrónico del usuario", example = "user@example.com")
    private String email;
    @Schema(description = "Contraseña del usuario", example = "password123")
    private String password;
}
