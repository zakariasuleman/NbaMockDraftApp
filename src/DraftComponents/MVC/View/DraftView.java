package DraftComponents.MVC.View;

import DraftComponents.MVC.Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DraftView extends JFrame implements ActionListener {

    private JPanel inputPanel, displayPanel, displayPanelPool, textBoxPanel;
    private JLabel textBox, textBox1;
    private JButton submit;
    private JList<String> playerList;
    private DefaultListModel<String> playersListModel;
    private JList<String> playerPoolList;
    private DefaultListModel<String> playersPoolListModel;

    private Controller c;

    public DraftView(){
        super();
        DraftView view = this;
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        view.setSize(500,500);
        view.setLayout(new BorderLayout());
        view.setTitle("Welcome to the NBA Draft");
        view.createGUI();
        view.setVisible(true);
    }

    public void setControllerListener(Controller c) {
        this.c = c; //what we used to have in the constructor
    }

    public void updateLists(String[] availablePlayers, String[] chosenPlayers) {
        //MVC code revision to update the JList's
        playersListModel.removeAllElements();
        playersPoolListModel.removeAllElements();
        for (int i = 0; i < availablePlayers.length; i++) {
            playersListModel.addElement(availablePlayers[i]);
        }
        for (int i = 0; i < chosenPlayers.length; i++) {
            playersPoolListModel.addElement(chosenPlayers[i]);
        }
    }

    /* This consists mainly in this method and adds mechanisms like clicking, creating and calling Arrays */
    public void createGUI() {

        playersListModel = new DefaultListModel<String>();
        playersPoolListModel = new DefaultListModel<String>();
        playerList = new JList<String>(playersListModel);
        playerPoolList = new JList<String>(playersPoolListModel);

        /* adds scrolling mechanism to the JList. */
        JScrollPane listScroller = new JScrollPane(playerList);
        JScrollPane listScroller2 = new JScrollPane(playerPoolList);
        listScroller.setPreferredSize(new Dimension(310, 80));
        listScroller2.setPreferredSize(new Dimension(310, 80));

        displayPanel = new JPanel();
        displayPanelPool = new JPanel();
        textBoxPanel = new JPanel();
        textBox = new JLabel();
        textBox1 = new JLabel();
        submit = new JButton();
        inputPanel = new JPanel();
        submit = new JButton("Pick");

        textBox1.setText("Your team is shown as you pick on the left! Limit is one player per position! ");
        textBox.setText("You are the North Hennepin Hawks pick 5 players!");
        inputPanel.add(submit);
        inputPanel.add(textBox);
        textBoxPanel.add(textBox1);
        displayPanel.add(listScroller);
        displayPanelPool.add(listScroller2);

        /*this adds the actionPerformed method to the submit(pick) button*/
        submit.addActionListener(this);

        /*adds location to the panel aspects*/
        add(displayPanel, BorderLayout.AFTER_LINE_ENDS);
        add(displayPanelPool, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.AFTER_LAST_LINE);
        add(textBoxPanel, BorderLayout.NORTH);

    }

    public void allowNoMorePicks(){
        submit.setEnabled(false);
    }

    //this is how I am implementing the actionListener interface is this method
    public void actionPerformed(ActionEvent e){
        Object key = e.getSource();
        /* this if statement adds the selected player into the second jList and removes that pick from the ArrayList and the available players list. */
        if(key == submit){
            int pick = playerList.getSelectedIndex();
            c.userPickedPlayer(pick);
         }
    }
}
