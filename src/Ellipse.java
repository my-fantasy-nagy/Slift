import processing.core.PApplet;

public class Ellipse {

    PApplet pa;

    Ellipse(PApplet pa, float posX, float posY){

        this.pa = pa;

    }

    void update(float posX, float posY){
        pa.ellipse(posX, posY, 20, pa.random(20));
    }
}
