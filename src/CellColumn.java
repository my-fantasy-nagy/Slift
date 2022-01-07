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
    boolean trans;
    boolean dir;

    public CellColumn(PApplet pa, float cellSize, int numCells, PVector pos) {
        this.pa = pa;
        this.numCells = numCells;
        trans = false;
        dir = false;
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

        //look for slider index transitions and trigger cells
        if(prevIndex != currentIndex) {
            Cell currentCell = cells.get(triggerOrder.get(currentIndex));
            currentCell.transition();
//            currentCell.setDirection(dir);
        }

        //transition case
        if(trans) {
            slider.update();
        }

        //turn off transition flag if slider is at the edge
        if(slider.getPosition() == 1.0 || slider.getPosition() == 0.0) {
            trans = false;
        }

        //update the cells
        for(Cell cell: cells){
            cell.update();
        }

        //set previous index
        prevIndex = currentIndex;
    }

    public void transition(){
//        int currentIndex = (int) PApplet.map(slider.getPosition(), 0.0F, 1.0F, 0.0F, numCells-1.0F);

        slider.reverseDirection();
        trans = true;
        dir = !dir;

        if(trans && prevIndex != -1.0F){
//            cells.get(triggerOrder.get(prevIndex)).setDirection(dir) ;
        }

    }

    public void alignTriggerOrder(){
        IntList newList = new IntList();
        for(int i = 0; i < numCells; i++){
            newList.append(i);
        }
        triggerOrder = newList;
    }

    public void shuffleTriggerOrder(){
        triggerOrder.shuffle();
        prevIndex = triggerOrder.get(0);
    }



    public void allCellsToOn(){
        //TODO: Fix bug in ON/OFF Sequences
        trans = false;
        for(Cell cell : cells){
//            cell.setDirection(true);
        }
        slider.setPos(1.0F);
    }

    public void allCellsToOff(){
        trans = false;
        for(Cell cell : cells){
//            cell.setDirection(false);
        }
        slider.setPos(0.0F);
    }

}
