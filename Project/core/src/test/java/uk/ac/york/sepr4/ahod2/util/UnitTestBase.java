package uk.ac.york.sepr4.ahod2.util;

import uk.ac.york.sepr4.ahod2.AHOD2;
import uk.ac.york.sepr4.ahod2.GameInstance;
import uk.ac.york.sepr4.ahod2.object.ShipFactory;
import uk.ac.york.sepr4.ahod2.object.entity.Ship;
import uk.ac.york.sepr4.ahod2.screen.BattleScreen;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UnitTestBase {

    @Test
    public void testPoints(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        ShipFactory myFactory = new ShipFactory();
        Ship EnemyShip = myFactory.generateEnemyShip(1);
        BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);

        int PointsBefore = myInstance.getPlayer().getScore();
        System.out.println("Score = " + myInstance.getPlayer().getScore());
        System.out.println("Player Health = " + myInstance.getPlayer().getShip().getHealth());
        System.out.println("Enemy Health = " + EnemyShip.getHealth());
        myBattle.myBattle();
        int PointsAfter = myInstance.getPlayer().getScore();
        System.out.println("Score = " + myInstance.getPlayer().getScore());
        System.out.println("Player Health = " + myInstance.getPlayer().getShip().getHealth());
        System.out.println("Enemy Health = " + EnemyShip.getHealth());
        assertNotEquals(PointsBefore, PointsAfter, "Holy crap I did it");
    }

}
