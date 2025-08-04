package apiclient.agency.users;

import javax.ws.rs.core.Response;

import business.user.CreateUserDTO;

public interface UserApiClient {
    Response getUser(String email, String password);
    Response createUser(CreateUserDTO dto);
}
