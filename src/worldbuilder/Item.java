
package worldbuilder;

/**
 * An item is an object that has a given name, quantity, and quality
 * @author Sam
 */
public class Item {
    private String name;
    private String quality;
    private int value;
    /*
    An item will have its quality and a value.
    Quality is the specific name for the quality: this is "Legendary" or "Common" or anything the user desires
    The value is used for calculations relating to quality. There are 7 levels: these are, in order of highest to lowest,
    Artifact, Masterwork, Exceptional, Surperior, Fine, Standard, and Sub-Par
    Artifact is valued at 6 while Sub-par is valued at 0;
    */
    private double gold; //Gold value of the item
    
    /**
     * The full constructor for Item
     * @param n Name of the item
     * @param qal Quality name for the item
     * @param val Value score for the item (0-6, 6 is the highest)
     * @param g Gold value for the item
     */
    public Item(String n, String qal, int val, double g) {
        name = n;
        quality = qal;
        value = val;
        gold = g;
    }

    /**
     * Minimalist constructor: assumed basic quality and quantity of 1
     * @param n Name of the item
     * @param g Gold value for the item
     */
    public Item(String n, double g) {
        name = n;
        quality = "";
        value = 1;
        gold = g;
    }
    
    public double getGold() {
        return gold;
    }
    
    public String getName() {
        return name;
    }
    
    public String getQuality() {
        return quality;
    }
    
    public int getValue() {
        return value;
    }
    
    public String toString() {
        if(quality.equals(""))
            return name + " " + gold;
        else
            return quality + " " + name + " " + gold;
    }
    
    public boolean equals(Item comparison) {
        return name.equals(comparison.name) && quality.equals(comparison.quality) && value == comparison.value;
    }
}
