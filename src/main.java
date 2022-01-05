import static Constants.ConstantsFile.*;
import processing.core.PApplet;
import processing.core.PVector;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

    Slider slider;
    Cell cell;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);

//        slider = new Slider(CELL_RATE);
        cell = new Cell(this, new PVector(0,0), CELL_SIZE, 255, 0);
    }

    public void draw(){
        background(0);
        cell.update();

//        slider.update();
//        println(slider.getPosition());


    }


    public void mousePressed() {
        cell.transition();
    }

}
