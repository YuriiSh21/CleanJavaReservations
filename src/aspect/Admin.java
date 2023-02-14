package aspect;

import entity.Reservation;

import java.text.ParseException;
import java.util.List;

public interface Admin {
    Reservation findReservationById(List<Reservation> list);
    List<Reservation> deleteReservationById(List<Reservation> list);
    List<Reservation> editReservation(List<Reservation> list) throws ParseException;

}
