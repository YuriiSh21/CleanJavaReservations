package dao;

import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface HallDAO {
    Hall getCheckedHall();
    void showHall(Hall hall);
    Date checkDate() throws ParseException;

}
