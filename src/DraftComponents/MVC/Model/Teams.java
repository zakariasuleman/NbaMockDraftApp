package DraftComponents.MVC.Model;

import java.util.*;
import static DraftComponents.MVC.Model.Utilities.PICKS_PER_USER;

public class Teams {

    private ArrayList<String> nbaTeams;

    /* int array */
    private int[] picksEachTeamMade;

    /* 2D Array named picks (dimensions explained in the array creation) */
    private Player[][] picks;

    public Teams() {
        nbaTeams = new ArrayList<String>();

        /* adding all nba teams into one ArrayList */
        nbaTeams.add("North Hennepin Hawks");
        nbaTeams.add("Boston Celtics");
        nbaTeams.add("Brooklyn Nets");
        nbaTeams.add("Charlotte Hornets");
        nbaTeams.add("Chicago Bulls");
        /* this calls for the size of the Teams arrayList and holds it as an int array */
        picksEachTeamMade = new int[nbaTeams.size()];
        /* first dimensions holds the amount of teams stored in the array, and second dimension stores pick for the user team */
        picks = new Player[nbaTeams.size()][PICKS_PER_USER];
    }

    public ArrayList<String> getNbaTeams() {
        return nbaTeams;
    }

    public int getPicksEachTeamMade(int teamIndex) {
        return picksEachTeamMade[teamIndex];
    }

    public void addTeamPick(int teamIndex, Player pick) {

        /* creates variable to see how many picks a team has made */
        int numPicksDone = picksEachTeamMade[teamIndex];

        /* this occurs when the number of picks is less than 5 so it'll keep going for the user team.
         * then it create another int that holds the number of picks */
        if (numPicksDone < PICKS_PER_USER) {
            int pickNumber = numPicksDone;
            picks[teamIndex][pickNumber] = pick;
        }
        /* counts up the amount of picks for the user team at the end of the method */
        picksEachTeamMade[teamIndex] += 1;
    }

    public String[] getPicksAsStrings(int teamIndex){
        Player[] selectedTeamPicks = picks[teamIndex];
        int numOfPicks = getPicksEachTeamMade(teamIndex);
        String[] teamPickedPlayers = new String[numOfPicks];
        for(int i=0; i<teamPickedPlayers.length; i++){
            teamPickedPlayers[i] = selectedTeamPicks[i].toString();
        }
        return teamPickedPlayers;
    }
}