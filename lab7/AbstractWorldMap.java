package agh.cs.lab7;

import java.util.*;

abstract class AbstractWorldMap  implements  IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();

    public void place(Animal animal) {
        if(isOccupied(animal.getPosition())) throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
        animals.put(animal.getPosition(), animal);
        animal.addOberver(this);

    }



    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }


    public void run(MoveDirection[] directions) {
        int n = animals.size();
        Animal[] t = new Animal[n];
        animals.values().toArray(t);
        for(int i=0;i<directions.length;i++){
           t[i%n].move(directions[i]);
        }
    }

    public String stringyfy(Vector2d low,Vector2d up){
        MapVisualizer tool = new MapVisualizer(this);
        return tool.draw(low,up);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal tmp = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,tmp);
    }
}
