import Constants.ConstantsFile;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;

import java.util.ArrayList;

import static Constants.ConstantsFile.COLUMN_RATE;
import static Constants.ConstantsFile.ROW_RATE;

public class Grid {
    PApplet pa;
    ArrayList<Column> cols = new ArrayList<>();
    IntList triggerOrder;
    Slider slider;
    int numColumns;
    int index;

    public Grid(PApplet pa, PVector pos, float cellSize, int numCells, int numColumns){
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
            cols.add(new Column(pa, new PVector(posX, posY), cellSize, numCells));

            //populate trigger order in increasing numerical order
            triggerOrder.append(i);
        }
    }

    public void update(){
        for(Column col: cols){
            col.update();
        }
    }

    public void setDirection(ConstantsFile.InputDirection dir){
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

    //TODO: sequentialUP
    private void sequentialUp() {
        for (Column col : cols) {
            col.sequentialUp();
        }
    }

    //TODO: sequentialDown
    private void sequentialDown(){
        for (Column col : cols) {
            col.sequentialDown();
        }
    }

    //TODO: sequentialRight
    private void sequentialRight(){

    }

    //TODO: sequentialLeft
    private void sequentialLeft(){

    }


    public void shuffleColumns(){
        for(Column column: cols){
            column.shuffleTriggerOrder();
        }
    }

    public void alignColumns(){
        for(Column column: cols){
            column.alignTriggerOrder();
        }
    }
}
