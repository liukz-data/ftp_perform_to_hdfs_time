package main_deal;

import java.io.File;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) {
        File d2=new File("H:\\out\\dfaaasssaaa");
        if(!d2.exists()){
            d2.mkdirs();
        }
        File f2=new File("H:\\out\\dfaaasssaaa\\reduce.csv");
        try {
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
