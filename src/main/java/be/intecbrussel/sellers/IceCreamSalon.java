package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList priceList;
    private double totalProfit;


    public IceCreamSalon(PriceList priceList) {
        this.totalProfit = 0;
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone cone = new Cone(flavors);
        totalProfit += priceList.getBallprice() * flavors.length * 0.25;
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket icerocket = new IceRocket();
        totalProfit += priceList.getRocketprice() * 0.20;
        return icerocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum();
        totalProfit += priceList.getMagnumPrice(type)* 0.01;
        return magnum;
    }


    @Override
    public double getProfit() {
        return totalProfit;
    }
}
