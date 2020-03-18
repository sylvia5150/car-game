int xPos=250; //user car
int yPos=400; 
int x = ((xPos+(xPos+50))/2);
int y = ((yPos+(yPos+50))/2);

int xMPos1=0; // blue car
int yMPos1=0;

int xMPos2=0; // yellow car
int yMPos2=100;

int xMPos3=0; // green car
int yMPos3=200;

int xMPos4=0; // purple car 
int yMPos4=300;

boolean GameOver = false;

void setup(){
  size(500,500);
  frameRate(30);
}

void draw(){
  background(#d6d3d0);
  drawCar();
  drawAllMovingCars();
  collision();
}

void drawCar(){ //user car
  fill(#ffffff);
  quad(xPos,yPos,(xPos+50),yPos,(xPos+50),(yPos+50),xPos,(yPos+50));
  /*fill(#5cacf2);*/ 
  ellipse((xPos+10),(yPos+50),20,20);
  ellipse((xPos+40),(yPos+50),20,20);
  if (yPos < 0){
    background(#121212);
    textSize(40);
    text("YOU WIN!",150,250);
    text("Click to play again",50,350); 
  }
  // Make sure car does not go too far away off screen
  if (xPos < 0) {xPos = 0;}
  if (xPos >= width){xPos = width - 50;}
}

void collision(){
  /* collide with purple car */
  // print(xPos, xMPos4, yPos, yMPos4, "\n"); //output for debugging
  if ( (( (xPos >= xMPos4) && (xPos <= xMPos4 + 40)) || ( (xMPos4 >= xPos) && (xMPos4 <= xPos + 40))) && (yMPos4 == yPos)){
    print("They collided - purple"); // output for debugging
    GameOver = true;
  }
  
   if ( (( (xPos >= xMPos3) && (xPos <= xMPos3 +40)) || ( (xMPos3 >= xPos) && (xMPos3 <= xPos +40))) && (yMPos3 == yPos)){
    print("They collided - green"); // output for debugging
    GameOver = true;
  }
     if ( (( (xPos >= xMPos2) && (xPos <= xMPos2 +40)) || ( (xMPos2 >= xPos) && (xMPos2 <= xPos +40))) && (yMPos2 == yPos)){
    print("They collided - yellow"); // output for debugging
    GameOver = true;
  }
  
     if ( (( (xPos >= xMPos1) && (xPos <= xMPos1 +40)) || ( (xMPos1 >= xPos) && (xMPos1 <= xPos +40))) && (yMPos1 == yPos)){
    print("They collided - blue"); // output for debugging
    GameOver = true;
  }
  
  if (GameOver){
    background(#121212);
    textSize(40);
    text("YOU LOSE!",150,250);
    text("Click to play again",50,350);
  }
}

void drawAllMovingCars(){
    fill(#618eed); //blue
  quad(xMPos1,yMPos1,(xMPos1+50),yMPos1,(xMPos1+50),(yMPos1+50),xMPos1,(yMPos1+50));
  ellipse((xMPos1+40),(yMPos1+50),20,20);
  ellipse((xMPos1+10),(yMPos1+50),20,20);
  xMPos1=xMPos1+6;
  if (xMPos1 > width){
    xMPos1=0; 
  } 
   fill(#f4f74a);//yellow
  quad(xMPos2,(yMPos2),(xMPos2+50),(yMPos2),(xMPos2+50),(yMPos2+50),xMPos2,(yMPos2+50));
  ellipse((xMPos2+40),(yMPos2+50),20,20);
  ellipse((xMPos2+10),(yMPos2+50),20,20);
  xMPos2=xMPos2+5;
  if (xMPos2 > width){
    xMPos2=0;
  }
   fill(#2cb320);//green
  quad(xMPos3,(yMPos3),(xMPos3+50),(yMPos3),(xMPos3+50),(yMPos3+50),xMPos3,(yMPos3+50));
  ellipse((xMPos3+40),(yMPos3+50),20,20);
  ellipse((xMPos3+10),(yMPos3+50),20,20);
  xMPos3=xMPos3+4;
  if (xMPos3 > width){
    xMPos3=0;
  }
   fill(#bb84e3);//purple
  quad(xMPos4,(yMPos4),(xMPos4+50),(yMPos4),(xMPos4+50),(yMPos4+50),xMPos4,(yMPos4+50));
  ellipse((xMPos4+40),(yMPos4+50),20,20);
  ellipse((xMPos4+10),(yMPos4+50),20,20);
  xMPos4=xMPos4+3;
  if (xMPos4 > width){
    xMPos4=0;
  }
}
void keyPressed(){
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

void mouseClicked(){
  background(#d6d3d0);
  yPos=450;
  xPos=250; 
  xMPos1=0;
  yMPos1=0;
  xMPos2=0;
  yMPos2=100;
  xMPos3=0;
  yMPos3=200;
  xMPos4=0;
  yMPos4=300;
  GameOver = false;
}
