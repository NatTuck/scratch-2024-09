package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import static demo.App.addOneToAll;
import static demo.App.addOneToEach;

public class AppShould {

    @Test
    void add_one_to_all() {
        var xs = List.of(1, 2, 3, 4);
        var ys = addOneToAll(xs);
        assertEquals(List.of(2, 3, 4, 5), ys);
    }

    @Test
    void add_one_to_each() {
        var xs = new ArrayList(List.of(1, 2, 3, 4));
        addOneToEach(xs);
        assertEquals(List.of(2, 3, 4, 5), xs);
    }

}
