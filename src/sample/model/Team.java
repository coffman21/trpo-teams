package sample.model;

public class Team {
    private int id;
    private String name;
    private String country;
    private String arena;
    private String conference;
    private String division;
    private String date_created;

    public Team(String[] objects) {
        this.id = 0;
        this.name = (String) objects[0];
        this.country = (String) objects[1];
        this.arena = (String) objects[2];
        this.conference = (String) objects[3];
        this.division = (String) objects[4];
        this.date_created = (String) objects[5];
    }

    public Team(Object[] objects) {
        this.id = (int) objects[0];
        this.name = (String) objects[1];
        this.country = (String) objects[2];
        this.arena = (String) objects[3];
        this.conference = (String) objects[4];
        this.division = (String) objects[5];
        this.date_created = (String) objects[6];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getArena() {
        return arena;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public String getDate_created() {
        return date_created;
    }
}
