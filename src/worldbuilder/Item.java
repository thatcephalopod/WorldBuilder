
package worldbuilder;

/**
 * An item is an object that has a given name, quantity, and quality
 * @author Sam
 */
public class Item {
    String name;
    int quantity;
    String quality;
    int value;
    /*
    An item will have its quality and a value.
    Quality is the specific name for the quality: this is "Legendary" or "Common" or anything the user desires
    The value is used for calculations relating to quality. There are 7 levels: these are, in order of highest to lowest,
    Artifact, Masterwork, Exceptional, Surperior, Fine, Standard, and Sub-Par
    Artifact is valued at 6 while Sub-par is valued at 0;
    */
    int gold; //Gold value of the item
    
    /**
     * The full constructor for Item
     * @param n Name of the item
     * @param qan Quantity of the item(s)
     * @param qal Quality name for the item
     * @param val Value score for the item (0-6, 6 is the highest)
     * @param g Gold value for the item
     */
    public Item(String n, int qan, String qal, int val, int g) {
        name = n;
        quantity = qan;
        quality = qal;
        value = val * qan;
    }

    /**
     * The constructor for Item with an assumed quantity of 1
     * @param n Name of the item
     * @param qal Quality name for the item
     * @param val Value score for the item (0-6, 6 is the highest)
     * @param g Gold value for the item
     */
    public Item(String n, String qal, int val, int g) {
        name = n;
        quantity = 1;
        quality = qal;
        value = val;
    }
    
    /**
     * The constructor for item with only a name and quantity, assumed standard value
     * @param n Name of the item
     * @param qan Quantity of the item(s)
     * @param g Gold value for the item
     */
    public Item(String n, int qan, int g) {
        name = n;
        quantity = qan;
        quality = "";
        value = 1;
    }
    
    /**
     * Minimalist constructor: assumed basic quality and quantity of 1
     * @param n Name of the item
     * @param g Gold value for the item
     */
    public Item(String n, int g) {
        name = n;
        quantity = 1;
        quality = "";
        value = 1;
    }
}
