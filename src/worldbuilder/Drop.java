
package worldbuilder;

import java.util.ArrayList;
/**
 *
 * @author Sam
 */
public class Drop extends ArrayList<Item> {
    public int value() {
        int totalGold = 0;
        
        for(int i = 0; i < this.size(); i++) {
            totalGold += this.get(i).getValue();
        }
        
        return totalGold;
    }
}
