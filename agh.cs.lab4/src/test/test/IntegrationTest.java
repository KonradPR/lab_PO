package test;

import agh.cs.lab4.*;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void test(){
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
}
