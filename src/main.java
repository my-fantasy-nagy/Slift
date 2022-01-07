import static Constants.ConstantsFile.*;
import processing.core.PApplet;
import processing.core.PVector;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

    Slider slider;
    Cell cell;
    CellColumn column;
    Grid grid;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);
        int numCells = (int)(WIDE/CELL_SIZE);
        grid = new Grid(this, CELL_SIZE, numCells, numCells,new PVector(0,0));

//        column = new CellColumn(this,CELL_SIZE, (int)(WIDE/CELL_SIZE),new PVector(0,0));
//        column.shuffleTriggerOrder();
//        cell = new Cell(this, new PVector(0,0), CELL_SIZE, 255, 0);

//        slider = new Slider(CELL_RATE);

    }

    public void draw(){

        background(0);

        grid.update();

        checkInput();
//        column.fadeInOut();
//        column.update();

//        cell.update();

//        slider.update();
    }

    public void mousePressed() {

        grid.transition();
//        column.transition();

//        cell.setDirection(true);
    }

    public void checkInput(){
        if (keyPressed) {
            if (key == 'a' || key == 'A') {
                grid.shuffleColumns();
//                column.allCellsToOn();
            }
            if (key == 's' || key == 'S') {
                grid.alignColumns();
            }
            if (key == 'd' || key == 'D') {
//                column.allCellsToOff();
            }
        }
    }

}
