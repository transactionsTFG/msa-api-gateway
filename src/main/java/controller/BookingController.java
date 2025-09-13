package controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.booking.BookingApiClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/booking")
@Tag(name = "Booking", description = "Operaciones sobre reservas de hotel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController {
    private static final Logger LOGGER = LogManager.getLogger(BookingController.class);
    private BookingApiClient bookingApiClient;

    @GET
    @Path("/{id}")
    @Operation(
        summary = "Obtener reserva por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
        }
    )
    public Response getBookingById(@Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador de la reserva") @PathParam("id") long id) {
        LOGGER.info("Fetching booking information for ID: {}", id);
        return bookingApiClient.getBookingById(id);
    }

    @Inject
    public void setBookingApiClient(BookingApiClient bookingApiClient) {
        this.bookingApiClient = bookingApiClient;
    }
}
