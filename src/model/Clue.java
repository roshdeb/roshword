package model;

public class Clue {
    private String clue;
    private String answer;

    boolean used; //weather the user has used this clue already

    public Clue(String c, String a) {
        this.clue = c;
        this.answer = a;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
