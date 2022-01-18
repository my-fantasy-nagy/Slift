import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

import Camo.CamoFruit;
import Constants.Colors;
import processing.core.PApplet;
import processing.core.PVector;
import static Camo.CamoFruit.*;



//TODO:
// ADD IN WATERMELON
// ADD IN BANANA
// ADD SWITCH BETWEEN COLORS
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
    int[] blueberry;
    int[] watermelon;
    int[] banana;
    boolean[] seeds;
    int numRows;
    int numCols;

    float inc;
    float incRate = 0.0005F;

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

        //set colors
        seeds = CamoFruit.generateSeeds(this, numRows, numCols);
        mango = CamoFruit.mango(this, numRows, numCols, inc);
        blueberry = CamoFruit.blueberry(this, numRows, numCols,inc);
        watermelon = CamoFruit.watermelon(this, numRows, numCols, inc, seeds);
        banana = CamoFruit.banana(this, numRows, numCols, inc);

        grid = new Grid(this, new PVector(0.0F,0.0F), banana, watermelon, CELL_SIZE, numCols, numRows);
//        noLoop();

        inc = 0;
    }

    public void draw(){

        background(0);
        inc += incRate;
        mango = mango(this, numRows, numCols,  inc);
        blueberry = blueberry(this, numRows, numCols, inc);
        watermelon = watermelon(this, numRows, numCols, inc, seeds);
        banana = banana(this, numRows, numCols, inc);
        grid.setDirection(dirHoriz, dirVert);
        grid.setColorA(blueberry);
        grid.setColorB(watermelon);
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
