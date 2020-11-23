package sample;

//import org.apache.commons.math3.optim.linear.LinearConstraintSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class anytest {
public static List<String> li=new ArrayList<>();
    public static void main(String[] args) {
        int val;
       // Random rnd=new Random();
        li.add("0");
        li.add("5");
        li.add("8");
        li.add("13");
        li.add("16");
        li.add("21");
        li.add("24");
        li.add("29");
        li.add("32");
        li.add("37");
        ArrayList<Integer> ex=new ArrayList<>();
        ex.add(0);
        ex.add(5);
        ex.add(8);
        ex.add(13);
        ex.add(16);
        ex.add(21);
        ex.add(24);
        ex.add(29);
        ex.add(32);

        val = generateRandom(ex);
        System.out.println(val);
    }

    public static int generateRandom( ArrayList<Integer> excludeRows) {
        Random rand = new Random();


        int random = Integer.parseInt(li.get(rand.nextInt(li.size())));

        //System.out.println("-----------");

        if(excludeRows.isEmpty()){}else {
            while (excludeRows.contains(random)) {
                random = Integer.parseInt(li.get(rand.nextInt(li.size()))); ;
            }
        }
        return random;
    }

}
