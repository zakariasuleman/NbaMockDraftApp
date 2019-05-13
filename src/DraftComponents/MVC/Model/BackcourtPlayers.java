package DraftComponents.MVC.Model;


//Players are of two types of parent class Players, this is type 1 - BackcourtPlayers inheriting Players components.
public class BackcourtPlayers extends Player {

    private int speed;

    public BackcourtPlayers(String playerName, int playerAge, Positions positions, int speed) {
        super(playerName, playerAge, positions);
        this.speed= speed;
    }


    public int getSpeed() {

        return speed;
    }


    public void setSpeed(int speed) {

        this.speed = speed;
    }



    /*
    polymorphism for a toString
    that prints different attributes of different playerType in this aspect "speed". calling super.class method and overriding it.
    */
    @Override
    public String toString() {

        return super.toString() + ", speed " + speed;
    }


}
