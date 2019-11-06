package agh.cs.lab6;

import java.util.*;

abstract class AbstractWorldMap  implements  IWorldMap{
    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();

    public void place(Animal animal) {
        if(isOccupied(animal.getPosition())) throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
        animals.put(animal.getPosition(), animal);

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
            animals.remove(t[i%n].getPosition());
            t[i%n].move(directions[i]);
            animals.put(t[i%n].getPosition(),t[i%n]);
        }
    }

    public String stringyfy(Vector2d low,Vector2d up){
        MapVisualizer tool = new MapVisualizer(this);
        return tool.draw(low,up);
    }
}
