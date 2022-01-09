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
        switch(key){
            //all cells on
            case 'a':
                col.allCellsToOn();
                break;
            //all cells off
            case 's':
                col.allCellsToOff();
                break;

            case 'q':
                col.reverseAll();
                break;

            case 'w':
                col.reverseSequential();
                break;
        }

        switch(keyCode){
            case UP:
                col.sequentialUp();
                break;

            case DOWN:
                col.sequentialDown();
                break;

            case RIGHT:
                break;

            case LEFT:
                break;

            default:
                break;


        }
    }

}
