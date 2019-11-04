package agh.cs.lab6;

import javax.xml.bind.ValidationException;
import java.util.*;

public class UnboundedMap extends AbstractWorldMap {

    private HashMap<Vector2d,HayStack> stacks = new LinkedHashMap<>();

    public UnboundedMap(HashMap<Vector2d,HayStack> stacks){
       super();
        this.stacks = stacks;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position))return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) return true;
        if(stacks.get(position)==null) return false;
        return true;
    }

    public Object objectAt(Vector2d position){
        Object t = super.objectAt(position);
        if(t==null){
            HayStack tmp = stacks.get(position);
            return tmp;
        }
        return t;
    }

    public String toString(){
        Vector2d up = new Vector2d(0,0);
        Vector2d low = new Vector2d(0,0);

        HayStack tmp;
        Iterator<HayStack> it = stacks.values().iterator();
        while (it.hasNext()) {
            tmp = it.next();
            up = up.upperRight(tmp.getPosition());
            low = low.lowerLeft(tmp.getPosition());
        }
        Animal t;
        Iterator<Animal> its = animals.values().iterator();
        while (its.hasNext()) {
            t = its.next();
            up = up.upperRight(t.getPosition());
            low = low.lowerLeft(t.getPosition());
        }

        return super.stringyfy(low,up);
    }

}
