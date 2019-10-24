package agh.cs.lab3;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString(){
        return "Position: " + this.position + " Orientation: " + this.orientation;
    }

    public void move(MoveDirection dir){
        switch(dir){
            case LEFT:orientation = orientation.previous();
            break;
            case RIGHT:  orientation = orientation.next();
            break;
            case FORWARD: switch (orientation){
                case NORTH: if(position.y<4) position=position.add(new Vector2d(0,1));
                break;
                case SOUTH:if(position.y>0) position = position.add(new Vector2d(0,-1));
                break;
                case EAST:if(position.x<4) position = position.add(new Vector2d(1,0));
                break;
                case WEST:if(position.x>0) position=position.add(new Vector2d(-1,0));
                break;
            }
            break;
            case BACKWARD: switch (orientation){
                case NORTH: if(position.y>0) position=position.subtract(new Vector2d(0,1));
                    break;
                case SOUTH:if(position.y<4) position = position.subtract(new Vector2d(0,-1));
                    break;
                case EAST:if(position.x>0) position = position.subtract(new Vector2d(1,0));
                    break;
                case WEST:if(position.x<4) position=position.subtract(new Vector2d(-1,0));
                    break;
            }
            break;
        }



    }



}
