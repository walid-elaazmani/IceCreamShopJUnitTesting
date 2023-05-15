package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) {


        PriceList priceList = new PriceList(1,1,1);
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);

        Cone.Flavor [] flavorsOrder1 = {};

        Magnum magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        Cone cone = iceCreamSeller.orderCone(flavorsOrder1);

        IceRocket iceRocket = iceCreamSeller.orderIceRocket();

        Eatable [] eatables = {magnum, cone, iceRocket};

        for (Eatable eatable : eatables) {
            eatable.eat();
        }

        System.out.println(iceCreamSeller.getProfit());

        






    }
}
