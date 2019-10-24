package agh.cs.lab4;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] t){

        //String[] t = (String[]) Arrays.stream(args).filter(x->(x.equals("FORWARD")||x.equals("f")||x.equals("BACKWARD")||x.equals("f")||x.equals("LEFT")||x.equals("l")||x.equals("RIGHT")||x.equals("r"))).toArray();

        int k =0;
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

        }
        MoveDirection[] arr_tmp=new MoveDirection[k];

        int j=0;
        for(int i=0;i<t.length;i++){
            switch (t[i]){
                case "forward":
                case "f":
                    arr_tmp[j] = MoveDirection.FORWARD;
                    j++;
                    break;
                case "backward":
                case "b":
                    arr_tmp[j] = MoveDirection.BACKWARD;
                    j++;
                    break;
                case "left":
                case "l":
                    arr_tmp[j] = MoveDirection.LEFT;
                    j++;
                    break;
                case "right":
                case "r":
                    arr_tmp[j] = MoveDirection.RIGHT;
                    j++;
                    break;

            }

        }

        return arr_tmp;

    }
}