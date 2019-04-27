package uk.ac.york.sepr4.ahod2.util;

import uk.ac.york.sepr4.ahod2.AHOD2;
import uk.ac.york.sepr4.ahod2.GameInstance;
import uk.ac.york.sepr4.ahod2.object.ShipFactory;
import uk.ac.york.sepr4.ahod2.object.encounter.Encounter;
import uk.ac.york.sepr4.ahod2.object.encounter.EncounterManager;
import uk.ac.york.sepr4.ahod2.object.encounter.EncounterOption;
import uk.ac.york.sepr4.ahod2.object.entity.Player;
import uk.ac.york.sepr4.ahod2.object.entity.Ship;
import uk.ac.york.sepr4.ahod2.obstacle.Obstacle;
import uk.ac.york.sepr4.ahod2.screen.BattleScreen;
import org.junit.jupiter.api.Test;
import uk.ac.york.sepr4.ahod2.screen.EncounterScreen;
import uk.ac.york.sepr4.ahod2.screen.ObstacleScreen;

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
        //System.out.println("Score = " + myInstance.getPlayer().getScore());
        //System.out.println("Player Health = " + myInstance.getPlayer().getShip().getHealth());
        //System.out.println("Enemy Health = " + EnemyShip.getHealth());
        myBattle.myBattle();
        int PointsAfter = myInstance.getPlayer().getScore();
        //System.out.println("Score = " + myInstance.getPlayer().getScore());
        //System.out.println("Player Health = " + myInstance.getPlayer().getShip().getHealth());
        //System.out.println("Enemy Health = " + EnemyShip.getHealth());
        assertNotEquals(PointsBefore, PointsAfter, "I did it");
    }
/*
    @Test
    public void testAllPoints(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        //ShipFactory myFactory = new ShipFactory();
        //Ship EnemyShip = myFactory.generateEnemyShip(1);
        //BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);
        EncounterManager myEncManager = new EncounterManager();
        Encounter myNewEncounter = myEncManager.generateEncounter();


        EncounterOption myEncOption = new EncounterOption();
        myEncOption.setBattle(true);
        myEncOption.setDifficulty(1);
        myEncOption.setGold(100);
        myEncOption.setText("MyBattle");
        Encounter encounter = new Encounter();
        encounter.addOption(myEncOption);
        //EncounterScreen EncScreen = new EncounterScreen(myInstance, encounter);


        //EncScreen.optionClick(myEncOption);
    }*/

    @Test
    public void testObstaclesHealth(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        //ShipFactory myFactory = new ShipFactory();
        //Ship EnemyShip = myFactory.generateEnemyShip(1);
        Player myPlayer = myInstance.getPlayer();

        Obstacle myOb = new Obstacle();
        myOb.setId(1);
        myOb.setName("Whirlpool");
        myOb.setText("you have met a whirlpool, try to escape!!!");
        myOb.setChance(5d);
        myOb.setHealth(-5);
        myOb.setEscapeChance(0d);
        myOb.setRemoveCrew(false);
        int myPHealthBef = myPlayer.getShip().getHealth();
        ObstacleScreen myObSc = new ObstacleScreen(myInstance, myOb);
        int myPHealthAft = myPlayer.getShip().getHealth();
        System.out.println("Health Before =" + myPHealthBef);
        System.out.println("Health After =" + myPHealthAft);
        assertNotEquals(myPHealthBef, myPHealthAft, "Health difference test");

    }

    @Test
    public void testObstaclesCrew(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        //ShipFactory myFactory = new ShipFactory();
        //Ship EnemyShip = myFactory.generateEnemyShip(1);
        //BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);


        Obstacle myOb = new Obstacle();
        myOb.setId(1);
        myOb.setName("Scurvy");
        myOb.setText("Your crew member has got scurvy, try to Cure!!!");
        myOb.setChance(5d);
        myOb.setHealth(0);
        myOb.setEscapeChance(0d);
        myOb.setRemoveCrew(true);

        myInstance.getPlayer().crew[0] = myInstance.getPlayer().crew[0] +1;

        int TotalBefore = myInstance.getPlayer().crew[0];
        ObstacleScreen myObSc = new ObstacleScreen(myInstance, myOb);
        int TotalAfter = myInstance.getPlayer().crew[0];
        System.out.println("Crew before =" + TotalBefore);
        System.out.println("Crew after =" + TotalAfter);
        assertNotEquals(TotalBefore, TotalAfter, "Crew remove test");
    }


    @Test
    public void testCrewCarpenterEffect(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        ShipFactory myFactory = new ShipFactory();
        Ship EnemyShip = myFactory.generateEnemyShip(1);
        BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);
        myInstance.getPlayer().crew[0] = myInstance.getPlayer().crew[0] +1;
        int HealthBefore = myInstance.getPlayer().getShip().getHealth();
        myBattle.myBattle();
        int HealthAfter = myInstance.getPlayer().getShip().getHealth();
        System.out.println("Health Before =" + HealthBefore);
        System.out.println("Health After =" + HealthAfter);
        assertNotEquals(HealthBefore, HealthAfter, "I did it");
    }

    @Test
    public void testMasterGunnerEffect(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        ShipFactory myFactory = new ShipFactory();
        Ship EnemyShip = myFactory.generateEnemyShip(1);
        BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);
        myInstance.getPlayer().crew[1] = myInstance.getPlayer().crew[1] +1;
        myBattle.setTurnNo(15);
        //myBattle.setDrawCost(5);
        myBattle.getCardDrawCost();
        int ActualDrawCost = myBattle.getDrawCost();
        myBattle.getCardDrawCost();
        System.out.println("Expected cost at turn 15: " + 5);
        System.out.println("Actual cost with 1 master gunner at turn 15: " + myBattle.getDrawCost());
        //myBattle.myBattle();
        //int HealthAfter = myInstance.getPlayer().getShip().getHealth();
        assertNotEquals(ActualDrawCost, 5, "I did it");
    }

    @Test
    public void testQuartermasterEffect(){
        AHOD2 myAHOD = new AHOD2();
        GameInstance myInstance = new GameInstance(myAHOD);
        ShipFactory myFactory = new ShipFactory();
        Ship EnemyShip = myFactory.generateEnemyShip(1);
        BattleScreen myBattle = new BattleScreen(myInstance, EnemyShip, 1, 0, 100);
        myInstance.getPlayer().crew[2] = myInstance.getPlayer().crew[2] +1;
        int GoldBefore = myInstance.getPlayer().getGold();
        int GoldReward = myBattle.getGold();
        myBattle.myBattle();
        int GoldAfter = myInstance.getPlayer().getGold();
        System.out.println("Gold Before =" + GoldBefore);
        System.out.println("Gold Reward =" + GoldReward);
        System.out.println("Gold After =" + GoldAfter);
        assertNotEquals((GoldBefore+GoldReward), GoldAfter, "I did it");
    }

}
