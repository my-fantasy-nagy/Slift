import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;
import java.util.ArrayList;
import static Constants.ConstantsFile.COLUMN_RATE;

public class CellColumn {

    PApplet pa;
    ArrayList<Cell> cells = new ArrayList<Cell>();
    IntList triggerOrder;
    Slider slider;
    int numCells;
    float cellSize;
    boolean trans;

    public CellColumn(PApplet pa, float cellSize, int numCells, PVector pos) {
        this.pa = pa;
        this.cellSize = cellSize;
        this.numCells = numCells;
        trans = false;

        //create intList to determine display order
        triggerOrder = new IntList();

        //Slider for transversing the column
        slider = new Slider(COLUMN_RATE);

        //cycle through each cell, initialize it and add it to the Cell array
        for(int i = 0; i < numCells; i++){

            //calculate position
            float posY = i * cellSize + pos.y;
            float posX = pos.x;

            //create new cell
            cells.add(new Cell(pa, new PVector(posX, posY), cellSize, 255, 0));

            //populate trigger order in increasing numerical order
            triggerOrder.append(i);
        }
    }

    public void update(){
        for(Cell cell: cells){
            cell.update();
        }

        if(trans){
            slider.update();
        }

        if(slider.getPosition() == 1.0 || slider.getPosition() == 0.0) {
            trans = false;
        }
    }

    public void fadeInOut(){
        boolean up = true;

        for(Cell cell : cells){
            float pos = cell.getPos();
            if(pos <= 0.0){
                cell.transition();
            }
            else if(pos >= 1.0){
                cell.transition();
            }
        }
    }

    public void shuffleTriggerOrder(){
        triggerOrder.shuffle();
    }

    public void transition(){
        slider.reverseDirection();
        trans = true;
    }

}
