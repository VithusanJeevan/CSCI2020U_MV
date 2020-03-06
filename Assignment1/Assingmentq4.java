// Author: Malaviya Nerumalan and Vithusan Jeevartnam
// Date: March 5, 2020
// Purpose: To create a GUI that reads the text in a file and counts the number of occurrences of each letter
//********************************************************************************************************************
package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        HBox smallPane = new HBox(10);
        Button viewButton = new Button("View");
        TextField textFile = new TextField();
        Label fileNameLabel = new Label("FileName: ");

        smallPane.getChildren().addAll(fileNameLabel, textFile, viewButton);

        pane.setBottom(smallPane);
        pane.setMargin(smallPane, new Insets(10,10,10,150));

        viewButton.setOnAction((event) ->
        {
            // gets the file name
            String fileName = textFile.getText();
            Map<String, Integer> newMap = new HashMap<String, Integer>();
            ReadFile lettersFile = new ReadFile(fileName);
            try {
                newMap = lettersFile.countLetters();
            }
            catch (Exception e) {System.out.println("Error in file: " + fileName);}

            // graph the values in the map
            CategoryAxis x = new CategoryAxis();
            NumberAxis y = new NumberAxis();

            BarChart<String,Number> barChart = new BarChart<String, Number>(x,y);
            XYChart.Series dataSeries = new XYChart.Series();

            String letters = "abcdefghijklmnopqrstuvwxyz";
            String l;

            for (int i = 0; i < letters.length(); i++){
                l =  Character.toString(letters.charAt(i));
                if (newMap.get(l) != null)
                    dataSeries.getData().add(new XYChart.Data(l, newMap.get(l)));
                else
                    dataSeries.getData().add(new XYChart.Data(l, 0));
            }
            barChart.setBarGap(0);
            barChart.setLegendVisible(false);
            barChart.getData().add(dataSeries);
            barChart.prefHeight(5);
            VBox graph = new VBox(barChart);
            pane.setCenter(graph);
            pane.setMargin(graph, new Insets(25,0,0,0));
        });

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}