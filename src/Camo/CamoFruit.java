package Camo;

import processing.core.PApplet;
import static Constants.ConstantsFile.*;
import static Constants.Colors.*;

public class CamoFruit {

    float noiseScale = 0.1F;

    public static int[] camo(PApplet pa, int numRows, int numCols, float time) {
        float lim1 = 0.5F;
        float lim2 = 0.6F;

        //initialize array
        int[] colors = new int[numCols * numRows];

        //LOOP THROUGH CELLS
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {

                //SET NOISE DETAIL
                pa.noiseDetail(0, .5F);

                //GET NOISE VALUE
                float noiseVal = pa.noise(x, y, time);

                // RADIAL EFFECT
                float rad = getDistFromCenter(pa, x-WIDE/2, y-HIGH/2, 300);

                //COLOR INTERPOLATION
                int col1 = pa.lerpColor(pa.unhex(SODA_0), pa.unhex(SODA_1), rad);
                int col2 = pa.lerpColor(PApplet.unhex(CIMBOM_0), pa.unhex(CIMBOM_1), 1.0F);
                int col3 = pa.lerpColor(pa.unhex(OLD_GREEN_0), pa.unhex(OLD_GREEN_1), getDistFromCenter(pa,x-WIDE, y-WIDE, 400));
//
                //CELL INDEX
                int cellIndex = y * numRows + x;

                //FILTER COLOR DEPENDING ON NOISE VALUES
                colors[cellIndex] = col1;
                if( noiseVal > lim1){
                    colors[cellIndex] = col2;
                }
                else if(noiseVal >= lim2){
                    colors[cellIndex] = col2;
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
}
