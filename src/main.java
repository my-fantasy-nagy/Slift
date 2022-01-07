import static Constants.ConstantsFile.*;
import processing.core.PApplet;
import processing.core.PVector;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

    Slider slider;
//    Cell cell;
//    CellColumn column;
//    Grid grid;
    InputDirection dir;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
//        frameRate(FRAME_RATE);
        frameRate(5);
        int numCells = (int)(WIDE/CELL_SIZE);
        dir = InputDirection.NONE;
        slider = new Slider(CELL_RATE);

    }

    public void draw(){

        background(0);
        slider.update();
        slider.printReadOut();
//      checkInput();
    }

    public void mousePressed() {
        slider.reverseDirection();
    }

//    public void checkInput(){
//

}
