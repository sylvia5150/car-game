import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Car_Game extends PApplet {

int xPos=250; //user car
int yPos=400; 
int x = ((xPos+(xPos+50))/2);
int y = ((yPos+(yPos+50))/2);

int xMPos1=0; // blue car
int yMPos1=0;

int xMPos2=0; // yellow car
int yMPos2=0;

int xMPos3=0; // green car
int yMPos3=0;

int xMPos4=0; // purple car 
int yMPos4=300;

boolean GameOver = false;

public void setup(){
  
  frameRate(30);
}

public void draw(){
  background(0xffd6d3d0);
  drawCar();
  drawAllMovingCars();
  collision();
}

public void drawCar(){ //user car
  fill(0xffffffff);
  quad(xPos,yPos,(xPos+50),yPos,(xPos+50),(yPos+50),xPos,(yPos+50));
  /*fill(#5cacf2);*/ 
  ellipse((xPos+10),(yPos+50),20,20);
  ellipse((xPos+40),(yPos+50),20,20);
  if (yPos < 0){
    background(0xff121212);
    textSize(40);
    text("YOU WIN!",150,250);
    text("Click to play again",50,350); 
  }
  // Make sure car does not go too far away off screen
  if (xPos < 0) {xPos = 0;}
  if (xPos >= width){xPos = width - 50;}
  
}

public void collision(){
  int XcenterOfUserCar = xPos + 25;
  int YcenterOfUserCar = yPos + 25;
  
  int XcenterOfBlueCar = xMPos1 + 25;
  int YcenterOfBlueCar = yMPos1 + 25;
  
  int XcenterOfYellowCar = xMPos2 + 25;
  int YcenterOfYellowCar = yMPos2 + 25;
  
  int XcenterOfGreenCar = xMPos3 + 25;
  int YcenterofGreenCar = yMPos3 + 25;
  
  int XcenterOfPurpleCar = xMPos4 + 25;
  int YcenterOfPurpleCar = yMPos4 + 25;
  /* collide with blue car */
  // print(xPos, xMPos4, yPos, yMPos4, "\n"); //output for debugging
  if ( (( (xPos >= xMPos4) && (xPos <= xMPos4 + 40)) || ( (xMPos4 >= xPos) && (xMPos4 <= xPos + 40))) && (yMPos4 == yPos)){
    print("They collided"); // output for debugging
    GameOver = true;
  }
  if (GameOver){
    background(0xff121212);
    textSize(40);
    text("YOU LOSE!",150,250);
    text("Click to play again",50,350);
  }
}

public void drawAllMovingCars(){
    fill(0xff618eed); //blue
  quad(xMPos1,yMPos1,(xMPos1+50),yMPos1,(xMPos1+50),(yMPos1+50),xMPos1,(yMPos1+50));
  ellipse((xMPos1+40),(yMPos1+50),20,20);
  ellipse((xMPos1+10),(yMPos1+50),20,20);
  xMPos1=xMPos1+6;
  if (xMPos1 > width){
    xMPos1=0; 
  } 
   fill(0xfff4f74a);//yellow
  quad(xMPos2,(yMPos2+100),(xMPos2+50),(yMPos2+100),(xMPos2+50),(yMPos2+150),xMPos2,(yMPos2+150));
  ellipse((xMPos2+40),(yMPos2+150),20,20);
  ellipse((xMPos2+10),(yMPos2+150),20,20);
  xMPos2=xMPos2+5;
  if (xMPos2 > width){
    xMPos2=0;
  }
   fill(0xff2cb320);//green
  quad(xMPos3,(yMPos3+200),(xMPos3+50),(yMPos3+200),(xMPos3+50),(yMPos3+250),xMPos3,(yMPos3+250));
  ellipse((xMPos3+40),(yMPos3+250),20,20);
  ellipse((xMPos3+10),(yMPos3+250),20,20);
  xMPos3=xMPos3+4;
  if (xMPos3 > width){
    xMPos3=0;
  }
   fill(0xffbb84e3);//purple
  quad(xMPos4,(yMPos4),(xMPos4+50),(yMPos4),(xMPos4+50),(yMPos4+50),xMPos4,(yMPos4+50));
  ellipse((xMPos4+40),(yMPos4+50),20,20);
  ellipse((xMPos4+10),(yMPos4+50),20,20);
  xMPos4=xMPos4+3;
  if (xMPos4 > width){
    xMPos4=0;
  }
}
public void keyPressed(){
  if (keyCode == UP){
    yPos -= 50;
  }
  else if (keyCode == DOWN) {
    yPos += 50;
  }
  else if (keyCode == LEFT) {
    xPos -= 50;
  }  
  else if (keyCode == RIGHT) {
    xPos += 50;
  }
}

public void mouseClicked(){
  background(0xffd6d3d0);
  yPos=450;
  xPos=250; 
  xMPos1=0;
  yMPos1=0;
  xMPos2=0;
  yMPos2=0;
  xMPos3=0;
  yMPos3=0;
  xMPos4=0;
  yMPos4=300;
  GameOver = false;
}
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Car_Game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
