package com.my.demo5.adapter;

/**
 * Adapter继承源目标类，并且实现目标接口
 */
public class AdapterTest {
    /**
     * 这样Targetable接口的实现类就具有了Source类的功能，就解决了由于接口不兼容而导致类不能一起工作的问题。
     * @param args
     */
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Source());
        adapter.method1();
        adapter.mehtod2();
    }
}
