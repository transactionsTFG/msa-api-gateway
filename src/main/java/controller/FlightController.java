package controller;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.flight.FlightApiClient;
import business.flight.FlightParamsDTO;

@Path("/flight")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightController {
    private static final Logger LOGGER = LogManager.getLogger(FlightController.class);
    private FlightApiClient flightApiClient;

    @GET
    @Path("/{id}")
    public Response getFlightById(@PathParam("id") long id) {
        LOGGER.info("Fetching flight information for ID: {}", id);
        return flightApiClient.getFlightById(id);
    }

    @GET
    @Path("/instance/{id}")
    public Response getFlightInstanceById(@PathParam("id") long id) {
        LOGGER.info("Fetching flight instance information for ID: {}", id);
        return flightApiClient.getFlightInstanceById(id);
    }

    @GET
    @Path("/params")
    public Response getFlightByParams(@BeanParam FlightParamsDTO params) {
        LOGGER.info("Fetching flight information with parameters: {}", params);
        return flightApiClient.getFlightByParams(params);
    }

    @EJB
    public void setFlightApiClient(FlightApiClient flightApiClient) {
        this.flightApiClient = flightApiClient;
    }

}
