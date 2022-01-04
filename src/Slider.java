import processing.core.PApplet;

public class Slider {

    double rate;
    double pos;
    boolean forward;
    boolean pause;
    PApplet pa;

    public Slider(PApplet pa, double rate) {
        this.rate = rate;
        this.pa = pa;
        forward = true;
        pause = false;
        pos = 0;
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

        //hold position on min/max values
        if(pos >= 1.0){
            pos = 1.0;
        }
        if(pos <= 0.0){
            pos = 0.0;
        }
    }

    public void reverseDirection(){
        forward = !forward;
    }
    public double getPosition(){
        return pos;
    }
}
