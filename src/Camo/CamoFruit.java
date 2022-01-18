package Camo;

import processing.core.PApplet;
import static Constants.ConstantsFile.*;
import static Constants.Colors.*;
import static Constants.ConstantsCamo.*;

public class CamoFruit {

    public static int[] banana(PApplet pa, int numRows, int numCols, float time){
        float noiseScale = BANANA_NOISE_SCALE;
        float lim1 = BANANA_LIM_1;
        float lim2 = BANANA_LIM_2;
        float yStretchRate = BANANA_Y_STRETCH_RATE;

        //initialize array
        int[] colors = new int[numCols * numRows];

        //LOOP THROUGH CELLS
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {

                //SET NOISE DETAIL
                pa.noiseDetail(BANANA_NOISE_LOD, BANANA_NOISE_FALLOFF);

                //GET NOISE VALUE
                float noiseVal = pa.noise(x * BANANA_NOISE_SCALE, y * BANANA_NOISE_SCALE * BANANA_Y_STRETCH_RATE, time);

                //SET X/Y NOISE POSITIONS
                float noise_posX = pa.map(x, ZERO_F, numCols, ZERO_F, ONE_F);
                float noise_posY = pa.map(y, ZERO_F, numRows, ZERO_F, ONE_F);

                //COLOR INTERPOLATION
                int col1 = pa.lerpColor(pa.unhex(SODA_0), pa.unhex(SODA_1), noise_posY);
                int col2 = pa.lerpColor(pa.unhex(BROKEN_GUITAR_0), pa.unhex(BROKEN_GUITAR_1), noise_posX);
                int col3 = pa.lerpColor(col1, col2, noise_posX);
//
                //CELL INDEX
                int cellIndex = x + y * numCols;

                //FILTER COLOR BASED ON NOISE VALUES
                colors[cellIndex] = col1;
                if ( noiseVal >= lim1 && noiseVal < lim2) {
                    colors[cellIndex] = col3;
                }
                else if (noiseVal >= lim2){
                    colors[cellIndex] = col2;
                }
            }
        }
        return colors;
    }

    public static int[] watermelon(PApplet pa, int numRows, int numCols, float time, boolean[] seeds){

        //initialize array
        int[] colors = new int[numCols * numRows];

        //LOOP THROUGH CELLS
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {

                //SET NOISE DETAIL
                pa.noiseDetail(WATERMELON_NOISE_LOD, WATERMELON_NOISE_FALLOFF);

                //GET NOISE VALUE
                float noiseVal = pa.noise(x * WATERMELON_NOISE_SCALE, y * WATERMELON_NOISE_SCALE, time);

                //COLOR INTERPOLATION
                int col1 = pa.unhex(TINSEL_0);
                int col2 = pa.lerpColor(pa.unhex(TINSEL_0), pa.unhex(TINSEL_1), 0.5F);
                int col3 = pa.unhex(TINSEL_1);
                int col4 = BLACK;

                //CELL INDEX
                int cellIndex = x + y * numCols;

                //FILTER COLOR BASED ON NOISE VALUES
                colors[cellIndex] = col1;
                if ( noiseVal > WATERMELON_LIM_1 && noiseVal < WATERMELON_LIM_2) {
                    colors[cellIndex] = col2;
                }
                else if(noiseVal >= WATERMELON_LIM_2){
                    colors[cellIndex] = col3;
                }
                if(seeds[cellIndex] == true){
                    colors[cellIndex] = col4;
                }


            }
        }
        return colors;
    }

    public static int[] mango(PApplet pa, int numRows, int numCols, float time) {
        //TODO: MAKE THESE CONSTANTS

        //initialize array
        int[] colors = new int[numCols * numRows];

        //LOOP THROUGH CELLS
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {

                //SET NOISE DETAIL
                pa.noiseDetail(MANGO_NOISE_LOD, MANGO_NOISE_FALLOFF);

                //GET NOISE VALUE
                float noiseVal = pa.noise(x * MANGO_NOISE_SCALE, y * MANGO_NOISE_SCALE, time);

                // RADIAL EFFECT
                float rad = getDistFromCenter(pa, x-numCols/2, y-numCols/2, 300);

                //COLOR INTERPOLATION
                int col1 = pa.lerpColor(pa.unhex(SODA_0), pa.unhex(SODA_1), rad);
                int col2 = pa.lerpColor(PApplet.unhex(CIMBOM_0), pa.unhex(CIMBOM_1), 1.0F);
                int col3 = pa.lerpColor(pa.unhex(OLD_GREEN_0), pa.unhex(OLD_GREEN_1), getDistFromCenter(pa,x-WIDE, y-WIDE, 400));
//
                //CELL INDEX
                int cellIndex = x + y * numCols;

                //FILTER COLOR BASED ON NOISE VALUES
                colors[cellIndex] = col1;
                if ( noiseVal > MANGO_LIM_1 && noiseVal < MANGO_LIM_2) {
                    colors[cellIndex] = col2;
                }
                else if(noiseVal >= MANGO_LIM_2){
                    colors[cellIndex] = col3;
                }
            }
        }
        return colors;
    }

    public static int[] blueberry(PApplet pa, int numRows, int numCols, float time) {


        //initialize array
        int[] colors = new int[numCols * numRows];

        //LOOP THROUGH CELLS
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {

                //SET NOISE DETAIL
                pa.noiseDetail(BLUEBERRY_NOISE_LOD, BLUEBERRY_NOISE_FALLOFF);

                //GET NOISE VALUE
                float noiseVal = pa.noise(x * BLUEBERRY_NOISE_SCALE, y * BLUEBERRY_NOISE_SCALE, time);

                //SET X/Y NOISE POSITIONS
                float noise_posX = pa.map(x, 0, numCols, 0, 1);
                float noise_posY = pa.map(y, 0, numRows, 0, 1);

                //COLOR INTERPOLATION
                int col1 = pa.lerpColor(pa.unhex(CREATIVE_IDEA_0), pa.unhex(CREATIVE_IDEA_1), noise_posY);
                int col2 = pa.lerpColor(pa.unhex(ELVIS_LATEST_CHECK_IN_0), pa.unhex(ELVIS_LATEST_CHECK_IN_1), noise_posX);
                int col3 = pa.lerpColor(pa.unhex(ANONYMOUS_P_0), pa.unhex(ANONYMOUS_P_1), noise_posX);
//
                //CELL INDEX
                int cellIndex = x + y * numCols;

                //FILTER COLOR BASED ON NOISE VALUES
                colors[cellIndex] = col1;
                if ( noiseVal > BLUEBERRY_LIM_1 && noiseVal < BLUEBERRY_LIM_2) {
                    colors[cellIndex] = col2;
                }
                else if(noiseVal >= BLUEBERRY_LIM_2){
                    colors[cellIndex] = col3;
                }
            }
        }
        return colors;
    }

    public static int[] blackGrid(PApplet pa, int numRows, int numCols){
        int[] black = new int[numCols * numRows];
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {
                int cellIndex = y * numRows + x;
                black[cellIndex] = 0;
            }
        }
        return black;
    }

    private static float getDistFromCenter(PApplet pa, int x, int y, int spread){
        float rad = (float)Math.sqrt(x*x + y*y);
        return pa.map(rad, 0, spread, 0, 1);
    }

    public static boolean[] generateSeeds(PApplet pa, int numRows, int numCols){
        boolean seeds[] = new boolean[numRows * numCols];
        for(int i = 0; i < seeds.length; i ++){
            float roll = pa.random(1.0F);
            if(roll < 0.02){
                seeds[i] = true;
            }
            else{
                seeds[i] = false;
            }
        }
        return seeds;
    }
}
