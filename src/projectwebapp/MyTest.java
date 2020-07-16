package projectwebapp;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class MyTest {

    @Test
    public void collectionEquals(List webCollection, List databaseCollection) {
        System.out.println("Testing collections to ensure that same.");
        System.out.println("If no assertion error then collections are same.");
        // goes through each object in each collection to check if same.
        for (Object game : webCollection) {
            for (Object object : databaseCollection) {
                // checks each individual object
                assertEquals(game, object);
            }
        }
    }
}
