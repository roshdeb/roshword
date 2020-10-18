package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CrosswordView myView = new CrosswordView();
        Controller controller  = new Controller(myView);
        myView.SetController(controller);
        primaryStage.setScene(myView.createScene());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
