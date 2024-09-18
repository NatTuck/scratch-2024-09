package dslabs;

import worldx.*;

record Doll(String color, Doll /* or null */ inner) {
    Image draw() {
        // Template gives us color, hat
        // So we have access to all methods of hat
        if (inner == null) {
            return new Circle(80, "solid", color);
        }
        else {
            return new Circle(80, "solid", color)
                    .overlayxy(-40, 0, inner.draw());
        }
    }
}

public class DollWorld implements World {
    Doll doll;

    DollWorld(Doll d0) {
        this.doll = d0;
    }

    @Override
    public Scene onDraw() {
        var bg = new EmptyScene(800, 600);
        var fg = doll.draw();
        return bg.placeImage(fg, 400, 300);
    }
}
