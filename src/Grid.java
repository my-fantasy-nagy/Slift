import Constants.ConstantsFile;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;

import java.util.ArrayList;

import static Constants.ConstantsFile.ROW_RATE;

public class Grid {
    PApplet pa;
    ArrayList<Column> cols = new ArrayList<>();
    IntList triggerOrder;
    Slider slider;
    int numColumns;
    int index;

    ConstantsFile.InputDirection dir;

    public Grid(PApplet pa, PVector pos, int[] colors,  float cellSize, int numCells, int numColumns){
        this.pa = pa;
        this.numColumns = numColumns;

        index = 0;

        //create intList to determine display order
        triggerOrder = new IntList();

        //Slider for transversing the column
        slider = new Slider(ROW_RATE);

        for(int i = 0; i < numColumns; i++){

            //calculate position
            float posX = i * cellSize + pos.y;;
            float posY = pos.x;

            // create new column
            cols.add(new Column(pa, new PVector(posX, posY), colors, cellSize, numCells));

            //populate trigger order in increasing numerical order
            triggerOrder.append(i);
        }
    }

    public void update(){
        //set the index and constrain to number of cells.
        index = (int) pa.map(slider.getPosition(), 0.0F, 1.0F, 0.0F, numColumns);
        index = pa.constrain(index, 0, numColumns - 1);

        if (dir == ConstantsFile.InputDirection.LEFT) {
            cols.get(index).fadeOff();
        }
        else if (dir == ConstantsFile.InputDirection.RIGHT) {
            cols.get(index).fadeOn();
        }

        for(Column col: cols){
            col.update();
        }

        slider.update();

        if (slider.getState() == Slider.SliderState.ON || slider.getState() == Slider.SliderState.OFF) {
            dir = ConstantsFile.InputDirection.NONE;
        }



    }

    public void setDirection(ConstantsFile.InputDirection dir){
        this.dir = dir;
        switch(dir){
            case UP:
                sequentialUp();
                break;

            case DOWN:
                sequentialDown();
                break;

            case RIGHT:
                sequentialRight();
                break;

            case LEFT:
                sequentialLeft();
                break;

            case NONE:
                break;
        }
    }

    private void sequentialUp() {
        for (Column col : cols) {
            col.sequentialUp();
        }
    }

    private void sequentialDown(){
        for (Column col : cols) {
            col.sequentialDown();
        }
    }

    private void sequentialRight(){
        slider.setDirection(Slider.SliderDirections.FORWARD);

    }

    private void sequentialLeft(){
        slider.setDirection(Slider.SliderDirections.BACKWARD);

    }

    public void fadeOn() {
        for(Column col: cols){
            col.fadeOn();
        }
    }

    public void fadeOff() {
        for(Column col: cols){
            col.fadeOff();
        }
    }

    public void shuffleColumns(){

        if(dir == ConstantsFile.InputDirection.NONE){
            System.out.println("SHUFFLED");
            for(Column column: cols){
                column.shuffleTriggerOrder();
            }
        }
        else{
            System.out.println("CANNOT SHUFFLE");
        }
    }

    public void alignColumns(){
        if(dir == ConstantsFile.InputDirection.NONE) {
            System.out.println("ALIGNED");
            for (Column column : cols) {
                column.alignTriggerOrder();
            }
        }
        else{
            System.out.println("CANNOT ALIGN");
        }
    }
}
