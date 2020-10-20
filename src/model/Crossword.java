package model;

import sample.ApplicationConstants;
import sample.CrosswordView;

public class Crossword {

    Cell[][] crossword = new Cell[ApplicationConstants.GRID_SIZE][ApplicationConstants.GRID_SIZE];

    public Crossword() {


        for (int i = 0; i < ApplicationConstants.GRID_SIZE; i++) {
            for (int j = 0; j < ApplicationConstants.GRID_SIZE; j++) {
                crossword[i][j] = new Cell(i,j);
            }
        }
    }

    public void setVerticalClue(int x, int y, Clue c, CrosswordView myView) {
        crossword[x][y].setVerticalClue(c);

        if (c.getAnswer().length() < ApplicationConstants.GRID_SIZE - y) {

            for (int i = 0; i <= c.getAnswer().length(); i++) {
                crossword[x][y + i].setCharacter(c.getAnswer().charAt(i));
                myView.resetError();
            }
        }
        else {myView.setError("Answer is too long");}
    }


    public void setHorizontalClue(int x, int y, Clue c, CrosswordView myView) {
        crossword[x][y].setHorizontalClue(c);

        if (c.getAnswer().length()<= ApplicationConstants.GRID_SIZE-x) {
            for (int i = 0; i < c.getAnswer().length(); i++) {
                crossword[x + i][y].setCharacter(c.getAnswer().charAt(i));
                myView.resetError();
            }
        }
        else {myView.setError("Answer is too long");}
    }

    public Clue getVerticalClue(int x, int y) {
        return crossword[x][y].getVerticalClue();
    }

    public Clue getHorizontalClue(int x, int y) {
        return crossword[x][y].getHorizontalClue();
    }

    public char getCharAt(int x, int y) {
        return crossword[x][y].getCharacter();
    }

    public void erase(int x, int y) {
        Clue h = crossword[x][y].getHorizontalClue();
        Clue v = crossword[x][y].getVerticalClue();


        if (h!=null) {
            for (int i = x; i < ApplicationConstants.GRID_SIZE; i ++) {
                crossword[i][y].setCharacter(' ');
            }
        }
        if (v!=null) {
            for (int i = y; i < ApplicationConstants.GRID_SIZE; i ++) {
                crossword[x][i].setCharacter(' ');
            }
        }
    }

    public boolean isBlocked(int x, int y) {
        return crossword[x][y].isBlocked();
    }

    public void setBlocked(int x, int y, boolean blocked)   {
        crossword[x][y].setBlocked(blocked);
    }
}
