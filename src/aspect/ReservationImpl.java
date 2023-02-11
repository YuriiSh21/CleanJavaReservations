package aspect;

import entity.Hall;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationImpl implements Reservation {
    static HallImpl hallDAOImpl = new HallImpl();
    static TableImpl tableDAOImpl = new TableImpl();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    @Override
    public entity.Reservation madeNewReservation(Date date, String command) {
        Scanner sc = new Scanner(System.in);
        entity.Reservation reservation = new entity.Reservation();
        reservation.setId(ID_GENERATOR.getAndIncrement());
        readName(reservation, sc);
        readSurname(reservation, sc);
        readPhoneNumber(reservation, sc);
        readNumberOfPersons(reservation, sc);
        readRemark(reservation, sc);
        System.out.println("Reservation was completed");
        reservation.setDate(date);
        reservation.setNumberOfTable(Integer.parseInt(command));   //Exception
        return reservation;
    }
    @Override
    public void readName(entity.Reservation reservation, Scanner sc) {
        System.out.println("Enter your name");
        String name = sc.nextLine();
        if (name.matches("\\D{2,15}"))
            reservation.setName(name);
        else {
            System.out.println("Enter correct name");
            readName(reservation, sc);
        }
    }

    @Override
    public void readSurname(entity.Reservation reservation, Scanner sc) {
        System.out.println("Enter your surname");
        String surname = sc.nextLine();
        if (surname.matches("\\D{2,20}"))
            reservation.setSurname(surname);
        else {
            System.out.println("Enter correct surname");
            readSurname(reservation, sc);
        }
    }

    @Override
    public void readPhoneNumber(entity.Reservation reservation, Scanner sc) {
        System.out.println("Enter your phone number (xxxxxxxxx)");
        String phoneNumber = sc.nextLine();
        if (phoneNumber.matches("\\d{9}"))
            reservation.setPhoneNumber(Integer.parseInt(phoneNumber));
        else {
            System.out.println("Enter correct phone number");
            readPhoneNumber(reservation, sc);
        }
    }

    @Override
    public void readNumberOfPersons(entity.Reservation reservation, Scanner sc) {
        System.out.println("Enter number of persons (1-6)");
        String numberOfPersons = sc.nextLine();
        if (numberOfPersons.matches("[1-6]"))
            reservation.setNumberOfPersons(Integer.parseInt(numberOfPersons));
        else {
            System.out.println("Enter correct number");
            readNumberOfPersons(reservation, sc);
        }
    }

    @Override
    public void readRemark(entity.Reservation reservation, Scanner sc) {
        System.out.println("Enter remark");
        String remark = sc.nextLine();
        reservation.setRemark(remark);
    }
    @Override
    public void reservationProcess(List<entity.Reservation> reservationList, Hall hall, Date date) {
        hallDAOImpl.showHall(hall);
        String choiceTable = hallDAOImpl.readCommand(hallDAOImpl.notification3());
        switch (choiceTable) {
            case "0":
                break;
            default:
                try {
                    while (!tableDAOImpl.isTableFree(choiceTable, hall)) {
                        choiceTable = hallDAOImpl.readCommand(hallDAOImpl.notification3());
                    }
                    entity.Reservation reservation = madeNewReservation(date, choiceTable);
                    saveReservation(reservationList, reservation);
                    tableDAOImpl.changeStatusOfTable(hall, reservation);
                    hallDAOImpl.showHall(hall);
                } catch (NumberFormatException e) {
                    break;
                }
        }
    }
    @Override
    public void saveReservation(List<entity.Reservation> list, entity.Reservation reservation) {
        list.add(reservation);
    }
}
