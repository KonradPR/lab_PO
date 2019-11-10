package agh.cs.lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Vector2d getPosition(){
        return new Vector2d(position.x,position.y);
    }



    public String toString(){
        return orientation.toString().substring(0,1);
    }

    public void move(MoveDirection dir){
        Vector2d old = this.getPosition();

        switch(dir){
            case LEFT:orientation = orientation.previous();
                break;
            case RIGHT:  orientation = orientation.next();
                break;
            case FORWARD: switch (orientation){
                case NORTH: if(map.canMoveTo(position.add(new Vector2d(0,1)))) position=position.add(new Vector2d(0,1));
                    break;
                case SOUTH:if(map.canMoveTo(position.add(new Vector2d(0,-1)))) position = position.add(new Vector2d(0,-1));
                    break;
                case EAST:if(map.canMoveTo(position.add(new Vector2d(1,0)))) position = position.add(new Vector2d(1,0));
                    break;
                case WEST:if(map.canMoveTo(position.add(new Vector2d(-1,0)))) position=position.add(new Vector2d(-1,0));
                    break;
            }
                break;
            case BACKWARD: switch (orientation){
                case NORTH: if(map.canMoveTo(position.subtract(new Vector2d(0,1)))) position=position.subtract(new Vector2d(0,1));
                    break;
                case SOUTH:if(map.canMoveTo(position.subtract(new Vector2d(0,-1)))) position = position.subtract(new Vector2d(0,-1));
                    break;
                case EAST:if(map.canMoveTo(position.subtract(new Vector2d(1,0)))) position = position.subtract(new Vector2d(1,0));
                    break;
                case WEST:if(map.canMoveTo(position.subtract(new Vector2d(-1,0)))) position=position.subtract(new Vector2d(-1,0));
                    break;
            }
                break;
        }

        if(dir==MoveDirection.BACKWARD||dir==MoveDirection.FORWARD){
            this.positionChanged(old,this.getPosition());
        }



    }

    public void addOberver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        Iterator<IPositionChangeObserver> it = observers.iterator();

        while(it.hasNext()){
            it.next().positionChanged(oldPos,newPos);
        }
    }



}