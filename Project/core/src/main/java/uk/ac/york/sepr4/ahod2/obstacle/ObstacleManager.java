package uk.ac.york.sepr4.ahod2.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
/***
 * NEW
 *used to input the info of obstacles from json file and generate the obstacles
 */
public class ObstacleManager {
    private final NavigableMap<Double, Obstacle> map = new TreeMap<>();
    private double weights = 0;

    public ObstacleManager(){
        Json json = new Json();
        Array<Obstacle> obstacles = json.fromJson(Array.class, Obstacle.class, Gdx.files.internal("data/obstacle.json"));
        obstacles.forEach(obstacle -> {
            weights += obstacle.getChance();
            map.put(weights, obstacle);

            Gdx.app.log("EncounterManager", "Loaded " + obstacles.size + " encounters!");
        });
    }

    /***
     * used to generate Obstacles randomly
     * @return obstacle generated
     */
    public Obstacle generateObstacle(){
        Random random = new Random();
        Double key = random.nextDouble()*weights;
        return map.higherEntry(key).getValue();
    }
}
