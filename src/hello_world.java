import processing.core.PApplet;

public class hello_world extends PApplet {

    public static void main(String... args){
        PApplet.main("hello_world");
    }

    Ellipse e;

    public void settings(){
        size(200, 200);
    }

    public void setup(){
//        e = new Ellipse(this, mouseX, mouseY);
    }

    public void draw(){
        background(0);
//        e.update(mouseX, mouseY);

    }
}
