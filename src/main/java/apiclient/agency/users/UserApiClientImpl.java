package apiclient.agency.users;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.user.CreateUserDTO;
import business.user.LoginUserDTO;
import consts.HttpsConsts;

@Stateless
public class UserApiClientImpl implements UserApiClient {
    private static final String PATH = HttpsConsts.URL_AGENCY  + "/msa-user/api/users";
    private Client client;

    @Override
    public Response getUser(String email, String password) {
        return this.client
                .target(PATH + "/login")
                .request()
                .post(Entity.entity(new LoginUserDTO(email, password), MediaType.APPLICATION_JSON));
    }

    @Override
    public Response createUser(CreateUserDTO dto) {
        return this.client.target(PATH)
                .request()
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));
    }
    
    @Inject
    public void setClient(Client client) {
        this.client = client;
    }
}
