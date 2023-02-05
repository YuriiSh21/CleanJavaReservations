package dao;

import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class HallDAOImpl implements HallDAO {
    public static Hall checkedHall;
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    public Hall getCheckedHall() {
        return checkedHall;
    }

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {

        for (Hall hall : list) {
            if (date.equals(hall.getDate())) {
                checkedHall = hall;
                return true;
            }
        }
        return false;
    }

    @Override
    public void notification1() {
        System.out.println("Select free table");
    }

    @Override
    public void notification2() {
        System.out.println("This date don't have reservations");
    }

    @Override
    public String notification3() {
        return
                "Select free table and \n" +
                        "enter number of table for your reservation. \n" +
                        "Press 0 for exit";
    }
    @Override
    public void showHall(Hall hall) {
        System.out.println(hall);
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        displayMessage(s);
        return sc.nextLine();
    }

    @Override
    public Date checkDate() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the date (DD/MM/YYYY): ");
        String date = in.nextLine();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter = formatter.withLocale(Locale.US);
            LocalDate localDate = LocalDate.parse(date, formatter);
        if (localDate.isAfter(LocalDate.now()) || localDate.equals(LocalDate.now()))
            return s.parse(date);
        else {
            System.out.println("Input correct date");
            return checkDate();
        }
    }

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
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public List<Reservation> saveReservation(List<Reservation> list, Reservation reservation) {
        list.add(reservation);
        return list;
    }

    @Override
    public void changeStatusOfTable(Hall hall, Reservation reservation) {
        switch (reservation.getNumberOfTable()) {
            case 1:
                hall.getTable_1().setTableStatus(false);
                break;
            case 2:
                hall.getTable_2().setTableStatus(false);
                break;
            case 3:
                hall.getTable_3().setTableStatus(false);
                break;
        }
    }

    @Override
    public boolean isTableFree(String command, Hall hall) {
        switch (Integer.parseInt(command)) {
            case 1:
                if (hall.getTable_1().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            case 2:
                if (hall.getTable_2().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            case 3:
                if (hall.getTable_3().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            default:
                System.out.println("Try again");
                return false;


        }
    }
    @Override
    public void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate) {
        showHall(hall);
        String choiceTable = readCommand(notification3());
        switch (choiceTable) {
            case "0":
                break;
            default:
                try {
                    while (!isTableFree(choiceTable, hall)) {
                        choiceTable = readCommand(notification3());
                    }
                    Reservation reservation = madeNewReservation(checkDate.getCheckDate(), choiceTable);
                    saveReservation(reservationList, reservation);
                    changeStatusOfTable(hall, reservation);
                    showHall(hall);
                } catch (NumberFormatException e) {
                    break;
                }
        }
    }
}
