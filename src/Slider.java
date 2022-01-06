public class Slider {

    float rate;
    float pos;
    boolean forward;
//    PApplet pa;

    public Slider(float rate) {
        this.rate = rate;
        forward = false;
        pos = 0;
    }

    public void update(){

        //check direction and move position accordingly

        if (forward) {
            pos += rate;
        } else {
            pos -= rate;
        }

        //hold position on min/max values
        if(pos >= 1.0){
            pos = 1.0F;
        }
        if(pos <= 0.0){
            pos = 0.0F;
        }
    }

    public void setDirection(boolean dir){
        forward = dir;
    }

    public void setPos(float pos){
        this.pos = pos;
    }

    public void reverseDirection(){
        forward = !forward;
    }
    public float getPosition(){
        return pos;
    }
    public boolean isForward() {return forward;}



}
