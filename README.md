# Omnipod Dash

## What is this project?

This is a program that emulates the functionality of the Personal Diabetes Management system called the Omnipod Dash created by Insulet. It (is a work in progress but eventually) will include a bolus calculator, a user programmable basal rate system, insulin delivery and blood glucose history, pod expiry, and other small features of the Dash.

## How to run this project?

I am using JavaFX and Java 12 to create the GUI. JavaFX will not work with Java versions later than 12, so in your project structure you must change the project SDK to Java 12. 

Additionally, I am using the JavaFX library in the JavaFX SDK version 17.0.0.1. In the modules section, you must add this library titled "lib" in this SDK folder. You can download this SDK at https://gluonhq.com/products/javafx/

Finally, if you get errors that there are modules missing, in the run configurations VM options, include this line: --module-path <lib folder destination> --add-modules=javafx.controls,javafx.fxml
  
## Documentation

Currently, there are only three working classes to this project. Main, BolusCalc, and StartupScreen.

StartupScreen is an object that contains a VBox JavaFX node that holds all of the content for the Startup screen which allows users to input their insulin/carb ratio, target blood glucose, and correction factor.
  
BolusCalc is an object similar to StartupScreen that allows users to input their current blood glucose and how many grams of carbohydrates they are eating, and two buttons: one that calculates how much insulin the user should receive based on the inputs from the startup screen and the bolus calc, and one that "starts" the insulin delivery by printing to the console.
  
Main initializes one instance of each object and sets the primary stage to the StartupScreen.
  
## Credits

**Jack Theall**: Programmed entire application and created all documentation
