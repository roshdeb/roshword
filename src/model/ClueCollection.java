package model;

import java.util.ArrayList;
import java.util.List;

public class ClueCollection {
    List<Clue> clueCollection = new ArrayList<>();
    Clue clue;


    public void add(String clueAnswer) {

        String[] clues = clueAnswer.split(",");
        clue.setClue(clues[0]);
        clue.setAnswer(clues[1]);
        clue.used = false;
        clueCollection.add(clue);

    }

    public Clue get() {
        for (Clue value : clueCollection) {
            if (!value.used) return value;
        }
        return null;
    }
}
