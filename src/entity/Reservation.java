package entity;

import java.util.Date;

public class Reservation {
    private int id;
    private String name;
    private String surname;
    private int phoneNumber;
    private int numberOfPersons;
    private String remark;
    private Date date;
    private int numberOfTable;

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    @Override
    public String toString() {
        return "Reservation:" +
                " \n id = " + id +
                ", \n Name = '" + name + '\'' +
                ", \n Surname = '" + surname + '\'' +
                ", \n Phone number = " + phoneNumber +
                ", \n Number of Persons = " + numberOfPersons +
                ", \n Remark = '" + remark + '\'' +
                ", \n Date = " + date +
                ",\n Number of table = " + numberOfTable;
    }
}
