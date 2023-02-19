package entity;

public class Table {
    private boolean tableStatus;

    public Table(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }
}