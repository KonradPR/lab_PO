package agh.cs.lab6;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            List<HayStack> stacks = new ArrayList<>();
            stacks.add(new HayStack(new Vector2d(-4, -4)));
            stacks.add(new HayStack(new Vector2d(7, 7)));
            stacks.add(new HayStack(new Vector2d(3, 6)));
            stacks.add(new HayStack(new Vector2d(2, 0)));
            IWorldMap map = new UnboundedMap(stacks);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
        System.out.println(map.toString());
        map.run(directions);
        System.out.println(map.toString());
    }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
}