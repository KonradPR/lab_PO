package agh.cs.lab7;

public class Vector2d implements Comparable<Vector2d>{
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

    @Override
    public int hashCode() {
        int tmp =11;
        tmp += x*13;
        tmp += y*17;
        return tmp;
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

    public int compareTo(Vector2d other){
        if(x<other.x) return -1;
        if(x>other.x) return 1;
        return y>other.y? 1 : -1;
    }



}