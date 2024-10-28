package lab09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMapShould {
    @Test
    void do_basic_map_stuff() {
        var mm = new HashMap<String, String>();
        mm.insert("dog", "woof");
        assertEquals("woof", mm.get("dog"));

        mm.insert("duck", "quack");
        mm.insert("cat", "meow");
        mm.insert("cow", "moo");
        assertEquals(4, mm.size());
        assertEquals("woof", mm.get("dog"));
        assertEquals("moo", mm.get("cow"));
        assertEquals("quack", mm.get("duck"));
        mm.insert("duck", "arf");
        assertEquals("arf", mm.get("duck"));

        var ee = assertThrows(RuntimeException.class, () -> mm.get("bear"));
        assertEquals("no such key", ee.getMessage());

        mm.delete("duck");
        mm.delete("cat");

        ee = assertThrows(RuntimeException.class, () -> mm.get("duck"));
        assertEquals("no such key", ee.getMessage());

        assertEquals("woof", mm.get("dog"));
        assertEquals("moo", mm.get("cow"));

        var ks0 = mm.keys();
        var ks1 = new ArrayList<String>();
        ks1.add("cow"); ks1.add("dog");
        assertEquals(ks1, ks0);

        var ns = new HashMap<Integer, String>();
        for (int ii = 0; ii < 101; ++ii) {
            int xx = ((ii + 1) * 4951) % 101;
            ns.insert(xx, "z"+xx);
        }
        assertEquals(101, ns.size());

        for (int ii = 0; ii < 101; ++ii) {
            assertEquals("z"+ii, ns.get(ii));
        }

        ns.delete(57);
        ns.delete(35);
        assertEquals(99, ns.size());
    }

}
