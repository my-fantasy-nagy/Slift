import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;
import java.util.ArrayList;

public class CellColumn {

    PApplet pa;
    ArrayList<Cell> cells = new ArrayList<Cell>();
    int numCells;
    IntList triggerOrder;
    float cellSize;

    public CellColumn(PApplet pa, float cellSize, int numCells, PVector pos) {
        this.pa = pa;
        this.cellSize = cellSize;
        this.numCells = numCells;

        //create intList to determine display order
        triggerOrder = new IntList();

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

}
