package controller;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.flight.FlightApiClient;
import business.flight.FlightParamsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/flight")
@Tag(name = "Vuelos", description = "Operaciones sobre vuelos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightController {
    private static final Logger LOGGER = LogManager.getLogger(FlightController.class);
    private FlightApiClient flightApiClient;

    @GET
    @Path("/{id}")
    @Operation(
        summary = "Obtener vuelo por ID",
        parameters = {
            @Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador del vuelo")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Vuelo encontrado"),
            @ApiResponse(responseCode = "404", description = "Vuelo no encontrado")
        }
    )
    public Response getFlightById(@PathParam("id") long id) {
        LOGGER.info("Fetching flight information for ID: {}", id);
        return flightApiClient.getFlightById(id);
    }

    @GET
    @Path("/instance/{id}")
    @Operation(
        summary = "Obtener instancia de vuelo por ID",
        parameters = {
            @Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador de la instancia de vuelo")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Instancia encontrada"),
            @ApiResponse(responseCode = "404", description = "Instancia no encontrada")
        }
    )
    public Response getFlightInstanceById(@PathParam("id") long id) {
        LOGGER.info("Fetching flight instance information for ID: {}", id);
        return flightApiClient.getFlightInstanceById(id);
    }

    @GET
    @Path("/params")
    @Operation(
        summary = "Buscar vuelos por parámetros",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de vuelos obtenida")
        }
    )
    public Response getFlightByParams(@BeanParam FlightParamsDTO params) {
        LOGGER.info("Fetching flight information with parameters: {}", params);
        return flightApiClient.getFlightByParams(params);
    }

    @EJB
    public void setFlightApiClient(FlightApiClient flightApiClient) {
        this.flightApiClient = flightApiClient;
    }

}
