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

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);

        column = new CellColumn(this,CELL_SIZE,40,new PVector(0,0));

//        cell = new Cell(this, new PVector(0,0), CELL_SIZE, 255, 0);

//        slider = new Slider(CELL_RATE);

    }

    public void draw(){

        background(0);
//        column.fadeInOut();
        column.update();

//        cell.update();

//        slider.update();


    }

    public void mousePressed() {
        column.transition();

//        cell.transition();
    }

}
