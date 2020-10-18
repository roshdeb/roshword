package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CrosswordView {

    GridPane array = new GridPane();
    TextField x = new TextField();
    TextField y = new TextField();
    HBox h = new HBox();
    VBox v = new VBox();
    CheckBox blocked = new CheckBox("blocked");
    Label xLabel = new Label("x:");
    Label yLabel = new Label("y:");
    Label hClueLabel = new Label("Horizontal clue");
    Label hAnswerLabel = new Label("Horizontal answer");
    Label vClueLabel = new Label("Vertical clue");
    Label vAnswerLabel = new Label("Vertical answer");
    TextArea hClue = new TextArea();
    TextField hAnswer = new TextField();
    TextArea vClue = new TextArea();
    TextField vAnswer = new TextField();
    Button set = new Button("Set");
    TextField[][] crosswordFields = new TextField[ApplicationConstants.GRID_SIZE][ApplicationConstants.GRID_SIZE];
    Controller myController = null;

    public void SetController(Controller c) {
        this.myController = c;
        /*
        for(int i=0; i<ApplicationConstants.GRID_SIZE; i++) {
            for(int j=0; j<ApplicationConstants.GRID_SIZE; j++) {
                crosswordFields[i][j].setOnMouseClicked(c);
            }
        }

         */
    }



    public Scene createScene()  {
        x.setMaxWidth(30);
        y.setMaxWidth(30);
        createGrid();
        h.getChildren().addAll(xLabel,x,yLabel,y,blocked);
        v.getChildren().addAll(h,hClueLabel,hClue,hAnswerLabel,hAnswer,vClueLabel,vClue,vAnswerLabel,vAnswer,set);
        SplitPane root = new SplitPane(array,v);
        set.setId("SET_BUTTON");

        blocked.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (blocked.isSelected()) {
                    hClue.setDisable(true);
                    vClue.setDisable(true);
                    hAnswer.setDisable(true);
                    vAnswer.setDisable(true);
                }
                else {
                    hClue.setDisable(false);
                    vClue.setDisable(false);
                    hAnswer.setDisable(false);
                    vAnswer.setDisable(false);
                }
            }
        });



        set.setOnMouseClicked(this.myController);

        return new Scene(root, ApplicationConstants.SCREEN_WIDTH, ApplicationConstants.SCREEN_HEIGHT);
    }

    private void createGrid()   {
        for (int i = 0; i < ApplicationConstants.GRID_SIZE; i++) {
            for (int j = 0; j < ApplicationConstants.GRID_SIZE; j++) {
                crosswordFields[i][j] = new TextField();
                crosswordFields[i][j].setText(" ");
                crosswordFields[i][j].setEditable(false);
                crosswordFields[i][j].setId(i+","+j);
                crosswordFields[i][j].setMinHeight(47);
                crosswordFields[i][j].setOnMouseClicked(myController);
//                String boxID = crosswordFields[i][j].getId();
//                String[] ids = boxID.split(",");
                /*
                crosswordFields[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        x.setText(ids[0]);
                        y.setText(ids[1]);
                    }
                });

                 */
                array.add(crosswordFields[i][j], i, j);
            }
        }
    }

    public char getGridVal(int x, int y)    {
        return crosswordFields[x][y].getText().charAt(0);
    }
    public void setGridVal(int x, int y, char c)    {
        crosswordFields[x][y].setText(String.valueOf(c));
    }
    public int getX() {
        return Integer.parseInt(x.getText());
    }
    public int getY() {
        return Integer.parseInt(y.getText());
    }

    public void setX(int x) {
        this.x.setText(String.valueOf(x));
    }
    public void setY(int y) {
        this.y.setText(String.valueOf(y));
    }

    public String getVClue() {
        return vClue.getText();
    }
    public String getHClue() {
        return hClue.getText();
    }
    public String getVAnswer() {
        return vAnswer.getText();
    }
    public String getHAnswer() {
        return hAnswer.getText();
    }
    public void setVClue(String s) {
        this.vClue.setText(s);
    }
    public void setHClue(String s) {
        this.hClue.setText(s);
    }
    public void setVAnswer(String s) {
        this.vAnswer.setText(s);
    }
    public void setHAnswer(String s) {
        this.hAnswer.setText(s);
    }
    public void setBlocked(int x, int y, boolean b) {
        if (b) {
            crosswordFields[x][y].setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Cell Blocked :" + x +":"+  y);
        }
        else {
           // crosswordFields[x][y].setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Cell UnBlocked :" + x +":"+  y);
        }

    }

    public boolean isBlocked()  {
        return this.blocked.isSelected();
    }
    public void setBlockedCheckbox(boolean b)  {
        this.blocked.setSelected(b);
        if(!b)  {
            hClue.setDisable(false);
            vClue.setDisable(false);
            hAnswer.setDisable(false);
            vAnswer.setDisable(false);
        }
    }

}
