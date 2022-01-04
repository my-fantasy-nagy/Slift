import processing.core.PApplet;

public class Slider {

    double rate;
    double max;
    double min;
    double pos;
    int intPos;
    boolean forward;
    boolean pause;

    public Slider(double rate, double max, double min) {
        this.rate = rate;
        this.max = max;
        this.min = min;
        forward = true;
        pause = false;
        pos = min;
        intPos = (int)pos;
    }

    public void update(){

        //check direction and move position accordingly
        if(!pause) {
            if (forward) {
                pos += rate;
            } else {
                pos -= rate;
            }
        }

        if(pos >= max){
            pos = max;
        }

        if(pos <= min){
            pos = min;
        }
    }

    public void reverseDirection(){
        forward = !forward;
    }
    public double getPosition(){
        return pos;
    }
}
