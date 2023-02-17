package aspect;

import entity.Hall;
import entity.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationAspImpl implements ReservationAsp {
    static HallAspImpl hallAspImpl = new HallAspImpl();
    static TableAspImpl tableAspImpl = new TableAspImpl();
    static LoggingAspImpl loggingAspImpl = new LoggingAspImpl();
    static AdminImpl adminImpl = new AdminImpl();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    @Override
    public Reservation madeNewReservation(Date date, String command) {
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();
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
    public void readName(Reservation reservation, Scanner sc) {
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
    public void readSurname(Reservation reservation, Scanner sc) {
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
    public void readPhoneNumber(Reservation reservation, Scanner sc) {
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
    public void readNumberOfPersons(Reservation reservation, Scanner sc) {
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
    public void readRemark(Reservation reservation, Scanner sc) {
        System.out.println("Enter remark");
        String remark = sc.nextLine();
        reservation.setRemark(remark);
    }

    @Override
    public void reservationProcess(List<Reservation> reservationList, Hall hall, Date date) {
        hallAspImpl.showHall(hall);
        String choiceTable = hallAspImpl.readCommand(hallAspImpl.notification1());
        switch (choiceTable) {
            case "0":
                break;
            case "9":
                if (loggingAspImpl.logging())
                    adminImpl.openAdminMenu(reservationList);
                else {
                    System.out.println("Bad password");
                }
                break;
            default:
                try {
                    while (!tableAspImpl.isTableFree(choiceTable, hall)) {
                        choiceTable = hallAspImpl.readCommand(hallAspImpl.notification1());
                    }
                    Reservation reservation = madeNewReservation(date, choiceTable);
                    saveReservation(reservationList, reservation);
                    tableAspImpl.changeStatusOfTable(hall, reservation);
                    hallAspImpl.showHall(hall);
                } catch (NumberFormatException e) {
                    break;
                }
        }
    }

    @Override
    public void saveReservation(List<Reservation> list, Reservation reservation) {
        list.add(reservation);
    }
}