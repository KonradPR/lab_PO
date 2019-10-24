package test;

import main.MapDirection;
import org.junit.Assert;
import org.junit.Test;


public class MapDirectionTest {

    @Test
    public void nextTest(){
        MapDirection nt = MapDirection.NORTH;
        MapDirection st = MapDirection.SOUTH;
        MapDirection es = MapDirection.EAST;
        MapDirection ws = MapDirection.WEST;

        Assert.assertEquals(nt, ws.next());
        Assert.assertEquals(st,es.next());
        Assert.assertEquals(es ,nt.next());
        Assert.assertEquals(ws, st.next());

    }

    public void previousTest(){
        MapDirection nt = MapDirection.NORTH;
        MapDirection st = MapDirection.SOUTH;
        MapDirection es = MapDirection.EAST;
        MapDirection ws = MapDirection.WEST;

        Assert.assertEquals(nt,es.previous());
        Assert.assertEquals(es,st.previous());
        Assert.assertEquals(st,ws.previous());
        Assert.assertEquals(ws,nt.previous());

    }



}
