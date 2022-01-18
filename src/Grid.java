import Constants.ConstantsFile;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;

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

    ConstantsFile.InputDirection dir;

    public Grid(PApplet pa, PVector pos, int[] colors,  float cellSize, int numRows, int numCols){
        this.pa = pa;
        this.numCols = numCols;
        this.numRows = numRows;

        indexCols = 0;
        indexRows = 0;

        //INITIALIZE 2D ARRAY OF CELLS AS 1D ARRAY
        for(int y = 0; y < numCols; y ++){
            for(int x = 0; x < numRows; x ++){
                int cellIndex = y * numRows + x;
                System.out.println("Index: " + cellIndex);

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
        //SET INDEX OF CELLS TO MATCH SLIDER POSITION
        indexCols = pa.floor(sliderCols.getPosition()* (numCols-1));
        indexRows = pa.floor(sliderRows.getPosition()* (numRows-1));

        //TODO: CHECK DIRECTION AND UPDATE CELLS ACCORDINGLY


        //update cells
        for(Cell cell : cells){
            cell.update();
        }

        //update sliders
        sliderRows.update();
        sliderCols.update();




    }

    public void setDirection(ConstantsFile.InputDirection dir){
        this.dir = dir;
        switch(dir){
            case UP:
                sliderUp();
                break;

            case DOWN:
                sliderDown();
                break;

            case RIGHT:
                sliderRight();
                break;
//
            case LEFT:
                sliderLeft();
                break;

            case NONE:
                break;
        }
    }

    private void sliderUp() {
        // UP MAPPED TO BACKWARD
        sliderRows.setDirection(Slider.SliderDirections.BACKWARD);
    }
//
    private void sliderDown(){
        // DOWN MAPPED TO FORWARD
        sliderRows.setDirection(Slider.SliderDirections.FORWARD);
    }
//
    private void sliderRight(){
        // RIGHT MAPPED TO FORWARD
        sliderCols.setDirection(Slider.SliderDirections.FORWARD);
    }

    private void sliderLeft(){
        // LEFT MAPPED TO BACKWARD
        sliderRows.setDirection(Slider.SliderDirections.BACKWARD);
    }
//
//    public void fadeOn() {
//        for(Column col: cols){
//            col.fadeOn();
//        }
//    }
//
//    public void fadeOff() {
//        for(Column col: cols){
//            col.fadeOff();
//        }
//    }
//
//    public void shuffleColumns(){
//
//        if(dir == ConstantsFile.InputDirection.NONE){
//            System.out.println("SHUFFLED");
//            for(Column column: cols){
//                column.shuffleTriggerOrder();
//            }
//        }
//        else{
//            System.out.println("CANNOT SHUFFLE");
//        }
//    }
//
//    public void alignColumns(){
//        if(dir == ConstantsFile.InputDirection.NONE) {
//            System.out.println("ALIGNED");
//            for (Column column : cols) {
//                column.alignTriggerOrder();
//            }
//        }
//        else{
//            System.out.println("CANNOT ALIGN");
//        }
//    }
}
