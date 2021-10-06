package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private int ICRatio;
    private int correctionFactor;
    private int targetBG;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Omnipod Dash");
        primaryStage.setScene(new Scene(root, 450, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
