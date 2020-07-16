package projectwebapp;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class MyTest {

    @Test
    public void collectionEquals(List webCollection, List databaseCollection) {
        System.out.println("Testing collections to ensure that same.");
        for (Object game : webCollection) {
            for (Object object : databaseCollection) {
                assertEquals(game, object);
            }
        }
    }

    @Test
    public void objectEquals(Object game, Object object) {
        System.out.println("Testing each object to ensure that same.");
        assertEquals(game, object);
    }

}
