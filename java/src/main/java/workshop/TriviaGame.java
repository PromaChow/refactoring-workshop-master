package workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TriviaGame {
    private ArrayList<Player> players;
    Questions question = new Questions();

    int currentPlayer = 0;

    public TriviaGame() {
        players = new ArrayList<Player>();
        question.generateQuestions();
    }


    public void add(String playerName) {

        Player player = new Player(playerName);
        players.add(player);
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }
    private void rollUpdate(Player player, int roll){
        player.updatePlaces(roll);
        if (player.checkPlaces()) player.updatePlaces(-12);
        askQuestion();
    }

    public void roll(int roll) {
        Player player = players.get(currentPlayer);
        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                player.setInPenaltyBox(false);
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                rollUpdate(player,roll);
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
            }

        } else {
            rollUpdate(player,roll);
        }

    }


    private void askQuestion() {
        String catagory = currentCategory();
        String quesReturn = question.getQuestion(catagory);
        announce(quesReturn);
    }


    private String currentCategory() {
        String[] catagoryMapping = {"Pop","Science","Sports"};
        Player player = players.get(currentPlayer);
        int place_no = player.getPlaces();
        if(place_no > 10) return "Rock";
        return catagoryMapping[place_no % 4];
    }

    private void updateCurrentPlayer() {
        currentPlayer=+1;
        currentPlayer %= players.size();
    }

    public void wasCorrectlyAnswered() {
        Player player = players.get(currentPlayer);
        if (!player.isInPenaltyBox()) {
            announce("Answer was correct!!!!");
            player.incrementPurse();
            announce(player.getPlayerName() + " now has " + player.getPurses() + " Gold Coins.");
        }
        updateCurrentPlayer();

    }

    public void wrongAnswer() {
        Player player = players.get(currentPlayer);
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        player.setInPenaltyBox(true);
        updateCurrentPlayer();
    }


    protected void announce(Object message) {
        System.out.println(message);
    }
}