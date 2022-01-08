import processing.core.PApplet;
import processing.core.PVector;
import processing.data.IntList;
import java.util.ArrayList;
import static Constants.ConstantsFile.COLUMN_RATE;

public class Column {

    PApplet pa;
    ArrayList<Cell> cells = new ArrayList<>();
    IntList triggerOrder;
    Slider slider;
    int numCells;
    int index;
    boolean sequential = false;

    public Column(PApplet pa, PVector pos, float cellSize, int numCells) {
        this.pa = pa;
        this.numCells = numCells;
        index = 0;

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
        //set the index and constrain to number of cells.
        index = (int)pa.map(slider.getPosition(), 0.0F, 1.0F, 0.0F, numCells );
        index = pa.constrain(index, 0, numCells-1);


        if(sequential){
            cells.get(index).setDirection(slider.getDirection());
        }

        //update the cells
        for(Cell cell: cells){
            cell.update();
        }

        //udate slider
        slider.update();

        if(slider.getState() == Slider.SliderState.ON || slider.getState() == Slider.SliderState.OFF){
            sequential = false;
        }

    }

    public void reverseAll(){
        for(Cell cell: cells){
            cell.reverse();
        }
    }

    public void reverseSequential(){
        sequential = true;
        slider.reverseDirection();
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
    }



    public void allCellsToOn(){

    }

    public void allCellsToOff() {

    }
}