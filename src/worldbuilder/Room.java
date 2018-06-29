
package worldbuilder;

/**
 *
 * @author Sam
 */
public class Room {
    
    //Height and width include the outside walls of the room
    private int height;
    private int width;
    private String name;
    private String desc;


    //X and Y are the top left corner of the building;
    private int posX;
    private int posY;
    
    /**
     * Initializer for room that specifies height, width, name, and description
     * @param  h Integer of room height
     * @param  w Integer of room width
     * @param  n String of the room's name
     * @param  d String of the room's Description
     */
    public Room(int h, int w, String n, String d) {
        height = h;
        width = w;
        name = n;
        desc=  d;
    }

    /**
     * Initializer for room that only specifies height and width.
     * @param  h Integer of room height
     * @param  w Integer of room width
     */
    public Room(int h, int w) {
    	height = h;
    	width = w;
    	name = "";
    	desc = "";
    }

    /**
     * Sets the position of the room (the top left corner)
     * @param  i Integer array of length two where the first number is the x coordinate and the second number is the y coordinate.
     */
    public setPosition(int[2] i) {
    	posX = i[0];
    	posY = i[1];
    }

    /**
     * Gets the position of the room (the top left corner)
     * @return Integer array of length two where the first number is the x coordinate and the second number is the y coordinate.
     */
    public int[] getPosition() {
    	int [] i = {posX, posY};
    	return i;
    }

    
    /**
     * Returns the room's height
     * @return Integer height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Returns the room's width
     * @return Integer width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Returns the room's name
     * @return String name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the room's description
     * @return [String description
     */
    public String getDesc() {
        return name;
    }
    
}
