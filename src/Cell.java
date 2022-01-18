import processing.core.PApplet;
import processing.core.PVector;

import static Constants.ConstantsFile.CELL_RATE;

public class Cell {
    PApplet pa;
    PVector pos;
    Slider slider;
    float size;
    int colorOn;
    int colorOff;
    int finalFill = 0;
    boolean trans;

    public Cell(PApplet pa, PVector pos, float size, int colorOn, int colorOff) {
        this.pa = pa;
        this.pos = pos;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        trans = false;
        slider = new Slider(CELL_RATE);
    }

    public void update(){
        finalFill = pa.lerpColor(colorOn, colorOff, slider.getPosition());
        pa.fill(finalFill);
        pa.stroke(255);
        pa.noStroke();
        pa.rect(pos.x, pos.y, size, size);
        slider.update();
    }


    public void setColorOn(int newCol){
        colorOn = newCol;
    }

    public void setColorOff(int newCol){
        colorOff = newCol;
    }

    public void reverse(){
        slider.reverseDirection();
    }

    public void forward(){
        slider.setDirection(Slider.SliderDirections.FORWARD);
    }

    public void setDirection(Slider.SliderDirections dir) {
        slider.setDirection(dir);
    }

    public void setState(Slider.SliderState state){
        slider.setState(state);
    }

    public void setCellPos(float pos){
        slider.setPos(pos);
    }

    public void switchColors(){
        int tempColor = colorOn;
        colorOn = colorOff;
        colorOff = tempColor;
    }

    public Slider.SliderState getState(){
        return slider.getState();
    }
    public void backward(){
        slider.setDirection(Slider.SliderDirections.BACKWARD);
    }

    public void on(){
        slider.setState(Slider.SliderState.ON);
    }

    public void off(){
        slider.setState(Slider.SliderState.OFF);
    }

    public void pause(){
        slider.pause();
    }

    public void resume(){
        slider.resume();
    }



}


