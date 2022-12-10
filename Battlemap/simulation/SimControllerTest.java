package com.mycompany.gloomhaven.Battlemap.simulation;

import com.mycompany.gloomhaven.Battlemap.Maps.Map;
import com.mycompany.gloomhaven.Battlemap.Maps.Map1;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class SimControllerTest {

    @org.junit.jupiter.api.Test
    void main()
    {

        // make sure it loading the right class info, default map returned negative 1
        Map sim;
        sim = new Map1();

        int type = sim.getType(1,1);
        int name = sim.getName(1,1);
        int numUnits = sim.getNumUnits();
        int numNames = sim.getNumberOfEnemies();
        int x = sim.getSizeX();
        int y = sim.getSizeY();

        assertTrue(type >= 0);
        assertTrue(name >= 0);
        assertTrue(x >= 0);
        assertTrue(y >= 0);
        assertTrue(numNames >= 0);
        assertTrue(numUnits >= 0);
        assertTrue( sim.hasUnit(1,3));

    }


}