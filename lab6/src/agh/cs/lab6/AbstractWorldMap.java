package agh.cs.lab6;

import java.lang.reflect.Array;
import java.util.*;

abstract class AbstractWorldMap  implements  IWorldMap{
    protected Map<Vector2d,Animal> animals = new LinkedHashMap();

    public void place(Animal animal) {
        if(isOccupied(animal.getPosition())) throw new IllegalArgumentException(animal.getPosition().toString() + " is already occupied");
        animals.put(animal.getPosition(),animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
      Object tmp =  animals.get(position);
      if(tmp==null)return false;
      return true;
    }

    public Object objectAt(Vector2d position) {
        Object tmp =  animals.get(position);
        if(tmp==null)return null;
        return tmp;
    }
    public void run(MoveDirection[] directions) {
        int n = animals.size();
        Animal[] t = new Animal[n];
        animals.values().toArray(t);
        for(int i=0;i<directions.length;i++){
            Animal tmp=t[i%n];
            animals.remove(tmp.getPosition());
            tmp.move(directions[i]);
            animals.put(tmp.getPosition(),tmp);
        }
    }

    public String stringyfy(Vector2d low,Vector2d up){
        MapVisualizer tool = new MapVisualizer(this);
        return tool.draw(low,up);
    }
}
