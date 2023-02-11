package aspect;

import entity.Hall;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface Reservation {
    entity.Reservation madeNewReservation(Date date, String command);

    void readName(entity.Reservation reservation, Scanner scanner);

    void readSurname(entity.Reservation reservation, Scanner scanner);

    void readPhoneNumber(entity.Reservation reservation, Scanner scanner);

    void readNumberOfPersons(entity.Reservation reservation, Scanner scanner);

    void readRemark(entity.Reservation reservation, Scanner scanner);
    void reservationProcess(List<entity.Reservation> reservationList, Hall hall, Date date);
    void saveReservation(List<entity.Reservation> list, entity.Reservation reservation);
}
