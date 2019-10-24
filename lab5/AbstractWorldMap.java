package agh.cs.lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    protected boolean canMove(Vector2d position){
        if(isOccupied(position))return false;
        return true;
    }

    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        Animal tmp;
        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getPosition().equals(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        Animal tmp;
        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getPosition().equals(position)) return tmp;
        }
        return null;
    }

    public void run(MoveDirection[] directions) {
        int n = animals.size();
        for(int i=0;i<directions.length;i++){
            animals.get(i%n).move(directions[i]);
        }
    }

    protected String stringify(Vector2d low, Vector2d up){
        MapVisualizer tool = new MapVisualizer(this);
        return tool.draw(low,up);
    }

}