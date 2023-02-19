package aspect;

import entity.Reservation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminImpl implements Communication, Admin {

    public void openAdminMenu(List<Reservation> list) {
        switch (readCommand(notification1())) {
            case "1":
                System.out.println(findReservationById(list));
                openAdminMenu(list);
                break;
            case "2":
                System.out.println(list);
                openAdminMenu(list);
                break;
            case "3":
                System.out.println(deleteReservationById(list));
                openAdminMenu(list);
                break;
            case "4":
                System.out.println(editReservation(list));
                openAdminMenu(list);
                break;
            case "5":
                break;
            default:
                System.out.println(notification2());
                openAdminMenu(list);
                break;
        }
    }

    @Override
    public String notification1() {
        return "Enter 1 for RESERVATION SEARCH \n" +
                "Enter 2 for SHOW ALL RESERVATIONS \n" +
                "Enter 3 for CANCEL RESERVATION \n" +
                "Enter 4 for EDIT RESERVATION \n" +
                "Enter 5 for EXIT";
    }

    @Override
    public String notification2() {
        return "Enter correct command";
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        displayMessage(s);
        return sc.nextLine();
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public Reservation findReservationById(List<Reservation> list) {
        int id = 0;
        try {
            id = Integer.parseInt(readCommand("Enter ID: "));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("No such ID, try again");
            findReservationById(list);
        }
        int finalId = id;
        list = list.stream().filter(e -> e.getId() == finalId).collect(Collectors.toList());
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Reservation with ID " + id + " not exist");
            return null;
        }
    }

    @Override
    public List<Reservation> deleteReservationById(List<Reservation> list) {
        int id;
        try {
            id = Integer.parseInt(readCommand("Enter ID for DELETE RESERVATION: "));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("No such ID, try again");
            id = Integer.parseInt(readCommand("Enter ID for DELETE RESERVATION: "));
        }
        int finalId = id;
        list.removeIf(e -> e.getId() == finalId);
        return list;
    }

    @Override
    public List<Reservation> editReservation(List<Reservation> list) {
        Reservation reservationForEditing = findReservationById(list);
        try {
            if (reservationForEditing.getId() > 0) {
                Scanner sc = new Scanner(System.in);
                ReservationAspImpl reservationAsp = new ReservationAspImpl();
                System.out.println("Name is: " + reservationForEditing.getName());
                reservationAsp.readName(reservationForEditing, sc);
                System.out.println("Surname is: " + reservationForEditing.getSurname());
                reservationAsp.readSurname(reservationForEditing, sc);
                System.out.println("Phone number is: " + reservationForEditing.getPhoneNumber());
                reservationAsp.readPhoneNumber(reservationForEditing, sc);
                System.out.println("Table was reserved for "
                        + reservationForEditing.getNumberOfPersons() + " person");
                reservationAsp.readNumberOfPersons(reservationForEditing, sc);
                System.out.println("Remark: " + reservationForEditing.getRemark());
                reservationAsp.readRemark(reservationForEditing, sc);
                int finalId = reservationForEditing.getId();
                list = list.stream().filter(e -> e.getId() != finalId)
                        .collect(Collectors.toList());
                list.add(reservationForEditing);
                System.out.println("Reservation has been changed");
                return list;
            } else
                return null;
        } catch (NullPointerException npe) {
            return null;
        }
    }
}
