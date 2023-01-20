package entity;


import java.util.Date;

public class Hall {
    private Date date;
    public Table table_1;
    private Table table_2;
    private Table table_3;

    public Hall(Date date, Table table_1, Table table_2, Table table_3) {
        this.date = date;
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
    }

    public Hall() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Table getTable_1() {
        return table_1;
    }

    public void setTable_1(Table table_1) {
        this.table_1 = table_1;
    }

    public Table getTable_2() {
        return table_2;
    }

    public void setTable_2(Table table_2) {
        this.table_2 = table_2;
    }

    public Table getTable_3() {
        return table_3;
    }

    public void setTable_3(Table table_3) {
        this.table_3 = table_3;
    }

    @Override
    public String toString() {
        return "Hall{" +
                ", date=" + date +
                ", \n Table #1 is free = " + table_1.isTableStatus() +
                ", \n Table #2 is free = " + table_2.isTableStatus() +
                ", \n Table #3 is free = " + table_3.isTableStatus();
    }

}

