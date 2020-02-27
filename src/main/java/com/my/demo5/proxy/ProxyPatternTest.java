package com.my.demo5.proxy;

public class ProxyPatternTest {

    public static void main(String[] args) {
        WandPo wandPo = new WandPo(new PanJinLian());
        System.out.println(wandPo.toString());
        wandPo.makeEyesWithMan();
        wandPo.happyWithMan();

        WandPo wandPo1 = new WandPo(new JiaShi());
        System.out.println(wandPo1.toString());
        wandPo1.makeEyesWithMan();
        wandPo1.happyWithMan();
    }
}
