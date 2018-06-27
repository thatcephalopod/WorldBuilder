
package worldbuilder;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Sam
 */
public class WorldBuilder {

    public static void main(String[] args) throws IOException {
        
        Loot a = new Loot("standardTable.txt");
        for(int i = 0; i < 10; i++)
            a.printDrop(a.createDrop(40, 30));   
        Loot b = new Loot("conscript.txt");
        //b.printDrop(b.createDrop(20, 10));
    }
    
}