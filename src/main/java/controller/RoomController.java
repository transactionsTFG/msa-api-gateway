package controller;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.hotel.RoomApiClient;

@Path("/room")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomController {
    private static final Logger LOGGER = LogManager.getLogger(RoomController.class);
    private RoomApiClient roomApiClient;

    @GET
    @Path("/{id}")
    public Response getRoomById(@PathParam("id") long id) {
        LOGGER.info("Fetching room information for ID: {}", id);
        return roomApiClient.getRoomById(id);
    }

    @GET
    @Path("/params")
    public Response getRoomByCountryAndNameHotel(@QueryParam("country") String country, @QueryParam("nameHotel") String nameHotel) {
        LOGGER.info("Fetching room information for country: {}, hotel name: {}", country, nameHotel);
        return roomApiClient.getRoomByCountryAndNameHotel(country, nameHotel);
    }   

    @EJB
    public void setRoomApiClient(RoomApiClient roomApiClient) {
        this.roomApiClient = roomApiClient;
    }
}
