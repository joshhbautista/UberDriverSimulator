package main;

import java.awt.Rectangle;

public class RoadBounds {

    private int[][] roadBoundsAttributes = {{439, 305, 231, 87}, {719, 429, 108, 166}, {541, 426, 129, 69}, {541, 528, 119, 67}};
    private Rectangle[] bounds;
    
    public RoadBounds() {
        bounds = new Rectangle[4];
        
        createRoadBounds(bounds);
    }

    private void createRoadBounds(Rectangle[] bounds) {
        
        for (int i = 0; i < 4; i++) {
            int x = roadBoundsAttributes[i][0];
            int y = roadBoundsAttributes[i][1];
            int width = roadBoundsAttributes[i][2];
            int height = roadBoundsAttributes[i][3];
            bounds[i] = new Rectangle(x, y, width, height);
        }
    }
    
    public Rectangle[] getBounds() {
        return bounds;
    }

}
