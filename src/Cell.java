import processing.core.PVector;

public class Cell {
    PVector pos;
    double size;
    int colorA;
    int colorB;



    public Cell(PVector pos, double size, int colorA, int colorB) {
        this.pos = pos;
        this.size = size;
        this.colorA = colorA;
        this.colorB = colorB;
    }


}
