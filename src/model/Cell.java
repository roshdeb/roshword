package model;

public class Cell {
    int x;
    int y;

    private Clue horizontalClue = null;
    private Clue verticalClue = null;

    boolean vUsed = false;
    boolean hUsed = false;

    char character;

    private boolean blocked;

    public Cell(int x, int y) {
        x = this.x;
        y = this.y;
    }

    public void setVerticalClue(Clue c) {
        this.verticalClue = c;
    }

    public void setHorizontalClue(Clue c) {
        this.horizontalClue = c;
    }

    public Clue getHorizontalClue() {
        return horizontalClue;
    }

    public Clue getVerticalClue() {
        return verticalClue;
    }

    public void setCharacter(char c) {
        this.character = c;
    }

    public char getCharacter() {
        return this.character;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public  void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setvUsed(boolean b) {
        this.vUsed = b;
    }

    public void sethUsed(boolean b) {
        this.hUsed = b;
    }

    public boolean ishUsed() {
        return hUsed;
    }

    public boolean isvUsed() {
        return vUsed;
    }
}
