package DraftComponents.MVC.Model;

public class Player {

    //use of encapsulation "data-hiding" protected instance variables
    protected String playerName;
    protected int playerAge;
    protected Positions position;

    public Player(String playerName, int playerAge, Positions position){
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return playerName + ":  " + position + ", age " + playerAge;
    }
}