package agh.cs.lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<HayStack> stacks;

    public UnboundedMap(List<HayStack> stacks){
        super();
        this.stacks =stacks;

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return canMove(position);
    }




    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)){
            return true;
        }

        HayStack st;
        Iterator<HayStack> itr =stacks.iterator();
        while (itr.hasNext()){
            st=itr.next();
            if (st.getPosition().equals(position)) return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        Object tmp=super.objectAt(position);
       if(tmp!=null){
           return tmp;
       }
        HayStack st;
        Iterator<HayStack> itr =stacks.iterator();
        while (itr.hasNext()){
            st=itr.next();
            if (st.getPosition().equals(position)) return st;
        }
        return null;
    }

    public String toString() {

        Vector2d lowerBound = new Vector2d(0, 0);
        Vector2d upperBound = new Vector2d(0, 0);
        Vector2d tmp;
        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            tmp=it.next().getPosition();
            lowerBound = lowerBound.lowerLeft(tmp);
            upperBound = upperBound.upperRight(tmp);
        }
        Iterator<HayStack> itr = stacks.iterator();
        while (itr.hasNext()) {
            tmp=itr.next().getPosition();
            lowerBound = lowerBound.lowerLeft(tmp);
            upperBound = upperBound.upperRight(tmp);
        }



        return stringify(lowerBound, upperBound);
    }
}
