package worldbuilder;

import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;


/**
 * The loot class in intended for generating randomized loot drops based off of a given list of items and quantities given in an input file.
 * @author Sam
 */
public class Loot {
    
    String address;
    ArrayList<ItemOption> possibilities = new ArrayList<ItemOption>();
    
    public Loot(String a) throws FileNotFoundException {
        FileReader read;
        Scanner ui;
        
        try {
            read = new FileReader(a);
            ui = new Scanner(read);
        } catch(FileNotFoundException e) {
            throw e;
        }
        
        
    }
    
}
