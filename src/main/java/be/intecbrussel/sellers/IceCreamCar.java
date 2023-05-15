package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;

public class IceCreamCar implements IceCreamSeller {
    private PriceList priceList;

    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }


    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone check = prepareCone(flavors);
        if(check != null){
             profit += priceList.getRocketprice() * flavors.length * 0.25;
        }
        return check;
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {

        if (stock.getCones() <= 0 || stock.getBalls() <= 0 || flavors.length > stock.getBalls()) {
            System.out.println("No more Cones");
            return null;
        } else {
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);
            return new Cone(flavors);
        }

    }

    @Override
    public IceRocket orderIceRocket() {
        
        IceRocket check = prepareIceRocket();

        if(check != null){
             profit += priceList.getRocketprice() * 0.20;
        }
        return check;
    }

    private IceRocket prepareIceRocket() {
        if (stock.getIceRockets() <= 0){
            System.out.println("No more icerockets");
            return null;
        } else {
            stock.setIceRockets(stock.getIceRockets() - 1);
            return new IceRocket();
        }
    }


    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
         Magnum check = prepareMagnum(type);
        if(check != null){
             profit += priceList.getMagnumPrice(type) * 0.01;
        }
        return check;
    }
   
    private Magnum prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() <= 0) {
            System.out.println("No more magni");
            return null;
        } else {
            stock.setMagni(stock.getMagni() - 1);
            return new Magnum(type);
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }


}
