/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldbuilder;

/**
 *
 * @author Sam
 */
public class ItemOption{
    
    Item core;
    int minimum;
    int maximum;
        
    public ItemOption(String n, int minQan, int maxQan, String qal, int val, int g) {
        core = new Item(n,qal,val,g);
        minimum = minQan;
        maximum = maxQan;
    }
    
    public ItemOption(Item c, int minQan, int maxQan) {
        core = c;
        minimum = minQan;
        maximum = maxQan;
    }
    
    public int getMin() {
        return minimum;
    }
    
    public int getMax() {
        return maximum;
    }
    
    public Item getCore() {
        return core;
    }
    
}
