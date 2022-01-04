import static Constants.ConstantsFile.*;
import processing.core.PApplet;


public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

    Slider slider;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);
        slider = new Slider(this, CELL_RATE);
    }

    public void draw(){
        slider.update();
        println(slider.getPosition());
        background(0);

        if(mousePressed){
            slider.reverseDirection();
        }
    }

}
