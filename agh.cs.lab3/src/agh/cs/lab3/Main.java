package agh.cs.lab3;

public class Main {

    public static void main(String[] args) {
	Animal  a1 = new Animal();
	System.out.println(a1);
	a1.move(MoveDirection.RIGHT);
	a1.move(MoveDirection.FORWARD);
	a1.move(MoveDirection.FORWARD);
	a1.move(MoveDirection.FORWARD);
	System.out.println(a1);
	a1.move(MoveDirection.FORWARD);
        System.out.println(a1);
     OptionsParser p = new OptionsParser();
     String[] t = {"r","backward","dd","l"};
     MoveDirection[] t1 = p.parse(t);
     System.out.println(t1[0]);

    }
}
