package agh.cs.lab5;

public class HayStack {
    private Vector2d position;

    public HayStack(Vector2d position){
        this.position=position;
    }

    public Vector2d getPosition() {
       return new Vector2d(position.x,position.y);
    }

    @Override
    public String toString() {
        return "H";
    }

}
