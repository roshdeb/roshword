package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import model.Clue;
import model.Crossword;

public class Controller implements EventHandler {
    private CrosswordView myView = null;
    Crossword crossword = new Crossword();


    public Controller(CrosswordView v)  {
        this.myView = v;
    }

    boolean check = true;

    @Override
    public void handle(Event event) {
        if(((Control)event.getSource()).getId().equals("SET_BUTTON"))
            handleSetButton(event);
        else
            handleGrid(event);
    }

    public void handleSetButton(Event event)    {
        if (myView.getHAnswer().isEmpty() ^ myView.getHClue().isEmpty()) {
            myView.setError("fill in blank horizontal box");
        }
        if (myView.getVAnswer().isEmpty() ^ myView.getVClue().isEmpty()) {
            myView.setError("fill in blank vertical box");
        }
        crossword.erase(myView.getX(),myView.getY());
        crossword.setBlocked(myView.getX(), myView.getY(), myView.isBlocked());

        if (!myView.getHAnswer().isEmpty()) {
            Clue c = new Clue(myView.getHClue(),myView.getHAnswer());
            crossword.setHorizontalClue(myView.getX(),myView.getY(),c,myView);

        }
        if (!myView.getVAnswer().isEmpty()) {
            Clue c = new Clue(myView.getVClue(),myView.getVAnswer());
            crossword.setVerticalClue(myView.getX(),myView.getY(),c,myView);

        }
        if (!myView.getVAnswer().isEmpty() && !myView.getHAnswer().isEmpty()) {
            if (myView.getHAnswer().charAt(0) != myView.getVAnswer().charAt(0)) {
                myView.setError("first characters don't match");
                check=false;

            }
        }

        if (check) {
            refresh();
        }

    }

    public void handleGrid(Event event)    {
        int x = Integer.parseInt(((Control)event.getSource()).getId().split(",")[0]);
        int y = Integer.parseInt(((Control)event.getSource()).getId().split(",")[1]);
        myView.setX(x);
        myView.setY(y);

        myView.setSet(false);

        if (crossword.getHorizontalClue(x,y)!=null) {
            myView.setHClue(crossword.getHorizontalClue(x, y).getClue());
            myView.setHAnswer(crossword.getHorizontalClue(x,y).getAnswer());
        }
        else {
            myView.setHClue("");
            myView.setHAnswer("");
        }
        if (crossword.getVerticalClue(x,y)!=null) {
            myView.setVClue(crossword.getVerticalClue(x,y).getClue());
            myView.setVAnswer(crossword.getVerticalClue(x,y).getAnswer());
        }
        else {
            myView.setVClue("");
            myView.setVAnswer("");
        }



        myView.setBlockedCheckbox(crossword.isBlocked(x,y));
        myView.setBlocked(x,y,crossword.isBlocked(x,y));

    }


    public void refresh() {
        for (int i = 0; i < ApplicationConstants.GRID_SIZE; i ++) {
            for (int j = 0; j < ApplicationConstants.GRID_SIZE; j++) {
                if (crossword.isBlocked(i,j)) {
                    myView.setBlocked(i,j,true);
                }
                else {
                    myView.setBlocked(i,j,false);
                    myView.setGridVal(i,j,crossword.getCharAt(i,j));
                }

            }
        }
    }

    private void displayErrorMsg(String msg)    {
        System.out.println(msg);
    }


}
