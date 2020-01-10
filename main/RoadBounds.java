package main;

import java.awt.Rectangle;

public class RoadBounds {

    private int[][] roadBoundsAttributes = {{50, 100, 150, 200};
    private Rectangle[] bounds;
    
    public RoadBounds() {
        roads = new Rectangle[10];
        
        createRoadBounds(roads);
    }

    private void createRoadBounds(Rectangle roads) {
        
        for (int i = 0; i < 1; i++) {
            int x = roadBoundsAttributes[0];
            int y = roadBoundsAttributes[1];
            int width = roadBoundsAttributes[2];
            int height = roadBoundsAttributes[3];
            bounds[i] = new Rectangle(x, y, width, height);
        }
    }
    
    public int[] getBounds() {
        return bounds;
    }

}
