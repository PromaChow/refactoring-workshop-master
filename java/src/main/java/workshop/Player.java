package workshop;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private int places;
    private int purses;
    private boolean inPenaltyBox;

    public Player(String playerName, int places, int purses, boolean penalty) {
        this.playerName = playerName;
        this.places = places;
        this.purses = purses;
        this.inPenaltyBox = penalty;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.places = 0;
        this.purses = 0;
        this.inPenaltyBox = false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public void updatePlaces( int additional){
        this.setPlaces(this.getPlaces()+ additional);
    }

    public boolean checkPlaces(){
        return (this.getPlaces()>11);
    }

    public void incrementPurse(){
        this.purses++;
    }

}