package uk.ac.york.sepr4.ahod2.object.entity;

import lombok.Data;
import uk.ac.york.sepr4.ahod2.node.Node;
import uk.ac.york.sepr4.ahod2.object.GameLevel;

import java.util.Optional;

/***
 * Class used to represent the player.
 * Holds data relating to player's progress through the game such as their level and location.
 */
@Data
public class Player {
    //new feature crew member, hold by an array
    public Integer[] crew = {0,0,0};
    private Ship ship;
    private Optional<Node> location = Optional.empty();
    private Integer gold = 100;
    private Integer score = 0;
    private GameLevel level;

    public Player(GameLevel gameLevel) {
        ship = new Ship();
        this.level = gameLevel;
        //set higher than default ship health
        ship.setMaxHealth(20);
        ship.setHealth(20);
    }

    //TODO: WIP
    public Integer getScore() {
        return score;
    }

    public void takeGold(Integer gold) {
        this.gold -= gold;
    }

    public void addGold(Integer gold) {
        this.gold += gold;
    }


    public Ship getShip(){
        return this.ship;
    }

    public void addScore(Integer score){this.score += score;}


}
