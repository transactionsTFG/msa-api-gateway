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

import apiclient.agency.flight.FlightApiClient;

@Path("/flight")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightController {
    private static final Logger LOGGER = LogManager.getLogger(FlightController.class);
    private FlightApiClient flightApiClient;

    @EJB
    public void setFlightApiClient(FlightApiClient flightApiClient) {
        this.flightApiClient = flightApiClient;
    }

}
