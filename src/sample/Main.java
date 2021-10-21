package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    private int ICRatio;
    private int correctionFactor;
    private int targetBG;
    private int curBG;
    private int carbsEaten;

    @Override
    //try making stage subclass that knows about each screen subclass
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("What");

        StartupScene startup;
        BolusCalc bolus;

        ICRatio = 0;
        correctionFactor = 0;
        targetBG = 0;
        curBG = 0;
        carbsEaten = 0;

        //VBox for BOLUSCALC that will hold HBoxes for each instance var
        VBox bolusSceneContents = new VBox();
        bolusSceneContents.setSpacing(5);
        bolusSceneContents.setAlignment(Pos.TOP_CENTER);

        //HBox for instructions at top of bolus calc page
        HBox bolusInputInstructions = new HBox();
        Label bolusInputInstructionsText = new Label("Enter current blood glucose and carbohydrates to " +
                "calculate bolus ");
        bolusInputInstructions.getChildren().add(bolusInputInstructionsText);

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

            double carbsInsulin = ((double)carbsEaten)/ ICRatio;
            int bgDiff = curBG - targetBG;
            //may have to update the way this is handled if bgDiff is pos or neg to implement reverse correction
            double bgInsulin = ((double)bgDiff)/ correctionFactor;
            double totalInsulin = Math.round((carbsInsulin + bgInsulin)*100)/100.0;

            totalBolusText.setText("Total Bolus: " + totalInsulin + " U");
        });

        Button startBolus = new Button("Begin Bolus Delivery");
        startBolus.setOnAction(actionEvent -> {
            System.out.println("Bolus delivery started!");
        });

        buttons.getChildren().add(calculate);
        buttons.getChildren().add(startBolus);

        //adding HBoxes to sceneContents
        bolusSceneContents.getChildren().addAll(bolusInputInstructions,curBGBox,carbsEatenBox,totalBolus,buttons);
        bolusSceneContents.setMargin(bolusInputInstructions, new Insets(10,10,10,10));
        bolusSceneContents.setMargin(curBGBox, new Insets(10,10,10,10));
        bolusSceneContents.setMargin(carbsEatenBox, new Insets(10,10,10,10));
        bolusSceneContents.setMargin(totalBolus, new Insets(10,10,10,10));
        bolusSceneContents.setMargin(buttons, new Insets(10,10,10,10));

        //creating bolus calculator
        bolus = new BolusCalc(bolusSceneContents, 450, 550);


        //VBox FOR STARTUPSCENE that will hold all hboxes for each instance var
        VBox startupSceneContents = new VBox();
        startupSceneContents.setSpacing(5);
        startupSceneContents.setAlignment(Pos.TOP_CENTER);

        //HBox that will display instructions at top of screen
        HBox startupInputInstructions = new HBox();
        Label startupInputInstructionText = new Label("Input the following information for use in calculations: ");
        startupInputInstructions.getChildren().add(startupInputInstructionText);

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

            primaryStage.setScene(bolus);
        });

        //adding HBoxes & Button to Vbox
        startupSceneContents.getChildren().addAll(startupInputInstructions,ICRatioBox,correctionFactorBox,targetBGBox,save);
        startupSceneContents.setMargin(startupInputInstructions, new Insets(10,10,10,10));
        startupSceneContents.setMargin(ICRatioBox, new Insets(10,10,10,10));
        startupSceneContents.setMargin(correctionFactorBox, new Insets(10,10,10,10));
        startupSceneContents.setMargin(targetBGBox, new Insets(10,10,10,10));
        startupSceneContents.setMargin(save, new Insets(10,10,10,10));

        //creating startup scene
        startup = new StartupScene(startupSceneContents, 450, 550);

        //adding VBox to scene and showing scene
        primaryStage.setScene(startup);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
