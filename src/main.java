import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

import Constants.Colors;
import processing.core.PApplet;
import processing.core.PVector;



//TODO:
// ADD IN CAMO FRUIT COLOR ARRAYS
// Shuffle Columns and UnShuffle
// FIX SKIPPED COLUMNS/ROWS WHEN RATE IS TOO FAST
// BUBBLE SORT
// GUI
// CHANGE TO DIFFERENT FRUITS



public class main extends PApplet {


    public static void main(String... args){
        PApplet.main("main");
    }

//    Slider slider;
//    Cell cell;
    Grid grid;
    InputDirection dirHoriz;
    InputDirection dirVert;
    int[] colors;
    String color0 = SHAANAS_PICK_0;
    String color1 = SHAANAS_PICK_1;

    public void settings() {
        size(WIDE, HIGH);
    }

    public void setup(){
        frameRate(FRAME_RATE);
//        frameRate(2);
        int numCols = (int)(HIGH/CELL_SIZE);
        int numRows = (int)(WIDE/CELL_SIZE);
        dirHoriz = InputDirection.NONE;
        dirVert = InputDirection.NONE;
        colors = new int[]{unhex(color0), unhex(color1)};
        grid = new Grid(this, new PVector(0.0F,0.0F), colors, CELL_SIZE, numCols, numRows);

//        noLoop();
    }

    public void draw(){
        background(0);
        grid.setDirection(dirHoriz, dirVert);
        grid.update();


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
//
//            case 'q':
//                grid.shuffleColumns();
//                break;
//
//            case 'w':
//                grid.alignColumns();
//                break;
        }

        switch(keyCode){
            case UP:
                dirVert = InputDirection.UP;
                break;

            case DOWN:
                dirVert = InputDirection.DOWN;
                break;

            case RIGHT:
                dirHoriz = InputDirection.RIGHT;
                break;

            case LEFT:
                dirHoriz = InputDirection.LEFT;
                break;

            default:
                dirVert = InputDirection.NONE;
                dirHoriz = InputDirection.NONE;
                break;
        }
    }

}
