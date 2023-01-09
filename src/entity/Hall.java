package entity;


public class Hall {
    public Table table_1;
    private Table table_2;
    private Table table_3;

    public Hall(Table table_1, Table table_2, Table table_3) {
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
    }

    public Hall() {
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

}

