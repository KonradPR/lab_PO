package agh.cs.lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int height;
    private int width;
    private List<Animal> animals;


    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.animals=new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x<0||position.x>width)return false;
        if(position.y<0||position.y>height)return false;
        return canMove(position);
    }

    public String toString(){
        return stringify(new Vector2d(0,0), new Vector2d(width,height));
    }
}

