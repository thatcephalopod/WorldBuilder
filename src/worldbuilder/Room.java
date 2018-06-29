
package worldbuilder;

/**
 *
 * @author Sam
 */
public class Room {
    
    private int height;
    private int width;
    private String name;
    private String desc;
    
    public Room(int h, int w, String n, String d) {
        height = h;
        width = w;
        name = n;
        desc=  d;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDesc() {
        return name;
    }
    
}
