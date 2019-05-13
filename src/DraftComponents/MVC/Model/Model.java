package DraftComponents.MVC.Model;

import java.util.ArrayList;

public class Model {

    //arrayList of players is created here.
    ArrayList<Player> players;
    Teams teams;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Model() {
        players = new ArrayList<>();
        teams = new Teams();
        /* adds the 25 players the user can choose from into an ArrayList. */
        Player pg1 = new BackcourtPlayers("Russell Westbrook", 29, Positions.PG, 88);
        Player pg2 = new BackcourtPlayers("Kyrie Irving", 28, Positions.PG, 97);
        Player pg3 = new BackcourtPlayers("Damian Lillard", 26, Positions.PG, 89);
        Player pg4 = new BackcourtPlayers("Chris Paul", 34, Positions.PG, 87);
        Player pg5 = new BackcourtPlayers("Stephen Curry", 31, Positions.PG, 94);
        players.add(pg1);
        players.add(pg2);
        players.add(pg3);
        players.add(pg4);
        players.add(pg5);
        Player sg1 = new BackcourtPlayers("James Harden", 29, Positions.SG, 94);
        Player sg2 = new BackcourtPlayers("Kobe Bryant", 39, Positions.SG, 93);
        Player sg3 = new BackcourtPlayers("Dwayne Wade", 38, Positions.SG, 91);
        Player sg4 = new BackcourtPlayers("Victor Oladipo", 23, Positions.SG, 88);
        Player sg5 = new BackcourtPlayers("DeMar DeRozan", 25, Positions.SG, 91);
        players.add(sg1);
        players.add(sg2);
        players.add(sg3);
        players.add(sg4);
        players.add(sg5);
        Player sf1 = new FrontcourtPlayers("Lebron James", 33, Positions.SF, 88);
        Player sf2 = new FrontcourtPlayers("Kevin Durant", 27, Positions.SF, 85);
        Player sf3 = new FrontcourtPlayers("Kawhi Leonard", 29, Positions.SF, 86);
        Player sf4 = new FrontcourtPlayers("Jimmy Butler", 24, Positions.SF, 97);
        Player sf5 = new FrontcourtPlayers("Paul George", 28, Positions.SF, 94);
        players.add(sf1);
        players.add(sf2);
        players.add(sf3);
        players.add(sf4);
        players.add(sf5);
        Player pf1 = new FrontcourtPlayers("Anthony Davis", 28, Positions.PF, 87);
        Player pf2 = new FrontcourtPlayers("Blake Griffin", 26, Positions.PF, 98);
        Player pf3 = new FrontcourtPlayers("Nikola Jokic", 34, Positions.PF, 98);
        Player pf4 = new FrontcourtPlayers("Kevin Love", 31, Positions.PF, 96);
        Player pf5 = new FrontcourtPlayers("Draymond Green", 32, Positions.PF, 98);
        players.add(pf1);
        players.add(pf2);
        players.add(pf3);
        players.add(pf4);
        players.add(pf5);
        Player c1 = new FrontcourtPlayers("Joel Embiid", 29, Positions.C, 97);
        Player c2 = new FrontcourtPlayers("Al Horford", 36, Positions.C, 95);
        Player c3 = new FrontcourtPlayers("Marc Gasol", 34, Positions.C, 95);
        Player c4 = new FrontcourtPlayers("Steven Adams", 31, Positions.C, 89);
        Player c5 = new FrontcourtPlayers("Pau Gasol", 36, Positions.C, 91);
        players.add(c1);
        players.add(c2);
        players.add(c3);
        players.add(c4);
        players.add(c5);
    }

    public String[] availablePlayerInfo() {
        String[] everyPlayer= new String[players.size()];
        for (int i = 0; i < players.size(); i++) {
            everyPlayer[i] = players.get(i).toString();
        }
        return everyPlayer;
    }
}
