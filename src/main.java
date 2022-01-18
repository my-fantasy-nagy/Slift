import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

import Camo.CamoFruit;
import Constants.Colors;
import processing.core.PApplet;
import processing.core.PVector;
import static Camo.CamoFruit.*;



//TODO:
// ADD IN CAMO FRUIT COLOR ARRAYS -- MANGO DONE
// SHUFFLE AND UNSHUFFLE COLUMNS
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
    int[] mango;
    int[] black;
    String color0 = SHAANAS_PICK_0;
    String color1 = SHAANAS_PICK_1;
    int numRows;
    int numCols;
    float inc;
    float incRate = 0.001F;

    public void settings() {
        size(WIDE, HIGH);
    }

    public void setup(){
        frameRate(FRAME_RATE);
//        frameRate(2);
        numCols = (int)(HIGH/CELL_SIZE);
        numRows = (int)(WIDE/CELL_SIZE);
        dirHoriz = InputDirection.NONE;
        dirVert = InputDirection.NONE;

        mango = CamoFruit.camo(this, numRows, numCols, 0);
        black = CamoFruit.blackGrid(this, numRows, numCols);
//        for(int i =0; i < mango.length; i++){
//            println(mango[i]);
//        }

        colors = new int[]{unhex(color0), unhex(color1)};
        grid = new Grid(this, new PVector(0.0F,0.0F), mango, black, CELL_SIZE, numCols, numRows);
//        noLoop();

        inc = 0;
    }

    public void draw(){

        background(0);
        inc += incRate;
        mango = camo(this, grid.numRows, grid.numCols,  inc);
        grid.setDirection(dirHoriz, dirVert);
        grid.setColorA(mango);
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
