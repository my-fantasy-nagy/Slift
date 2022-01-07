import static Constants.ConstantsFile.*;
import processing.core.PApplet;
import processing.core.PVector;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

    Slider slider;
    Cell cell;
//    CellColumn column;
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
        cell = new Cell(this, new PVector(0,0), CELL_SIZE, 255, 0);

    }

    public void draw(){

        background(0);
        cell.update();

    }

    public void mousePressed() {
        cell.reverse();
    }



    public void keyPressed() {
        if (key == 'p') {

        }
        if (key == 'r'){

        }
    }

}
