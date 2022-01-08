import processing.core.PApplet;
import processing.core.PVector;

import static Constants.ConstantsFile.CELL_RATE;

public class Cell {
    PApplet pa;
    PVector pos;
    Slider slider;
    float size;
    int colorA;
    int colorB;
    int finalFill = 0;
    boolean trans;

    public Cell(PApplet pa, PVector pos, float size, int colorA, int colorB) {
        this.pa = pa;
        this.pos = pos;
        this.size = size;
        this.colorA = colorA;
        this.colorB = colorB;
        trans = false;
        slider = new Slider(CELL_RATE);
    }

    public void update(){
        finalFill = pa.lerpColor(colorA, colorB, slider.getPosition());
        pa.fill(finalFill);
        pa.rect(pos.x, pos.y, size, size);
        slider.update();
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


