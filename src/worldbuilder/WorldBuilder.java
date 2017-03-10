
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
        a.printPossibilities();
        a.printDrop(a.createDrop(100, 20));
    }
    
}
