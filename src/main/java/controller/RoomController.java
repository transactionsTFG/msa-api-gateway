package controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.hotel.RoomApiClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/room")
@Tag(name = "Room", description = "Operaciones de habitaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomController {
    private static final Logger LOGGER = LogManager.getLogger(RoomController.class);
    private RoomApiClient roomApiClient;

    @GET
    @Path("/{id}")
    @Operation(
        summary = "Obtener una habitación por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Habitación encontrada"),
            @ApiResponse(responseCode = "404", description = "Habitación no encontrada")
        }
    )
    public Response getRoomById(@Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador de la habitación") @PathParam("id") long id) {
        LOGGER.info("Fetching room information for ID: {}", id);
        return roomApiClient.getRoomById(id);
    }

    @GET
    @Path("/params")
     @Operation(
        summary = "Buscar habitaciones por país y nombre del hotel",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de habitaciones obtenida")
        }
    )
    public Response getRoomByCountryAndNameHotel(
            @Parameter(name = "country", in = ParameterIn.QUERY, description = "País donde se ubica el hotel") @QueryParam("country") String country, 
            @Parameter(name = "nameHotel", in = ParameterIn.QUERY, description = "Nombre del hotel") @QueryParam("nameHotel") String nameHotel) {
        LOGGER.info("Fetching room information for country: {}, hotel name: {}", country, nameHotel);
        return roomApiClient.getRoomByCountryAndNameHotel(country, nameHotel);
    }   

    @EJB
    public void setRoomApiClient(RoomApiClient roomApiClient) {
        this.roomApiClient = roomApiClient;
    }
}
