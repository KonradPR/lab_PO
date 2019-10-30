package agh.cs.lab5;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<HayStack> stacks = new ArrayList<>();

    public UnboundedMap(List<HayStack> stacks){
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
        HayStack tmp;
        Iterator<HayStack> it = stacks.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getPosition().equals(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        Object t = super.objectAt(position);
        if(t==null){
            HayStack tmp;
            Iterator<HayStack> it = stacks.iterator();
            while (it.hasNext()) {
                tmp = it.next();
                if (tmp.getPosition().equals(position)) return tmp;
            }
            return null;
        }
        return t;
    }

    public String toString(){
        Vector2d up = new Vector2d(0,0);
        Vector2d low = new Vector2d(0,0);

        HayStack tmp;
        Iterator<HayStack> it = stacks.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            up = up.upperRight(tmp.getPosition());
            low = low.lowerLeft(tmp.getPosition());
        }
        Animal t;
        Iterator<Animal> its = animals.iterator();
        while (its.hasNext()) {
            t = its.next();
            up = up.upperRight(t.getPosition());
            low = low.lowerLeft(t.getPosition());
        }

        return super.stringyfy(low,up);
    }

}
