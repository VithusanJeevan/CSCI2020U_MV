/*
* Name: Malaviya Nerumalan and Vithusan Jeevaratnam
* Purpose: To create a program which calculates the future value of an investment
* Date: March 1st, 2020
* File Name: q2.java
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;




public class Assignmentq2 extends Application {

  // used to format the answer to two decimals
  private static DecimalFormat df = new DecimalFormat("0.00");


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator");

        Pane pane = new VBox();

        // creates a label and text field to take in user input
        Label label1 = new Label("Investment Amount:");
        TextField textField1 = new TextField();
        pane.getChildren().addAll(label1,textField1);

        Label label2 = new Label("Years:");
        TextField textField2 = new TextField();
        pane.getChildren().addAll(label2,textField2);

        Label label3 = new Label("Annual Interest Rate:");
        TextField textField3 = new TextField();
        pane.getChildren().addAll(label3,textField3);

        Label label4 = new Label("Future Value:");
        TextField textField4 = new TextField();
        pane.getChildren().addAll(label4,textField4);

        Button calculate = new Button("Calculate");
        calculate.setStyle("-fx-border-color:blue; -fx-text-fill: black; ");
        pane.getChildren().add(calculate);

        // a button handler is used to take in the information enters and calculate the future value
        // and displays it back on the screen
        calculate.setOnAction((event) -> {
            double x = Double.parseDouble(textField1.getText());
            double y = Double.parseDouble(textField2.getText());
            double z = Double.parseDouble(textField3.getText());
            double total = x*(Math.pow((1+((z/100)/12)),y*12));

            textField4.setText(String.valueOf(df.format(total)));
        });




        primaryStage.setScene(new Scene(pane,300,500));
        primaryStage.show(); // shows all the components on the screen
    }


    public static void main(String[] args) {
        launch(args);
    }
}
