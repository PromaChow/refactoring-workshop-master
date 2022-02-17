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


    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void add(String playerName) {

        Player player = new Player(playerName);
        players.add(player);
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }



    public void roll(int roll) {
        Player player = players.get(currentPlayer);
        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                player.setInPenaltyBox(false);
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                player.updatePlaces(roll);
                if (player.checkPlaces()) player.updatePlaces(-12);
                askQuestion();
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
            }

        } else {

            player.updatePlaces(roll);
            if (player.checkPlaces()) player.updatePlaces(-12);
            askQuestion();
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
    public boolean isWinner() {
        boolean winner = didPlayerWin();
        return winner;
    }
    public boolean wasCorrectlyAnswered() {
        Player player = players.get(currentPlayer);
        if (player.isInPenaltyBox()) {
            announce("Answer was correct!!!!");
            player.incrementPurse();
                announce(player.getPlayerName() + " now has " + player.getPurses() + " Gold Coins.");
            } else {
                updateCurrentPlayer();
                return true;
            }


        } else {

            announce("Answer was correct!!!!");
            purses[currentPlayer]++;
            announce(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer = (currentPlayer+1)%players.size();
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}