package agh.cs.lab6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int height;
    private int width;



    public RectangularMap(int width, int height){
        super();
        this.width=width;
        this.height=height;

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x<0||position.x>width)return false;
        if(position.y<0||position.y>height)return false;
        if(isOccupied(position))return false;
        return true;
    }









    public String toString(){
        return super.stringyfy(new Vector2d(0,0), new Vector2d(width,height));
    }
}

