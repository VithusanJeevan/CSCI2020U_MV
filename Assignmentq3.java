/*
* Name: Malaviya Nerumalan and Vithusan Jeevaratnam
* Purpose: To create a program which draws a triangle and is able to display the
*          angles inside the triangles as the traingles coordinates are moved
*          along the circumference of the triangle
* Date: March 1st, 2020
* File Name: q3.java


*/
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Assignmentq3 extends Application{

  private Circle circle = new Circle(200,200,100); // The main circle where the traingle is drawn along
  private Circle[] cir = new Circle[3]; // three points along the circle
  private Line lin1 = new Line(); // is the line connecting the point
  private Text text1 = new Text(); // used to display the angle at a given point
  private Line lin2 = new Line();
  private Text text2 = new Text();
  private Line lin3 = new Line();
  private Text text3 = new Text();


  public void start(Stage primaryStage){
    Pane pane = new Pane();

    // For loop is used to randomly assign the points on the circumference of the circle
    // and also, controls the point to move along the circumference of the circle
    for(int a = 0 ; a <cir.length; a++){
      cir[a] = new Circle(0,0,5);
      cir[a].setFill(Color.RED);
      double ran = Math.random()*360;
      double x = circle.getCenterX()+circle.getRadius()*Math.cos(Math.toDegrees(ran));
      double y = circle.getCenterY()+circle.getRadius()*Math.sin(Math.toDegrees(ran));
      cir[a].setCenterX(x);
      cir[a].setCenterY(y);
      final int ref = a;

      // event handler for the mouse allowing the point to be always moved back
      // to the circumference of the circle instead of anywhere on the pane
      cir[a].setOnMouseDragged(e->{
        double radVal = Math.atan2(e.getY()-circle.getCenterY(),e.getX()-circle.getCenterX());
        double xLoc = circle.getCenterX()+circle.getRadius()*Math.cos(radVal);
        double yLoc = circle.getCenterY()+circle.getRadius()*Math.sin(radVal);
        cir[ref].setCenterX(xLoc);
        cir[ref].setCenterY(yLoc);
        setLines();

      });
    }
    setLines();
    // adds all the indiviual components to the pane
    pane.getChildren().addAll(cir[0],lin1,text1,cir[1],lin2,text2,cir[2],lin3,text3);
    pane.getChildren().add(circle);
    circle.setStroke(Color.BLACK);

    Scene scene = new Scene(pane,400,400);
    primaryStage.setTitle("Question 3");
    primaryStage.setScene(scene);
    primaryStage.show();

  }
    /*
    *Parameters: N/a
    *Return: N/a
    *Purpose: used to connect the points and calculate the angles that is to be displayed
    */
    private void setLines(){
      lin1.setStartX(cir[0].getCenterX());
      lin1.setStartY(cir[0].getCenterY());
      lin1.setEndX(cir[1].getCenterX());
      lin1.setEndY(cir[1].getCenterY());
      lin2.setStartX(cir[0].getCenterX());
      lin2.setStartY(cir[0].getCenterY());
      lin2.setEndX(cir[2].getCenterX());
      lin2.setEndY(cir[2].getCenterY());
      lin3.setStartX(cir[1].getCenterX());
      lin3.setStartY(cir[1].getCenterY());
      lin3.setEndX(cir[2].getCenterX());
      lin3.setEndY(cir[2].getCenterY());

      // used to calculate the distance of each line that connects the points
      double a = Math.sqrt((lin1.getStartX()-lin1.getEndX())*
      (lin1.getStartX()-lin1.getEndX())+(lin1.getStartY()-lin1.getEndY())
      *(lin1.getStartY()-lin1.getEndY()));

      double b = Math.sqrt((lin2.getStartX()-lin2.getEndX())*
      (lin2.getStartX()-lin2.getEndX())+(lin2.getStartY()-lin2.getEndY())
      *(lin2.getStartY()-lin2.getEndY()));

      double c = Math.sqrt((lin3.getStartX()-lin3.getEndX())*
      (lin3.getStartX()-lin3.getEndX())+(lin3.getStartY()-lin3.getEndY())
      *(lin3.getStartY()-lin3.getEndY()));

      // used to calculate the angles using cosine law
      double angleA = Math.acos((a*a-b*b-c*c)/(-2*b*c));
      double angleB = Math.acos((b*b-a*a-c*c)/(-2*a*c));
      double angleC = Math.acos((c*c-b*b-a*a)/(-2*a*b));

      // displays the angle on the pane
      text1.setX(cir[0].getCenterX()+5);
      text1.setY(cir[0].getCenterY()-5);
      text1.setText(String.format("%.2f",Math.toDegrees(angleA)));

      text2.setX(cir[1].getCenterX()+5);
      text2.setY(cir[1].getCenterY()-5);
      text2.setText(String.format("%.2f",Math.toDegrees(angleB)));

      text3.setX(cir[2].getCenterX()+5);
      text3.setY(cir[2].getCenterY()-5);
      text3.setText(String.format("%.2f",Math.toDegrees(angleC)));


    }


  public static void main(String[] args) {
   launch(args);
 }
}
