// Author: Malaviya Nerumalan and Vithusan Jeevartnam
// Date: March 5, 2020
// Purpose: To create a GUI that displays three random cards
//***********************************************************************************************************

package sample;

import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane border = new BorderPane();
        HBox pane = new HBox(10);
        border.setMargin(pane, new Insets(5,5,5,5));
        border.setCenter(pane);

        Random rand = new Random();
        int firstCard = rand.nextInt(54) + 1;
        int secondCard = rand.nextInt(54) + 1;
        int thirdCard = rand.nextInt(54) + 1;

        // the image of the first card
        Image card1 = new Image("sample/cardsImages/" + firstCard + ".png");
        ImageView imageCard1 = new ImageView(card1);

        // the image of the second card
        Image card2 = new Image("sample/cardsImages/" + secondCard + ".png");
        ImageView imageCard2 = new ImageView(card2);

        // the image of the third card
        Image card3 = new Image("sample/cardsImages/" + thirdCard + ".png");
        ImageView imageCard3 = new ImageView(card3);

        pane.getChildren().addAll(imageCard1,imageCard2,imageCard3);

        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
