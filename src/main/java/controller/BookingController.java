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

@Path("/booking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController {
    private static final Logger LOGGER = LogManager.getLogger(BookingController.class);
    private BookingApiClient bookingApiClient;

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") long id) {
        LOGGER.info("Fetching booking information for ID: {}", id);
        return bookingApiClient.getBookingById(id);
    }

    @Inject
    public void setBookingApiClient(BookingApiClient bookingApiClient) {
        this.bookingApiClient = bookingApiClient;
    }
}
