package DraftComponents.MVC.Model;

//Players are of two types of parent class Players, this is type 2 - FrontcourtPlayers inheriting Players components.
public class FrontcourtPlayers extends Player {

    private int strength;

    public FrontcourtPlayers(String playerName, int playerAge, Positions position, int strength) {
        super(playerName, playerAge, position);
        this.strength = strength;
    }

    public int getStrength() {

        return strength;
    }

    public void setStrength(int strength) {

        this.strength = strength;
    }

    /*
    polymorphism for a toString
    that prints different attributes of different playerType in this aspect "strength". calling super.class method and overriding it.
    */
    @Override
    public String toString() {
        return super.toString() + ", strength " + strength;
    }
}
