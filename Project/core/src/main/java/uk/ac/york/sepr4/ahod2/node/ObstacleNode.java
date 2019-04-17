package uk.ac.york.sepr4.ahod2.node;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import uk.ac.york.sepr4.ahod2.GameInstance;
import uk.ac.york.sepr4.ahod2.io.FileManager;
import uk.ac.york.sepr4.ahod2.obstacle.Obstacle;
import uk.ac.york.sepr4.ahod2.screen.ObstacleScreen;

public class ObstacleNode extends Node {
    /***
     * new
     * Node type that creates department screen for specified department.
     * @param node
     */
    public ObstacleNode(Node node){
        super(node.getId(), node.getRow(), node.getCol());
        setConnected(node.getConnected());
        this.setTexture(new TextureRegionDrawable(new TextureRegion(FileManager.nodeIcon)));
    }

    /***
     * Switch current screen to obstacle screen.
     * @param gameInstance
     */

    @Override
    public void action(GameInstance gameInstance) {
        Obstacle obstacle = gameInstance.getObstacleManager().generateObstacle();
        gameInstance.fadeSwitchScreen(new ObstacleScreen(gameInstance, obstacle));
    }
}
