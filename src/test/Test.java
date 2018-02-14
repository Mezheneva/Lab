import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Test {
    MyHashMap map = new MyHashMap();

    @Test
    public void empty() {
        boolean expRes = true;
        boolean res = map.isEmpty();
        assertEquals(res, expRes);
    }

    @Test
    public void containsKey() {
        map.put(1, "first");
        boolean expRes = true;
        boolean res = map.containsKey(1);
        assertEquals(expRes, res);
    }

    @Test
    public void containsNotKey() {
        map.put(1, "first");
        boolean expRes = false;
        boolean res = map.containsKey("3");
        assertEquals(expRes, res);
    }

    @Test
    public void getValueKey() {
        map.put(1, "first");
        String expRes = "first";
        String res = (String) map.get(1);
        assertEquals(expRes, res);
    }

    @Test
    public void getValueNotKey() {
        map.put(1, "first");
        String expRes = null;
        String res = (String) map.get(2);
        assertEquals(expRes, res);
    }

    @Test
    public void clear() {
        map.put(1, "one");
        map.put(3, "ttt");
        map.put(7, "sdfghjk");

        int expSize = 0;
        map.clear();
        int size = map.size();
        assertEquals(size, expSize);
    }

    @Test
    public void containsValue() {
        map.put(1, "first");
        boolean expRes = true;
        boolean res = map.containsValue("first");
        assertEquals(expRes, res);
    }

    @Test
    public void containsInvalidValue() {
        map.put(1, "hhhh");
        boolean expRes = false;
        boolean res = map.containsValue("tyyii");
        assertEquals(expRes, res);
    }

    @Test
    public void putElement() {
        map.put(1, "first");
        String expRes = "first";
        String res = (String) map.put(1, "second");
        assertEquals(expRes, res);
    }

    @Test
    public void removeElement() {
        map.put(1, "first");
        int expSize = 0;
        map.remove(1);
        int size = map.size();
        assertEquals(expSize, size);
    }

}
