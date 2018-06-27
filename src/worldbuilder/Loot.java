package worldbuilder;

import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * The loot class in intended for generating randomized loot drops based off of
 * a given list of items and quantities given in an input file.
 *
 * @author Sam
 */
public class Loot {

    public class ItemDrop {

        public Item core;
        public int quantity;

        public ItemDrop(Item c, int q) {
            core = c;
            quantity = q;
        }

    }

    String address;
    ArrayList<ItemOption> possibilities = new ArrayList<ItemOption>();

    public Loot(String a) throws IOException {
        FileReader read;
        Scanner ui;

        try {
            read = new FileReader(a);
            ui = new Scanner(read);
        } catch (FileNotFoundException e) {
            throw e;
        }
        //Reading the file
        while (ui.hasNextLine()) {
            //This is a fairly fragile way of reading the file.
            //If the file ever breaks the syntax, the whole program fails.
            String name = ui.next();
            String quality = ui.next();
            if (quality.equals("~")) {
                quality = "";
            }
            int qual = ui.nextInt();
            int min = ui.nextInt();
            int max = ui.nextInt();
            double g = ui.nextDouble();

            Item temp = new Item(name, quality, qual, g);
            possibilities.add(new ItemOption(temp, min, max));
            
        }
    }

    public ArrayList<ItemDrop> createDrop(int avg, int dev) {

        ArrayList<ItemDrop> out = new ArrayList<ItemDrop>();
        int currentGold = 0;
        boolean keepAddingItems = true;

        //Add items to the output list
        do {

            //Get the ItemOption to work with
            int pos = (int) (Math.random() * possibilities.size());
            ItemOption temp = possibilities.get(pos);

            //Get the quantity of the item to put into the drop
            int quantity = (int) (Math.random() * (temp.getMax() - temp.getMin()) + temp.getMin());

            ItemDrop x = new ItemDrop(temp.getCore(), quantity);
            out.add(x);

            //Test to see if another item should be added
            if (totalListGold(out) > avg + dev) {
                out.remove(out.size() - 1); //Remove the last item in the list and try again
                //There is no failsafe where the code accidentally makes itself impossible to finish the algorithm.
                //Just make sure the deviation is fairly high to avoid this.
            } else if (totalListGold(out) <= avg + dev && totalListGold(out) >= avg - dev) {
                keepAddingItems = false; //stop the loop
            } else {
                //Just go another time
            }
            //There is no way to ensure that
        } while (keepAddingItems);
        
        out = condenseList(out);
        return out;

    }
    
    public void printDrop(ArrayList<ItemDrop> in) {
        DecimalFormat df = new DecimalFormat("####.##");        
        
        System.out.println("--------------");
        System.out.println("Quality  Name     Value  Quantity");
        
        for (int i = 0; i < in.size(); i++)
        {
            System.out.printf("%-8s %-10s %5.2f %9d %n",in.get(i).core.getQuality(), in.get(i).core.getName(), in.get(i).core.getGold(), in.get(i).quantity);
        }
        
        System.out.println("--------------");
        System.out.println("Total Value: " + df.format(totalListGold(in)));
    }

    public void printPossibilities() {
        for(int i = 0; i < possibilities.size(); i++) {
            System.out.println(possibilities.get(i).core);
        }
    }
    
    private double totalListGold(ArrayList<ItemDrop> in) {

        double total = 0;

        for (int i = 0; i < in.size(); i++) {
            total += in.get(i).core.getGold() * in.get(i).quantity;
        }

        return total;
    }

    private ArrayList<ItemDrop> condenseList(ArrayList<ItemDrop> in) {
        
        ArrayList<ItemDrop> out = new ArrayList<ItemDrop>();
        
        
        for(int i = 0; i < in.size(); i++) {
            ArrayList<Integer> toDelete = new ArrayList<Integer>();
            out.add(in.get(i));
            
            for(int j = i+1; j < in.size(); j++) {
                ItemDrop temp;
                if(out.get(i).core.equals(in.get(j).core)) {
                    temp = new ItemDrop(out.get(i).core, out.get(i).quantity + in.get(i).quantity);
                    out.set(i, temp);
                    toDelete.add(j);
                }
            }
            
            for(int j = toDelete.size()-1; j >= 0; j--) {
                in.remove(toDelete.get(j).intValue());
                
                
            }
            
        }
        
        return out;
    }
    
    private boolean inList(Item item, ArrayList<ItemDrop> dropList) {
        for(int i = 0; i < dropList.size(); i++) {
            if(item.getName().equals(dropList.get(i).core.getName()))
                return true;
        }
        return false;
    }
    
}
