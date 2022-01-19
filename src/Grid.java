import Constants.ConstantsFile;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;

import static Constants.ConstantsFile.COLUMN_RATE;
import static Constants.ConstantsFile.ROW_RATE;

public class Grid {
    PApplet pa;
    ArrayList<Cell> cells = new ArrayList<>();
    IntList triggerOrder;
    Slider sliderRows;
    Slider sliderCols;
    int numCols;
    int numRows;
    int indexRows;
    int indexCols;
    int[] colorsOn;
    int[] colorOff;

    ConstantsFile.InputDirection dirVert;
    ConstantsFile.InputDirection dirHoriz;

    public Grid(PApplet pa, PVector pos, int[] colorsOn, int[] colorsOff,  float cellSize, int numRows, int numCols){
        this.pa = pa;
        this.numCols = numCols;
        this.numRows = numRows;
        this.colorsOn = colorsOn;
        this.colorOff = colorsOff;

        indexCols = 0;
        indexRows = 0;

        //INITIALIZE 2D ARRAY OF CELLS AS 1D ARRAY
        for(int y = 0; y < numRows; y ++){
            for(int x = 0; x < numCols; x ++){
                int cellIndex = x + y * numCols;

            //calculate position
                float posX = x * cellSize;
                float posY = y * cellSize;

            //create new cell and add to arrayList
                cells.add(new Cell(pa, new PVector(posX, posY),  cellSize,  colorsOn[cellIndex],colorsOff[cellIndex]));
            }
        }

        //CREATE NEW SLIDERS FOR TRANSVERSING ROWS AND COLUMNS
        sliderCols = new Slider(COLUMN_RATE);
        sliderRows = new Slider(ROW_RATE);

    }


    public void update(){

        //UPDATE CELLS
        for(Cell cell : cells){
            cell.update();
        }

        //GET DIRECTIONS OF SLIDERS AND MAP CELLS ON/OFF
        mapCellsToSliders();

        //UPDATE SLIDERS
        sliderRows.update();
        sliderCols.update();
    }

    private void mapCellsToSliders(){



        //SET INDEX OF CELLS TO MATCH SLIDER POSITION
        indexCols = pa.floor(sliderCols.getPosition()* (numCols-1));
        indexRows = pa.floor(sliderRows.getPosition()* (numRows-1));

        //CASE FOR RIGHT
        if(dirHoriz == ConstantsFile.InputDirection.RIGHT){
            for(int i = 0; i <numRows; i++){
                    int cellIndex = indexCols + i * numRows;
                    cells.get(cellIndex).setDirection(Slider.SliderDirections.FORWARD);
                    if(cellIndex == numRows * numCols - 1){
                    }

            }
        }

        //CASE FOR LEFT
        if(dirHoriz == ConstantsFile.InputDirection.LEFT){
            for(int i = 0; i < numRows; i++) {
                int cellIndex = indexCols + i * numCols;
                cells.get(cellIndex).setDirection(Slider.SliderDirections.BACKWARD);
            }
        }

        //CASE FOR DOWN
        if(dirVert == ConstantsFile.InputDirection.DOWN){
            for(int i = 0; i < numCols; i++){
                int cellIndex = indexRows * numCols + i;
                cells.get(cellIndex).setDirection(Slider.SliderDirections.FORWARD);
            }
        }

        //CASE FOR UP{
        if(dirVert == ConstantsFile.InputDirection.UP){
            for(int i = 0; i < numCols; i++){
                int cellIndex = indexRows * numCols + i;
                cells.get(cellIndex).setDirection(Slider.SliderDirections.BACKWARD);
            }
        }


    }

    public void setDirection(ConstantsFile.InputDirection dirHoriz, ConstantsFile.InputDirection dirVert ){

        this.dirHoriz = dirHoriz;
        this.dirVert = dirVert;

        if(sliderRows.getState() == Slider.SliderState.OFF || sliderRows.getState() == Slider.SliderState.ON){
            this.dirVert = ConstantsFile.InputDirection.NONE;
        }

        if(sliderCols.getState() == Slider.SliderState.OFF || sliderCols.getState() == Slider.SliderState.ON){
            this.dirHoriz = ConstantsFile.InputDirection.NONE;
        }

        // LEFT MAPPED TO BACKWARD
        if (dirHoriz == ConstantsFile.InputDirection.LEFT) {
            sliderCols.setDirection(Slider.SliderDirections.BACKWARD);
        }


        // RIGHT MAPPED TO FORWARD
        if(dirHoriz == ConstantsFile.InputDirection.RIGHT){
            sliderCols.setDirection(Slider.SliderDirections.FORWARD);
        }


        // UP MAPPED TO BACKWARD
        if(dirVert == ConstantsFile.InputDirection.UP){
            sliderRows.setDirection(Slider.SliderDirections.BACKWARD);
        }

        // DOWN MAPPED TO FORWARD
        else if(dirVert == ConstantsFile.InputDirection.DOWN){
            sliderRows.setDirection(Slider.SliderDirections.FORWARD);
        }


    }

    public void fadeOn() {
        for(Cell cell : cells){
            cell.forward();
        }
    }

    public void fadeOff() {
        for(Cell cell: cells){
            cell.backward();
        }
    }

    public void setColorA(int[] colors){
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {
                int cellIndex = x + y * numCols;
                cells.get(cellIndex).setColorOn(colors[cellIndex]);
            }
        }
    }

    public void setColorB(int[] colors){
        for(int y = 0; y < numRows; y ++) {
            for (int x = 0; x < numCols; x++) {
                int cellIndex = x + y * numCols;
                cells.get(cellIndex).setColorOff(colors[cellIndex]);
            }
        }
    }

    //TODO: SHUFFLE GRID
//    public void shuffleColumns(){

//    }

    //TODO: UNSHUFFLE THE GRID
//    public void alignColumns(){

//    }
}
