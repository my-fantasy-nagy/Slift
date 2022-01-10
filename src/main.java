import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

import Constants.Colors;
import processing.core.PApplet;
import processing.core.PVector;




public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

//    Slider slider;
//    Cell cell;
//    Column col;
    Grid grid;
    InputDirection dir;
    int[] colors;

    public void settings() {
        size(WIDE, WIDE);
    }

    public void setup(){
        frameRate(FRAME_RATE);
//        frameRate(5);
        int numCells = (int)(WIDE/CELL_SIZE);
        dir = InputDirection.NONE;
        colors = new int[]{unhex(Colors.SCHOPENHAUERS_JOKE_0), unhex(Colors.SCHOPENHAUERS_JOKE_1)};
        grid = new Grid(this, new PVector(0.0F,0.0F), colors, CELL_SIZE, numCells, numCells);


        System.out.println();
//        noLoop();
    }

    public void draw(){
        background(0);
        grid.update();
        grid.setDirection(dir);

    }

    public void mousePressed() {
//        col.reverseSequential();
    }

    public void keyPressed() {
        switch(key){

            case 'a':
                grid.fadeOn();
                break;

            case 's':
                grid.fadeOff();
                break;

            case 'q':
                grid.shuffleColumns();
                break;

            case 'w':
                grid.alignColumns();
                break;
        }

        switch(keyCode){
            case UP:
                dir = InputDirection.UP;
                break;

            case DOWN:
                dir = InputDirection.DOWN;
                break;

            case RIGHT:
                dir = InputDirection.RIGHT;
                break;

            case LEFT:
                dir = InputDirection.LEFT;
                break;

            default:
                dir = InputDirection.NONE;
                break;
        }
    }

}
