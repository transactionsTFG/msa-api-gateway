package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import msa.commons.controller.airline.reservation.create.ReservationRequestDTO;
import services.airline.AirlineServices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationAirlineController {
    private static final Logger LOGGER = LogManager.getLogger(ReservationAirlineController.class);
    private AirlineServices airlineServices;

    @POST
    public Response createReservation(ReservationRequestDTO dto) {
        LOGGER.info("Iniciando reserva con el dto: {}", dto);
        boolean success = this.airlineServices.createReservation(dto);
        if (success)
            return Response.status(Response.Status.CREATED).entity("Reserva iniciada con exito").build();

        return Response.status(Response.Status.BAD_REQUEST).entity("No se ha podido hacer la reserva").build();
    }

    @Inject
    public void setAirlineServices(AirlineServices airlineServices) {
        this.airlineServices = airlineServices;
    }
}
