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
        map.put("first", 1);
        boolean expRes = true;
        boolean res = map.containsKey("first");
        assertEquals(expRes, res);
    }

    @Test
    public void containsNotKey() {
        map.put("first", 1);
        boolean expRes = false;
        boolean res = map.containsKey("second");
        assertEquals(expRes, res);
    }

    @Test
    public void getValueKey() {
        map.put("first", 1);
        int expRes = 1;
        int res = map.get("first");
        assertEquals(expRes, res);
    }

    @Test
    public void getValueNotKey() {
        map.put("first", 1);
        int expRes = null;
        int res = map.get("f");
        assertEquals(expRes, res);
    }

    @Test
    public void clear() {
        map.put("one", 1);
        map.put("ttt", 3);
        map.put("sdfghjk", 7);

        int expSize = 0;
        map.clear();
        int size = map.size();
        assertEquals(size, expSize);
    }

    @Test
    public void containsValue() {
        map.put("first", 1);
        boolean expRes = true;
        boolean res = map.containsValue(1);
        assertEquals(expRes, res);
    }

    @Test
    public void containsInvalidValue() {
        map.put("hhhh", 1);
        boolean expRes = false;
        boolean res = map.containsValue(6);
        assertEquals(expRes, res);
    }

    @Test
    public void putElement() {
        map.put("first", 1);
        int expRes = 1;
        int res = map.put("first", 2);
        assertEquals(expRes, res);
    }

    @Test
    public void removeElement() {
        map.put("first", 1);
        int expSize = 0;
        map.remove("first");
        int size = map.size();
        assertEquals(expSize, size);
    }

}
