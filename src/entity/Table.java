package entity;

public class Table {
    private String nameOfTable;
    private boolean tableStatus;
    private int places;

    public Table(String nameOfTable, boolean tableStatus, int places) {
        this.nameOfTable = nameOfTable;
        this.tableStatus = tableStatus;
        this.places = places;
    }

    public String getNameOfTable() {
        return nameOfTable;
    }

    public void setNameOfTable(String nameOfTable) {
        this.nameOfTable = nameOfTable;
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
