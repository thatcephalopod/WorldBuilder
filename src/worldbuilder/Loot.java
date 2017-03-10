package worldbuilder;

import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The loot class in intended for generating randomized loot drops based off of
 * a given list of items and quantities given in an input file.
 *
 * @author Sam
 */
public class Loot {

    
    public class ItemDrop{
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
            int g = ui.nextInt();

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
            
            if(totalListGold(out) > avg + dev){
                out.remove(out.size()-1); //Remove the last item in the list and try again
                //There is no failsafe where the code accidentally makes itself impossible to finish the algorithm.
                //Just make sure the deviation is fairly high to avoid this.
            } else if(totalListGold(out) <= avg + dev && totalListGold(out) >= avg + dev) {
                keepAddingItems = false; //stop the loop
            } else {
                //Just go another time
            }
            //There is no way to ensure that
        } while(keepAddingItems);
        
        return out;
        
    }
    
    private int totalListGold(ArrayList<ItemDrop> in) {
        
        int total = 0;
        
        for(int i = 0; i < in.size(); i++) {
            total += in.get(i).core.getGold() * in.get(i).quantity;
        }
        
        return total;
    }

}
