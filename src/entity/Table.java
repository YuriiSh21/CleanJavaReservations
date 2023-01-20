package entity;

public class Table {
    private int numberOfTable;
    private boolean tableStatus;
    private int places;

    public Table(int numberOfTable, boolean tableStatus, int places) {
        this.numberOfTable = numberOfTable;
        this.tableStatus = tableStatus;
        this.places = places;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
