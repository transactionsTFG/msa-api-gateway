package controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.users.UserApiClient;
import business.user.CreateUserDTO;
import business.user.LoginUserDTO;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    private UserApiClient api;

    @POST
    @Path("/{id}")
    public Response getUserById(LoginUserDTO dto) {
        LOGGER.info("Fetching user information for email: {}", dto.getEmail());
        return api.getUser(dto.getEmail(), dto.getPassword());
    }

    @POST
    @Path("/create")
    public Response createUser(CreateUserDTO dto) {
        LOGGER.info("Creating user: {}", dto);
        return api.createUser(dto);
    }

    @EJB
    public void setApi(UserApiClient api) {
        this.api = api;
    }
}
