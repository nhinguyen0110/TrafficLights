/*
------------------------------------------------------------------------------
   Name:     NhiNguyen_IS221_Ch5_PP5_18
   Author:   Nhi Nguyen
   Date:     Mar 1, 2023
   Language: Java
   Purpose:  The purpose of this program is to write a JavaFX application that
             displays the drawing of a traffic light, and allow the user to
             select the state of the light (stop, caution, or go) from a set of
             radio buttons.
------------------------------------------------------------------------------
   ChangeLog:
   Who:      Nhi Nguyen            Date:     Mar 1, 2023
   Desc.:    This is the original version of the code.  
------------------------------------------------------------------------------
*/

package nhinguyen_is221_ch5_pp5_18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NhiNguyen_IS221_Ch5_PP5_18 extends Application {
private RadioButton stopRadioButton;
    private RadioButton cautionRadioButton;
    private RadioButton goRadioButton;

    private Circle stopLight;
    private Circle cautionLight;
    private Circle goLight;

    @Override
    public void start(Stage primaryStage) {

        // Create radio buttons for traffic light states
        ToggleGroup toggleGroup = new ToggleGroup();
        stopRadioButton = new RadioButton("Stop");
        stopRadioButton.setToggleGroup(toggleGroup);
        cautionRadioButton = new RadioButton("Caution");
        cautionRadioButton.setToggleGroup(toggleGroup);
        goRadioButton = new RadioButton("Go");
        goRadioButton.setToggleGroup(toggleGroup);

        // Create circles for traffic light lights
        stopLight = new Circle(30, Color.GRAY);
        cautionLight = new Circle(30, Color.GRAY);
        goLight = new Circle(30, Color.GRAY);

    
        // Create HBox to hold radio buttons
        HBox lightsButton = new HBox(20, stopRadioButton, cautionRadioButton, 
                goRadioButton);
        lightsButton.setAlignment(Pos.CENTER);

        // Create vbox to hold radio buttons and traffic light lights
        VBox vbox = new VBox(20, stopLight, cautionLight, goLight, lightsButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // Create grid pane to hold the vbox
        GridPane root = new GridPane();
        root.add(vbox, 0, 0);
        root.setAlignment(Pos.CENTER);

        // Add event handler to radio buttons
        stopRadioButton.setOnAction(event -> updateLights());
        cautionRadioButton.setOnAction(event -> updateLights());
        goRadioButton.setOnAction(event -> updateLights());

        // Create and show the scene
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Traffic Light");
        primaryStage.show();
    }

    // Update the traffic light based on the radio buttons
    private void updateLights() {
        if (stopRadioButton.isSelected()) {
            stopLight.setFill(Color.RED);
            cautionLight.setFill(Color.GRAY);
            goLight.setFill(Color.GRAY);
        }
        if (cautionRadioButton.isSelected()) {
            stopLight.setFill(Color.GRAY);
            cautionLight.setFill(Color.YELLOW);
            goLight.setFill(Color.GRAY);
        }
        if (goRadioButton.isSelected()) {
            stopLight.setFill(Color.GRAY);
            cautionLight.setFill(Color.GRAY);
            goLight.setFill(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}