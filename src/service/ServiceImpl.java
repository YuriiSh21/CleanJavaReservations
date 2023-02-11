package service;

import aspect.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service {

    private Hall hall = new HallImpl();
    private Table table = new TableImpl();
    private Reservation reservation = new ReservationImpl();
    private Communication communication = new HallImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<entity.Hall> list) {
        return table.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public entity.Hall getCheckedHall() {    //
        return hall.getCheckedHall();
    }

    @Override
    public void notification2() {
        communication.notification2();
    }

    @Override
    public Date checkDate() throws ParseException {
        return hall.checkDate();
    }

    @Override
    public  void reservationProcess(List<entity.Reservation> reservationList, entity.Hall hall, Date date) {
        reservation.reservationProcess(reservationList, hall, date);
    }

}
