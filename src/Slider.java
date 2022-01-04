import processing.core.PApplet;

public class Slider {

    double rate;
    double max;
    double min;
    double pos;
    int intPos;
    boolean forward;

    public Slider(double rate, double max, double min) {
        this.rate = rate;
        this.max = max;
        this.min = min;
        forward = true;
        pos = min;
        intPos = (int)pos;

    }

    public void update(){

    }
}
