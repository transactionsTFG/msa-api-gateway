package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiclient.agency.travel.TravelApiClient;
import business.travel.TravelInfo;
import business.travel.UpdateHotelBookingDTO;
import business.travel.UpdateReservationBookingDTO;
import business.travel.UpdateReservationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import msa.commons.controller.agency.reservationairline.ReservationAirlineRequestDTO;
import msa.commons.controller.agency.reservationbooking.CreateAirlineAndHotelReservationDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/agency")
@Tag(name = "Agencia", description = "Orquestador de operaciones de viaje")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgencyController {
    private static final Logger LOGGER = LogManager.getLogger(AgencyController.class);
    private TravelApiClient travelApiClient;

    @GET
    @Path("/travel/{id}")
    @Operation(
        summary = "Obtener viaje por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Viaje encontrado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
        }
    )
    public Response getTravelById(@Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Identificador del viaje") @PathParam("id") long id) {
        LOGGER.info("Fetching travel information for ID: {}", id);
        return travelApiClient.getTravelById(id);
    }

    @GET
    @Path("/travel/user/{idUser}")
    @Operation(
        summary = "Obtener viajes por ID de usuario",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de viajes obtenida")
        }
    )
    public Response getTravelByIdUser(@Parameter(name = "idUser", in = ParameterIn.PATH, required = true, description = "Identificador del usuario") @PathParam("idUser") long idUser) {
        LOGGER.info("Fetching travel information for user ID: {}", idUser);
        return travelApiClient.getTravelByIdUser(idUser);
    }

    @GET
    @Path("/hotel-airline/{hotelId}/{airlineId}")
    @Operation(
        summary = "Obtener viaje por ID de hotel y aerolinea",
        responses = {
            @ApiResponse(responseCode = "200", description = "Viaje encontrado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
        }
    )
    public Response getTravelByHotelAndAirline(
        @Parameter(name = "hotelId", in = ParameterIn.PATH, required = true, description = "Identificador del hotel") @PathParam("hotelId") long hotelId, 
        @Parameter(name = "airlineId", in = ParameterIn.PATH, required = true, description = "Identificador de la aerolinea") @PathParam("airlineId") long airlineId) {
        LOGGER.info("Obteniendo viaje por ID de hotel y aerolinea: {}, {}", hotelId, airlineId);
        return travelApiClient.getTravelByIdHotelAndIdFlight(hotelId, airlineId);
    }

    @GET
    @Path("/list")
    @Operation(
        summary = "Obtener lista de viajes de Hotel con Aerolinea",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de viajes obtenida")
        }
    )
    public Response getTravelList(@BeanParam TravelInfo travelInfo) {
        LOGGER.info("Fetching travel list");
        return travelApiClient.getListTravel(travelInfo);
    }

    @POST
    @Path("/create/airline")
    @Operation(summary = "Crear reserva de avión", responses = {
        @ApiResponse(responseCode = "201", description = "Reserva de avión creada")
    })
    public Response createAirlineAndHotelReservation(ReservationAirlineRequestDTO dto) {
        LOGGER.info("Creating airline reservation: {}", dto);
        return travelApiClient.createReservation(dto);
    }

    @POST
    @Path("/create/hotel")
    @Operation(summary = "Crear reserva de hotel", responses = {
        @ApiResponse(responseCode = "201", description = "Reserva de hotel creada")
    })
    public Response createHotelReservation(CreateHotelBookingDTO dto) {
        LOGGER.info("Creating hotel reservation: {}", dto);
        return travelApiClient.createBooking(dto);
    }

    @POST
    @Path("/create/hotel-airline")
    @Operation(summary = "Crear reserva combinada hotel + avión", responses = {
        @ApiResponse(responseCode = "201", description = "Reserva combinada creada")
    })
    public Response createAirlineAndHotelReservation(CreateAirlineAndHotelReservationDTO dto) {
        LOGGER.info("Creating airline and hotel reservation: {}", dto);
        return travelApiClient.createReservationAndBooking(dto);
    }

    @PUT
    @Path("/update/airline")
    @Operation(summary = "Actualizar reserva de avión", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva de avión actualizada")
    })
    public Response updateAirlineReservation(UpdateReservationDTO dto) {
        LOGGER.info("Updating airline reservation: {}", dto);
        return travelApiClient.updateReservation(dto);
    }

    @PUT
    @Path("/update/hotel")
    @Operation(summary = "Actualizar reserva de hotel", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva de hotel actualizada")
    })
    public Response updateHotelBooking(UpdateHotelBookingDTO dto) {
        LOGGER.info("Updating hotel booking: {}", dto);
        return travelApiClient.updateBooking(dto);
    }

    @PUT
    @Path("/update/hotel-airline")
    @Operation(summary = "Actualizar reserva combinada hotel + avión", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva combinada actualizada")
    })
    public Response updateAirlineAndHotelReservation(UpdateReservationBookingDTO dto) {
        LOGGER.info("Updating airline and hotel reservation: {}", dto);
        return travelApiClient.updateReservationAndBooking(dto);
    }

    @DELETE
    @Path("/delete/airline/{reservationId}")
    @Operation(summary = "Eliminar reserva de avión", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva de avión eliminada")
    })
    public Response deleteAirlineReservation(@PathParam("reservationId") long reservationId) {
        LOGGER.info("Deleting airline reservation with ID: {}", reservationId);
        return travelApiClient.deleteReservation(reservationId);
    }

    @DELETE
    @Path("/delete/hotel/{bookingId}")
    @Operation(summary = "Eliminar reserva de hotel", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva de hotel eliminada")
    })
    public Response deleteHotelBooking(@PathParam("bookingId") long bookingId) {
        LOGGER.info("Deleting hotel booking with ID: {}", bookingId);
        return travelApiClient.deleteBooking(bookingId);
    }

    @DELETE
    @Path("/delete/hotel-airline/{reservationId}/{bookingId}")
    @Operation(summary = "Eliminar reserva combinada hotel + avión", responses = {
        @ApiResponse(responseCode = "200", description = "Reserva combinada eliminada")
    })
    public Response deleteAirlineAndHotelReservation(@PathParam("reservationId") long reservationId, @PathParam("bookingId") long bookingId) {
        LOGGER.info("Deleting airline reservation with ID: {} and hotel booking with ID: {}", reservationId, bookingId);
        return travelApiClient.deleteReservationAndBooking(reservationId, bookingId);
    }

    @EJB
    public void setTravelApiClient(TravelApiClient travelApiClient) {
        this.travelApiClient = travelApiClient;
    }
}
