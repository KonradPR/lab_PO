package agh.cs.lab5;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other){
        if(x<=other.x && y<=other.y) return true;
        return false;
    }

    public boolean follows(Vector2d other){
        if(x>=other.x && y>=other.y) return true;
        return false;
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(x>other.x?x:other.x,y>other.y?y:other.y);
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(x<other.x?x:other.x,y<other.y?y:other.y);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x,y-other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return (x==that.x && y==that.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }

}