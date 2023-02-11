package dao;

import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface ReservationDAO {
    Reservation madeNewReservation(Date date, String command);

    void readName(Reservation reservation, Scanner scanner);

    void readSurname(Reservation reservation, Scanner scanner);

    void readPhoneNumber(Reservation reservation, Scanner scanner);

    void readNumberOfPersons(Reservation reservation, Scanner scanner);

    void readRemark(Reservation reservation, Scanner scanner);
    void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate);
    void saveReservation(List<Reservation> list, Reservation reservation);
}
