package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.reservation.ReservationApiClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Path("/reservation")
@Tag(name = "Reservas", description = "Operaciones sobre reservas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationController {
    private static final Logger LOGGER = LogManager.getLogger(ReservationController.class);
    private ReservationApiClient reservationApiClient;


    @GET
    @Path("/{id}")
    @Operation(
        summary = "Obtener reserva por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
        }
    )
    public Response getReservation(@Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador de la reserva") @PathParam("id") long id) {
        LOGGER.info("Fetching reservation with id: {}", id);
        return reservationApiClient.getReservationById(id);
    }

}
