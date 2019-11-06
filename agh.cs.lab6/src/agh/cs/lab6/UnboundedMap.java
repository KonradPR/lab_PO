package agh.cs.lab6;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Collection;
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
       Collection<Animal> animals1 = animals.values();
        Iterator<Animal> it1 = animals1.iterator();
        Animal tmp1;
        while (it1.hasNext()) {
            tmp1 = it1.next();
            up = up.upperRight(tmp1.getPosition());
            low = low.lowerLeft(tmp1.getPosition());
        }
        return super.stringyfy(low,up);
    }

}
