package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

public class Main extends Application {

    private String ICRatio;
    private String correctionFactor;
    private String targetBG;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Omnipod Dash");

        //VBox that will hold all hboxes for each instance var
        VBox sceneContents = new VBox();
        sceneContents.setSpacing(15);

        //HBox that will display instructions at top of screen
        HBox inputInstructions = new HBox();
        Label inputInstructionText = new Label("Input the following information for use in calculations: ");
        inputInstructions.getChildren().add(inputInstructionText);

        //HBox for ICRatio input
        HBox ICRatioPane = new HBox();
        Label ICRatioText = new Label("Insulin Carb Ratio: ");
        TextField ICRatioTextField = new TextField();
        ICRatioPane.getChildren().add(ICRatioText);
        ICRatioPane.getChildren().add(ICRatioTextField);

        //Hbox for correctionFactor input
        HBox correctionFactorPane = new HBox();
        Label correctionFactorText = new Label("Correction Factor: ");
        TextField correctionFactorTextField = new TextField();
        correctionFactorPane.getChildren().add(correctionFactorText);
        correctionFactorPane.getChildren().add(correctionFactorTextField);

        //HBox for targetBG input
        HBox targetBGPane = new HBox();
        Label targetBGText = new Label("Target Blood Glucose: ");
        TextField targetBGTextField = new TextField();
        targetBGPane.getChildren().add(targetBGText);
        targetBGPane.getChildren().add(targetBGTextField);

        //adding HBoxes & Button to Vbox
        sceneContents.getChildren().addAll(inputInstructions,ICRatioPane,correctionFactorPane,targetBGPane);

        //adding VBox to scene and showing scene
        primaryStage.setScene(new Scene(sceneContents, 450, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
