package be.intecbrussel.sellers;


import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamCarTest {
    PriceList priceList;

    @BeforeEach
    void initialization(){
        priceList = new PriceList(1,1,1);

    }

    @Test
    void IfNoFlavorsLeftReturnsNull(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(0,1,0,0));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA}));
    }

    @Test
    void IfNoConesLeftReturnsNull(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(0,0,1,0));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA}));
    }

    @Test
    void IfEnoughConesAndFlavorsIsNotNullAndPriceIsRight(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(0,1,3,0));

        Cone isThisConeNullShouldNotBe = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.MOKKA, Cone.Flavor.LEMON});

        // price per ball = 0.25
        double expectedProfit = 0.75;
        double actualProfit = iceCreamCar.getProfit();

        assertEquals(expectedProfit, actualProfit);
        assertNotNull(isThisConeNullShouldNotBe);
    }

    @Test
    void IfEnoughMagniIsNotNullAndPriceIsRightElseReturnsNull(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(0,0,0,1));

        Magnum thisMagnumShouldBePresent = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        // Before Consuming Magnum
        double expectedProfit = 0.015;
        double actualProfit = iceCreamCar.getProfit();

        assertEquals(expectedProfit, actualProfit);
        assertNotNull(thisMagnumShouldBePresent);

        // No Cone left
        Magnum thisMagnumShouldNotBePresent = iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        actualProfit = iceCreamCar.getProfit();

        assertEquals(expectedProfit, actualProfit);
        assertNull(thisMagnumShouldNotBePresent);
    }


    @Test
    void IfEnoughRocketsIsNotNullAndPriceIsRightElseReturnsNull(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(1,0,0,1));

        IceRocket thisRocketShouldBePresent = iceCreamCar.orderIceRocket();

        // Before Consuming Magnum
        double expectedProfit = 0.2;
        double actualProfit = iceCreamCar.getProfit();

        assertEquals(expectedProfit, actualProfit);
        assertNotNull(thisRocketShouldBePresent);

        // No Cone left
        IceRocket thisRocketShouldNotBePresent = iceCreamCar.orderIceRocket();

        actualProfit = iceCreamCar.getProfit();

        assertEquals(expectedProfit, actualProfit);
        assertNull(thisRocketShouldNotBePresent);
    }

    @Test
    void profitRemainsZeroIfStockIsZero(){

        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(0,0,0, 0));

        iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        iceCreamCar.orderIceRocket();
        iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.MOKKA, Cone.Flavor.LEMON});

        assertEquals(0.0, iceCreamCar.getProfit());
    }


    @Test
    void whenAddingDifferentIceCreamsTheProfitShouldBeCorrect(){
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, new Stock(1,1,3, 2));

        iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES); // + 0.02
        iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES); // + 0.02
        iceCreamCar.orderIceRocket(); // + 0.2
        iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.MOKKA, Cone.Flavor.LEMON}); // + 0.75

        assertEquals(0.99, iceCreamCar.getProfit());
    }











} 