package aspect;

import entity.Reservation;

import java.util.List;

public interface Admin {
    Reservation findReservationById(List<Reservation> list);
    List<Reservation> deleteReservationById(List<Reservation> list);

}
