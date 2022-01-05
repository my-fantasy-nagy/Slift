import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;
import java.util.ArrayList;
import static Constants.ConstantsFile.COLUMN_RATE;

public class CellColumn {

    PApplet pa;
    ArrayList<Cell> cells = new ArrayList<>();
    IntList triggerOrder;
    Slider slider;
    int numCells;
    int prevIndex;
    float cellSize;
    boolean trans;

    public CellColumn(PApplet pa, float cellSize, int numCells, PVector pos) {
        this.pa = pa;
        this.cellSize = cellSize;
        this.numCells = numCells;
        trans = false;
        prevIndex = 0;

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
        int currentIndex = (int) PApplet.map(slider.getPosition(), 0.0F, 1.0F, 0.0F, numCells-1.0F);

        if(prevIndex != currentIndex) {
            Cell currentCell = cells.get(triggerOrder.get(currentIndex));
            currentCell.transition();
        }

        if(trans) {
            //edge case for first and last cells
            if(currentIndex == numCells - 1 || currentIndex == 0){
                if(slider.getPosition() == 0.0F || slider.getPosition() == 1.0F){
                    System.out.println("HERE");
                    cells.get(triggerOrder.get(currentIndex)).transition();
                }
            }
            slider.update();
        }

        if(slider.getPosition() == 1.0 || slider.getPosition() == 0.0) {
            trans = false;
        }

        for(Cell cell: cells){
            cell.update();
        }

        prevIndex = currentIndex;
    }

    public void fadeInOut(){

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
        prevIndex = triggerOrder.get(0);
    }

    public void transition(){
        slider.reverseDirection();
        trans = true;
    }

    public void allCellsToOn(){
        //TODO: turn all of the cells on
    }

    public void allCellsOff(){
        //TODO: turn all of the cells off
    }

}
