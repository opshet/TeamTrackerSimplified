package sg.edu.rp.c346.id20010021.teamtrackersimplified;

import java.io.Serializable;

public class Match implements Serializable {

    private int id;
    private String team;
    private int score;
    private String team2;
    private int score2;

    public Match(String team, int score, String team2, int score2 ) {
        this.team = team;
        this.score = score;
        this.team2 = team2;
        this.score2 = score2;
    }
    public Match(int id, String team, int score, String team2, int score2 ) {
        this.id=id;
        this.team = team;
        this.score = score;
        this.team2 = team2;
        this.score2 = score2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
