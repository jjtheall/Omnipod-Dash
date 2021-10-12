package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class Main extends Application {

    private int ICRatio;
    private int correctionFactor;
    private int targetBG;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Omnipod Dash");

        StartupScreen startup = new StartupScreen();

        //adding VBox to scene and showing scene
        primaryStage.setScene(new Scene(startup.getSceneContents(), 450, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
