package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import business.CreateAirlineAndHotelReservationDTO;
import services.airline.AirlineServices;
import services.hotel.HotelServices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gateway")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GatewayController {
    private static final Logger LOGGER = LogManager.getLogger(GatewayController.class);
    // private AirlineServices airlineServices;
    // private HotelServices hotelServices;

    // @Inject
    // public void setAirlineServices(AirlineServices airlineServices) {
    //     this.airlineServices = airlineServices;
    // }

    // @Inject
    // public void setHotelServices(HotelServices hotelServices) {
    //     this.hotelServices = hotelServices;
    // }

    @POST
    @Path("/create")
    public Response createAirlineAndHotelReservation(CreateAirlineAndHotelReservationDTO dto) {
        LOGGER.info("Iniciando reserva de vuelo y hotel: {}", dto);
        // boolean success = this.airlineServices.createReservation(dto.getReservation())
        //         && this.hotelServices.createBooking(dto.getBooking());
        // if (success)
        //     return Response.status(Response.Status.CREATED).entity("Reserva iniciada con exito").build();

        return Response.status(Response.Status.BAD_REQUEST).entity("No se ha podido hacer la reserva").build();
    }
}
