import static Constants.ConstantsFile.*;
import processing.core.PApplet;
import processing.core.PVector;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

//    Slider slider;
//    Cell cell;
    Column col;
//    Grid grid;
    InputDirection dir;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);
//        frameRate(5);
        int numCells = (int)(WIDE/CELL_SIZE);
        dir = InputDirection.NONE;
        col = new Column(this, new PVector(0,0), CELL_SIZE, numCells);

    }

    public void draw(){
        background(0);
        col.update();

    }

    public void mousePressed() {
        col.reverseSequential();
    }


    public void keyPressed() {
        if (key == 'p') {

        }
        if (key == 'r'){

        }
    }

}
