package test;

import agh.cs.lab6.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestInt {
    @Test
    public void rectTest(){
        String [] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);

        Animal a1 =new Animal(map);
        Animal a2 = new Animal(map,new Vector2d(3,4));
        map.place(a1);
        map.place(a2);
        map.run(directions);
        Assert.assertEquals(a1.getPosition(),new Vector2d(2,0));
        Assert.assertEquals(a2.getPosition(),new Vector2d(3,5));
    }

    @Test
    public void unboundedTest(){
        String [] args = {"l","r","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        List<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Vector2d(-4,-4)));
        stacks.add(new HayStack(new Vector2d(7,7)));
        stacks.add(new HayStack(new Vector2d(3,6)));
        stacks.add(new HayStack(new Vector2d(2,0)));
        IWorldMap map = new UnboundedMap(stacks);
        Animal a1 =new Animal(map);
        Animal a2 = new Animal(map,new Vector2d(3,4));
        map.place(a1);
        map.place(a2);
        map.run(directions);
        Assert.assertEquals(a1.getPosition(),new Vector2d(-6,2));
        Assert.assertEquals(a2.getPosition(),new Vector2d(11,4));
    }
}
