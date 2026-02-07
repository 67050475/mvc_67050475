package model;

public class Campaign {
    private String id, year, zone;
    public Campaign(String id, String year, String zone) {
        this.id = id; this.year = year; this.zone = zone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getZone() {
        return this.zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}