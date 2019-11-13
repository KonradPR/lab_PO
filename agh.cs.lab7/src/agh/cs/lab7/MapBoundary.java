package agh.cs.lab7;

import java.util.Comparator;
import java.util.TreeMap;

public class MapBoundary implements IPositionChangeObserver {

    private TreeMap<Vector2d,Object>  byX= new TreeMap<>();
    private TreeMap<Vector2d,Object>  byY= new TreeMap<>( new Comparator<Vector2d>(){
            public int compare(Vector2d first, Vector2d second){
                if(first.y<second.y) return -1;
                if(first.y>second.y) return 1;
                return first.x>second.x? 1 : -1;
            }
    });

    public void addObject(Object tmp,Vector2d pos){
        byX.put(pos,tmp);
        byY.put(pos,tmp);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
            Object tmp = byX.get(oldPosition);
            byX.remove(oldPosition);
            byY.remove(oldPosition);
            byX.put(newPosition,tmp);
            byY.put(newPosition,tmp);
    }

    public Vector2d low(){
        Vector2d lowY = byY.firstKey();
        Vector2d lowX = byX.firstKey();
        return lowX.lowerLeft(lowY);
    }

    public Vector2d high(){
        Vector2d highY = byY.lastKey();
        Vector2d highX = byX.lastKey();
        return highX.upperRight(highY);
    }
}
