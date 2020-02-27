package com.my.demo5.proxy;


public class WandPo implements KindWomen {

    private KindWomen mkindWomen;

    public WandPo(KindWomen mkindWomen) {
        this.mkindWomen = mkindWomen;
    }

    @Override
    public void makeEyesWithMan() {
        if(mkindWomen !=null){
            mkindWomen.makeEyesWithMan();
        }
    }

    @Override
    public void happyWithMan() {
         if (mkindWomen!=null){
             mkindWomen.happyWithMan();
         }
    }
}
