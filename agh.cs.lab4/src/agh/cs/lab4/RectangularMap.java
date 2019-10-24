package agh.cs.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RectangularMap implements IWorldMap {
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
        if(isOccupied(position))return false;
        return true;
    }

    @Override
    public boolean place(Animal animal) {
       if(isOccupied(animal.getPosition())) return false;
       animals.add(animal);
       return true;
    }





    @Override
    public boolean isOccupied(Vector2d position) {
        Animal tmp;
        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal tmp;
        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getPosition().equals(position)) return tmp;
        }
        return null;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int n = animals.size();
        for(int i=0;i<directions.length;i++){
            animals.get(i%n).move(directions[i]);
        }
    }
    public String toString(){
        MapVisualizer tool = new MapVisualizer(this);
        return tool.draw(new Vector2d(0,0), new Vector2d(width,height));
    }
}

