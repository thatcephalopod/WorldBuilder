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

}
