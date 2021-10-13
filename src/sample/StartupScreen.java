package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartupScreen{

    private int ICRatio;
    private int correctionFactor;
    private int targetBG;
    private VBox sceneContents;
    private Stage primaryStage;

    public StartupScreen(){

        ICRatio = 0;
        correctionFactor = 0;
        targetBG = 0;

        //VBox that will hold all hboxes for each instance var
        sceneContents = new VBox();
        sceneContents.setSpacing(5);
        sceneContents.setAlignment(Pos.TOP_CENTER);

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
    }

    public int getICRatio() {
        return ICRatio;
    }

    public int getCorrectionFactor() {
        return correctionFactor;
    }

    public int getTargetBG() {
        return targetBG;
    }

    public VBox getSceneContents(){
        return sceneContents;
    }
}
