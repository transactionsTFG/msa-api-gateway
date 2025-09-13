package apiclient.agency.travel;

import javax.ws.rs.core.Response;

import business.travel.TravelInfo;
import business.travel.UpdateHotelBookingDTO;
import business.travel.UpdateReservationBookingDTO;
import business.travel.UpdateReservationDTO;
import msa.commons.controller.agency.reservationairline.ReservationAirlineRequestDTO;
import msa.commons.controller.agency.reservationbooking.CreateAirlineAndHotelReservationDTO;
import msa.commons.controller.hotel.booking.CreateHotelBookingDTO;

public interface TravelApiClient {
    Response getTravelById(long id);
    Response getTravelByIdUser(long idUser);
    Response getListTravel(TravelInfo dto);
    Response getTravelByIdHotelAndIdFlight(long idHotel, long idFlight);
    Response createReservation(ReservationAirlineRequestDTO dto);
    Response createBooking(CreateHotelBookingDTO dto);
    Response createReservationAndBooking(CreateAirlineAndHotelReservationDTO dto);
    Response updateReservation(UpdateReservationDTO dto);
    Response updateBooking(UpdateHotelBookingDTO dto);
    Response updateReservationAndBooking(UpdateReservationBookingDTO dto);
    Response deleteReservation(long idTravel, long id);
    Response deleteBooking(long idTravel, long id);
    Response deleteReservationAndBooking(long idTravel, long idReservation, long idBooking);
}
