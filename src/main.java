import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

import Camo.CamoFruit;
import Constants.Colors;
import SortingAlgorithms.BubbleSort;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;

import static Camo.CamoFruit.*;
import static SortingAlgorithms.BubbleSort.*;



//TODO:
// ADD SWITCH BETWEEN COLORS
// SHUFFLE AND UNSHUFFLE COLUMNS
// FIX SKIPPED COLUMNS/ROWS WHEN RATE IS TOO FAST
// BUBBLE SORT
// SIMPLE GUI
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
    int[][]fruits;
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

        //SET COLORS
        seeds = CamoFruit.generateSeeds(this, numRows, numCols);
        fruits = new int[NUM_FRUITS][numRows * numCols];
        fruits[MANG0] = CamoFruit.mango(this, numRows, numCols, inc);
        fruits[BLUEBERRY] = CamoFruit.blueberry(this, numRows, numCols,inc);
        fruits[WATERMELON] = CamoFruit.watermelon(this, numRows, numCols, inc, seeds);
        fruits[BANANA] = CamoFruit.banana(this, numRows, numCols, inc);

        //INITIALIZE CELL GRID
        grid = new Grid(this, new PVector(ZERO_F,ZERO_F), fruits[0], fruits[1], CELL_SIZE, numCols, numRows);
//        noLoop();

        inc = 0;


    }

    public void draw(){

        background(BLACK);
        inc += incRate;
        fruits[MANG0] = mango(this, numRows, numCols,  inc);
        fruits[BLUEBERRY] = blueberry(this, numRows, numCols, inc);
        fruits[WATERMELON] = watermelon(this, numRows, numCols, inc, seeds);
        fruits[BANANA] = banana(this, numRows, numCols, inc);
        grid.setDirection(dirHoriz, dirVert);
        grid.setColorA(fruits[1]);
        grid.setColorB(fruits[2]);
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
