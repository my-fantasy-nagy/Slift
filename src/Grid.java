import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;

import java.util.ArrayList;

import static Constants.ConstantsFile.COLUMN_RATE;

public class Grid {
    PApplet pa;
    ArrayList<CellColumn> cols = new ArrayList<>();
    IntList triggerOrder;
    Slider slider;
    int numColumns;

    public Grid(PApplet pa, float cellSize, int numColumns, int numCells, PVector pos){
        this.pa = pa;
        this.numColumns = numColumns;

        //create intList to determine display order
        triggerOrder = new IntList();

        //Slider for transversing the column
        slider = new Slider(COLUMN_RATE);

        for(int i = 0; i < numColumns; i++){

            //calculate position
            float posX = i * cellSize + pos.y;;
            float posY = pos.x;

            // create new column
            cols.add(new CellColumn(pa, cellSize, numCells, new PVector(posX, posY)));

            //populate trigger order in increasing numerical order
            triggerOrder.append(i);
        }
    }

    public void update(){
        for(CellColumn col: cols){
            col.update();
        }
    }

    public void transition(){
        for(CellColumn col: cols){
            col.transition();
        }
    }

    public void shuffleColumns(){
        for(CellColumn column: cols){
            column.shuffleTriggerOrder();
        }
    }

    public void alignColumns(){
        for(CellColumn column: cols){
            column.alignTriggerOrder();
        }
    }
}
