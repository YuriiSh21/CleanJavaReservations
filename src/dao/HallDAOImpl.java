package dao;

import db.HallDB;
import entity.Hall;
import entity.Reservation;
import entity.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
                System.out.println(true); //for visible valid
                return true;
            }
        }
        System.out.println(false); //for visible valid
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
    public void showHall(Hall hall) {
        System.out.println(hall);
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        String command = "No command";
        System.out.print(s);
        command = sc.nextLine();
        //sc.close();
        return command;
    }

    @Override
    public Date checkDate() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a date: ");
        String date = in.nextLine();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date dateForCheck = s.parse(date);
        //in.close();
        return dateForCheck;
    }

    @Override
    public Reservation madeNewReservation(Date date, String command) {
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();
        reservation.setId(ID_GENERATOR.getAndIncrement());
        System.out.println("Enter your name");
        reservation.setName(sc.nextLine());
        System.out.println("Enter your surname");
        reservation.setSurname(sc.nextLine());
        System.out.println("Enter your phone number");
        reservation.setPhoneNumber(sc.nextInt());
        System.out.println("Enter number of people");
        reservation.setNumberOfPersons(sc.nextInt());
        reservation.setRemark(sc.nextLine());     //////  WTF ???
        System.out.println("Enter remark");
        reservation.setRemark(sc.nextLine());
        System.out.println("Reservation was completed");
        reservation.setDate(date);
        reservation.setNumberOfTable(Integer.parseInt(command));   //Exception
        return reservation;
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
}
