package sample;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BolusCalc {

    private VBox sceneContents;
    private int curBG;
    private int carbsEaten;
    private StartupScreen startupScreen;

    public BolusCalc(StartupScreen startupScreen){

        this.startupScreen = startupScreen;

        sceneContents = new VBox();
        sceneContents.setSpacing(5);
        sceneContents.setAlignment(Pos.TOP_CENTER);

        //HBox for instructions at top of bolus calc page
        HBox inputInstructions = new HBox();
        Label inputInstructionsText = new Label("Enter current blood glucose and carbohydrates to " +
                "calculate bolus ");
        inputInstructions.getChildren().add(inputInstructionsText);

        //HBox for blood glucose input
        HBox curBGBox = new HBox();
        Label curBGText = new Label("Current BG: ");
        TextField curBGTextField = new TextField();
        curBGBox.getChildren().add(curBGText);
        curBGBox.getChildren().add(curBGTextField);

        //HBox for carbohydrate input
        HBox carbsEatenBox = new HBox();
        Label carbsEatenText = new Label("Carbs: ");
        TextField carbsEatenTextField = new TextField();
        carbsEatenBox.getChildren().add(carbsEatenText);
        carbsEatenBox.getChildren().add(carbsEatenTextField);

        //HBox to display total insulin
        HBox totalBolus = new HBox();
        Label totalBolusText = new Label("Total Bolus: 0 U");
        totalBolus.getChildren().add(totalBolusText);

        //HBox for calculate and begin bolus buttons
        HBox buttons = new HBox();

        Button calculate = new Button("Calculate Total Bolus");
        calculate.setOnAction(actionEvent -> {
            curBG = Integer.parseInt(curBGTextField.getText());
            carbsEaten = Integer.parseInt(carbsEatenTextField.getText());

            double carbsInsulin = ((double)carbsEaten)/startupScreen.getICRatio();
            int bgDiff = curBG - startupScreen.getTargetBG();
            //may have to update the way this is handled if bgDiff is pos or neg to implement reverse correction
            double bgInsulin = ((double)bgDiff)/ startupScreen.getCorrectionFactor();
            double totalInsulin = carbsInsulin + bgInsulin;

            totalBolusText.setText("Total Bolus: " + totalInsulin + " U");
        });

        Button startBolus = new Button("Begin Bolus Delivery");
        startBolus.setOnAction(actionEvent -> {
            System.out.println("Bolus delivery started!");
        });

        buttons.getChildren().add(calculate);
        buttons.getChildren().add(startBolus);

        //adding HBoxes to sceneContents
        sceneContents.getChildren().addAll(inputInstructions,curBGBox,carbsEatenBox,totalBolus,buttons);
        sceneContents.setMargin(inputInstructions, new Insets(10,10,10,10));
        sceneContents.setMargin(curBGBox, new Insets(10,10,10,10));
        sceneContents.setMargin(carbsEatenBox, new Insets(10,10,10,10));
        sceneContents.setMargin(totalBolus, new Insets(10,10,10,10));
        sceneContents.setMargin(buttons, new Insets(10,10,10,10));

    }

    public VBox getSceneContents() {
        return sceneContents;
    }

    public int getCurBG() {
        return curBG;
    }

    public int getCarbsEaten() {
        return carbsEaten;
    }
}
