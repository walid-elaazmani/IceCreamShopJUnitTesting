package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    
    private double ballprice;
    private double rocketprice;
    private double magnumStandardPrice;
    
    public PriceList(){
        
    }

    public PriceList(double ballprice, double rocketprice, double magnumStandardPrice) {
        this.ballprice = ballprice;
        this.rocketprice = rocketprice;
        this.magnumStandardPrice = magnumStandardPrice;
    }



    public void setBallprice(double ballprice) {
        this.ballprice = ballprice;
    }

    public void setRocketprice(double rocketprice) {
        this.rocketprice = rocketprice;
    }


    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }


    public double getBallprice() {
        return ballprice;
    }

    

    public double getRocketprice() {
        return rocketprice;
    }
    

    public double getMagnumPrice(Magnum.MagnumType type) {
        switch (type){
            case ALPINENUTS:
                return magnumStandardPrice * 1.5;
            case BLACKCHOCOLATE:
                return magnumStandardPrice * 1.2;
            case MILKCHOCOLATE:
                return magnumStandardPrice * 1.3;
            case WHITECHOCOLATE:
                return magnumStandardPrice * 1.4;
            case ROMANTICSTRAWBERRIES:
                return magnumStandardPrice * 2.0;
            default:
                return magnumStandardPrice;
        }
    }

    
}
