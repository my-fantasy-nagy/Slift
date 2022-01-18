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

    ConstantsFile.InputDirection dirVert;
    ConstantsFile.InputDirection dirHoriz;

    public Grid(PApplet pa, PVector pos, int[] colors,  float cellSize, int numRows, int numCols){
        this.pa = pa;
        this.numCols = numCols;
        this.numRows = numRows;

        indexCols = 0;
        indexRows = 0;

        //INITIALIZE 2D ARRAY OF CELLS AS 1D ARRAY
        for(int y = 0; y < numRows; y ++){
            for(int x = 0; x < numCols; x ++){
                int cellIndex = y * numRows + x;

            //calculate position
                float posX = x * cellSize;
                float posY = y * cellSize;

            //create new cell and add to arrayList
                cells.add(new Cell(pa, new PVector(posX, posY),  cellSize,  0,  255));
            }
        }

        //CREATE NEW SLIDERS FOR TRANSVERSING ROWS AND COLUMNS
        sliderCols = new Slider(COLUMN_RATE);
        sliderRows = new Slider(ROW_RATE);

    }


    public void update(){

        //GET DIRECTIONS OF SLIDERS AND MAP CELLS ON/OFF
        mapCellsToSliders();

        //update cells
        for(Cell cell : cells){
            cell.update();
        }

        //update sliders
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
                int cellIndex = indexCols +i * numRows ;
                cells.get(cellIndex).setDirection(Slider.SliderDirections.FORWARD);
            }
            System.out.println();
        }

        //CASE FOR LEFT
        if(dirHoriz == ConstantsFile.InputDirection.LEFT){
            for(int i = 0; i < numRows; i++){
                int cellIndex = indexCols +i * numCols ;
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

        // LEFT MAPPED TO BACKWARD
        if(dirHoriz == ConstantsFile.InputDirection.LEFT){
            sliderCols.setDirection(Slider.SliderDirections.BACKWARD);
        }

        // RIGHT MAPPED TO FORWARD
        else if(dirHoriz == ConstantsFile.InputDirection.RIGHT){
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

    private void sliderUp() {


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

    //TODO: SHUFFLE GRID
//    public void shuffleColumns(){

//    }

    //TODO: UNSHUFFLE THE GRID
//    public void alignColumns(){

//    }
}
