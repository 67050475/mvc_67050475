package model;

public class Politician {
    private String id, name, party;
    public Politician(String id, String name, String party) {
        this.id = id; this.name = name; this.party = party;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return this.party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}