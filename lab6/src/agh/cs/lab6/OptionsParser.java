package agh.cs.lab6;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] t){

        //String[] t = (String[]) Arrays.stream(args).filter(x->(x.equals("FORWARD")||x.equals("f")||x.equals("BACKWARD")||x.equals("f")||x.equals("LEFT")||x.equals("l")||x.equals("RIGHT")||x.equals("r"))).toArray();

       /* int k =0;
        for(int i=0;i<t.length;i++){
            switch (t[i]){
                case "forward":
                case "f":
                    k++;
                    break;
                case "backward":
                case "b":
                    k++;
                    break;
                case "left":
                case "l":
                    k++;
                    break;
                case "right":
                case "r":
                    k++;
                    break;
                default:
                    break;

            }

        }*/
        MoveDirection[] arr_tmp=new MoveDirection[t.length];


        for(int i=0;i<t.length;i++){
            switch (t[i]){
                case "forward":
                case "f":
                    arr_tmp[i] = MoveDirection.FORWARD;

                    break;
                case "backward":
                case "b":
                    arr_tmp[i] = MoveDirection.BACKWARD;

                    break;
                case "left":
                case "l":
                    arr_tmp[i] = MoveDirection.LEFT;

                    break;
                case "right":
                case "r":
                    arr_tmp[i] = MoveDirection.RIGHT;
                    break;
                default:
                    throw  new IllegalArgumentException(t[i]+" is not a valid move specification");
            }

        }

        return arr_tmp;

    }
}