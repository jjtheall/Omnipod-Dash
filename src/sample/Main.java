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
import javafx.geometry.Insets;

public class Main extends Application {

    private int ICRatio;
    private int correctionFactor;
    private int targetBG;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Omnipod Dash");

        //VBox that will hold all hboxes for each instance var
        VBox sceneContents = new VBox();
        sceneContents.setSpacing(5);

        //HBox that will display instructions at top of screen
        HBox inputInstructions = new HBox();
        Label inputInstructionText = new Label("Input the following information for use in calculations: ");
        inputInstructions.getChildren().add(inputInstructionText);

        //HBox for ICRatio input
        HBox ICRatioBox = new HBox();
        Label ICRatioText = new Label("Insulin Carb Ratio: ");
        TextField ICRatioTextField = new TextField();
        ICRatioBox.getChildren().add(ICRatioText);
        ICRatioBox.getChildren().add(ICRatioTextField);

        //Hbox for correctionFactor input
        HBox correctionFactorBox = new HBox();
        Label correctionFactorText = new Label("Correction Factor: ");
        TextField correctionFactorTextField = new TextField();
        correctionFactorBox.getChildren().add(correctionFactorText);
        correctionFactorBox.getChildren().add(correctionFactorTextField);

        //HBox for targetBG input
        HBox targetBGBox = new HBox();
        Label targetBGText = new Label("Target Blood Glucose: ");
        TextField targetBGTextField = new TextField();
        targetBGBox.getChildren().add(targetBGText);
        targetBGBox.getChildren().add(targetBGTextField);

        //save button that saves what is in TextFields to instance vars
        Button save = new Button("Save");
        save.setOnAction(actionEvent -> {
            ICRatio = Integer.parseInt(ICRatioTextField.getText());
            correctionFactor = Integer.parseInt(correctionFactorTextField.getText());
            targetBG = Integer.parseInt(targetBGTextField.getText());

            System.out.println("Insulin Carb Ratio: "+ICRatio);
            System.out.println("Correction Factor: "+correctionFactor);
            System.out.println("Target Blood Glucose: "+targetBG);
        });

        //adding HBoxes & Button to Vbox
        sceneContents.getChildren().addAll(inputInstructions,ICRatioBox,correctionFactorBox,targetBGBox,save);
        sceneContents.setMargin(inputInstructions, new Insets(10,10,10,10));
        sceneContents.setMargin(ICRatioBox, new Insets(10,10,10,10));
        sceneContents.setMargin(correctionFactorBox, new Insets(10,10,10,10));
        sceneContents.setMargin(targetBGBox, new Insets(10,10,10,10));
        sceneContents.setMargin(save, new Insets(10,10,10,10));

        //adding VBox to scene and showing scene
        primaryStage.setScene(new Scene(sceneContents, 450, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
