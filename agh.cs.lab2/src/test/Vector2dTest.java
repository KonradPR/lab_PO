import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;
import main.Vector2d;

public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(2,3);

        Assert.assertTrue(v1.equals(v2));
    }

    @Test
    public void toStringTest(){
        Vector2d v1 = new Vector2d(2,3);
        Assert.assertEquals(v1.toString(),"(2,3)");
    }

    @Test
    public void precedesTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);

        Assert.assertTrue(v1.precedes(v2));
    }

    @Test
    public void followsTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);
        Assert.assertTrue(v2.follows(v1));
    }

    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);
        Assert.assertEquals(v1.upperRight(v2),v2);
    }

    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);
        Assert.assertEquals(v1.lowerLeft(v2),v1);
    }

    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);
        Assert.assertEquals(v1.add(v2),new Vector2d(6,7));
    }

    @Test
    public void subtractTest(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(4,4);
        Assert.assertEquals(v1.subtract(v2),new Vector2d(-2,-1));
    }

    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(2,3);
        Assert.assertEquals(v1.opposite(),new Vector2d(-2,-3));
       // Assert.assertEquals(v1,v1);
    }
}
