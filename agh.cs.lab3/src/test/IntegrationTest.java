package test;

import agh.cs.lab3.Animal;
import agh.cs.lab3.MoveDirection;
import agh.cs.lab3.OptionsParser;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void integrationTest(){
        Animal a1 = new Animal();
        String[] t = {"r","backward","dd","l"};
        OptionsParser p = new OptionsParser();
        MoveDirection[] t1 = p.parse(t);

        for(MoveDirection arg:t1){
            a1.move(arg);
        }
        Assert.assertEquals(a1.toString(),"Position: (1,2) Orientation: Północ");
    }
}
