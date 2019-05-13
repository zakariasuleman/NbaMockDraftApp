package DraftComponents.MVC.Controller;

import DraftComponents.MVC.Model.*;
import DraftComponents.MVC.View.DraftView;
import java.util.ArrayList;

public class Controller {

    DraftView view;
    Model model;
    Teams teams = new Teams();
    //keep track of which roles have been picked
    private boolean pickedPG = false;
    private boolean pickedSG = false;
    private boolean pickedSF = false;
    private boolean pickedPF = false;
    private boolean pickedC = false;

    public static void main(String []args){
        DraftView view = new DraftView();
        Model m = new Model();
        Teams t =new Teams();
        Controller c = new Controller(view, m); //here we tell the Controller what model and view to use
        view.setControllerListener(c);
        view.updateLists(m.availablePlayerInfo(), t.getPicksAsStrings(0));
    }

    public Controller(DraftView v, Model m) {
        this.view = v; //set our class variables
        this.model = m;
    }

    public void userPickedPlayer(int playerIndex) {
        model.getPlayers();
        ArrayList<Player> players =model.getPlayers();
        Player selectedPlayer = model.getPlayers().get((playerIndex));

        //here, we need to check to validate if the position has not been fulfilled
        Positions role = selectedPlayer.getPosition();
        if(role.name() == "PG"){
            if(pickedPG) return;
            else pickedPG = true;
        }
        else if(role.name() == "SG"){
            if(pickedSG) return;
            else pickedSG = true;
        }
        else if(role.name() == "SF"){
            if(pickedSF) return;
            else pickedSF = true;
        }
        else if(role.name() == "PF"){
            if(pickedPF) return;
            else pickedPF = true;
        }
        else if(role.name() == "C"){
            if(pickedC) return;
            else pickedC = true;
        }
        /*actions for picking and removing*/
        teams.addTeamPick(0,selectedPlayer);
        players.remove(playerIndex);
        //Loop through each player in the playersListModel
        //if the player's position == role
        //remove the player from the playersListModel
        for (int i = players.size()-1; i>=0; i--) {
            Player playerToCheck = players.get(i);
            if(playerToCheck.getPosition() == role){
                players.remove(i);
            }
        }

        view.updateLists(model.availablePlayerInfo(), teams.getPicksAsStrings(0));
        /* if statement to disable the "Pick" button if the user team reaches 5 picks. */
        if(teams.getPicksEachTeamMade(0)>= Utilities.PICKS_PER_USER){
            /* setEnabled is a method from ActionListener that disables JButtons with a true/false boolean argument */
            /* so when the picks that are made reach 5 the "Pick" button is disabled */
            view.allowNoMorePicks();
        }
    }
}

