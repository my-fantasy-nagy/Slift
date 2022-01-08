public class Slider {

    public enum SliderState {
        OFF,
        ON,
        TRANS
    }

    public enum SliderDirections{
        FORWARD,
        BACKWARD,
    }

    float rate;
    float pos;
    boolean pause;
    SliderState state;
    SliderDirections dir;


    public Slider(float rate) {
        this.rate = rate;
        pos = 0.0F;
        pause = false;
        state = SliderState.OFF;
        dir = SliderDirections.BACKWARD;
    }

    public void update(){
        if(!pause) {
            //check direction and move position accordingly
            switch (dir) {

                case FORWARD:
                    //increment slider position
                    pos += rate;

                    //check edge position and set val/direction
                    if (pos >= 1.0) {
                        pos = 1.0F;
                        state = SliderState.ON;
                    } else {
                        state = SliderState.TRANS;
                    }
                    break;

                case BACKWARD:

                    //decrement slider position
                    pos -= rate;

                    //check edge position and set val/direction
                    if (pos <= 0.0) {
                        pos = 0.0F;
                        state = SliderState.OFF;
                    } else {
                        state = SliderState.TRANS;
                    }
                    break;
            }
        }
    }

    public void setDirection(SliderDirections dir){
        this.dir = dir;
    }

    public void setState(SliderState state) {
        if(state == SliderState.ON){
            pos = 1.0F;
        }else if(state == SliderState.OFF){
            pos = 0.0F;
        }
        this.state = state;
    }

    public void setPos(float pos){
        this.pos = pos;
    }

    public void setRate(float rate){
        this.rate = rate;
    }

    public void reverseDirection() {
        if (dir == SliderDirections.FORWARD) {
            dir = SliderDirections.BACKWARD;
        } else if (dir == SliderDirections.BACKWARD) {
            dir = SliderDirections.FORWARD;
        }
    }

    public float getPosition(){
        return pos;
    }



    public SliderState getState(){
        return state;
    }

    public SliderDirections getDirection(){
        return dir;
    }
    public void pause(){
        pause = true;
    }

    public void resume(){
        pause = false;
    }

    public void printReadOut(){
        System.out.println("SLIDER_POS: " + pos +
                ".....SLIDER_DIR: " + dir +
                ".....SLIDER_STATE: " + state
        );
    }

}
