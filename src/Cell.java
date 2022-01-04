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



    public Cell(PApplet pa, PVector pos, float size, int colorA, int colorB) {
        this.pa = pa;
        this.pos = pos;
        this.size = size;
        this.colorA = colorA;
        this.colorB = colorB;

        slider = new Slider(CELL_RATE);
    }

    public void update(){
        finalFill = pa.lerpColor(colorA, colorB, slider.getPosition());
        pa.fill(finalFill);
        pa.rect(pos.x, pos.y, size, size);
    }


    public void transition(){
        // TODO Make this transition trigger a boolean variable that runs the slider
    }


}


