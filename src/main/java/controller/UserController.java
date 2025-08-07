package controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.users.UserApiClient;
import business.user.CreateUserDTO;
import business.user.LoginUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/user")
@Tag(name = "User", description = "Operaciones de usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    private UserApiClient api;

    @POST
    @Path("/{id}")
    @Operation(
        summary = "Obtener usuario por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "No encontrado")
        }
    )
    public Response getUserById(LoginUserDTO dto) {
        LOGGER.info("Fetching user information for email: {}", dto.getEmail());
        return api.getUser(dto.getEmail(), dto.getPassword());
    }

    @POST
    @Path("/create")
    @Operation(summary = "Crear usuario", responses = {
        @ApiResponse(responseCode = "201", description = "Creado")
    })
    public Response createUser(CreateUserDTO dto) {
        LOGGER.info("Creating user: {}", dto);
        return api.createUser(dto);
    }

    @EJB
    public void setApi(UserApiClient api) {
        this.api = api;
    }
}
