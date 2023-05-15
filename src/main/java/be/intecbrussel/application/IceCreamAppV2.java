package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

public class IceCreamAppV2 {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(1,1,1);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(100,3,30,110));

        Eatable[] eatables = {
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES),
                iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.LEMON, Cone.Flavor.MOKKA}),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.LEMON}),
                iceCreamCar.orderCone(new Cone.Flavor[]{}),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.STRATCIATELLE})
        };


        for (Eatable eatable : eatables) {
//            if(eatable != null) {
//                eatable.eat();
//            }

            eatable.eat();
        }

        System.out.format("%.2f € \n", iceCreamCar.getProfit());
    }
}
