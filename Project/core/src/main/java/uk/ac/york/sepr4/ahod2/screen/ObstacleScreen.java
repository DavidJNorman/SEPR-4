package uk.ac.york.sepr4.ahod2.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uk.ac.york.sepr4.ahod2.GameInstance;
import uk.ac.york.sepr4.ahod2.io.StyleManager;
import uk.ac.york.sepr4.ahod2.object.entity.Player;
import uk.ac.york.sepr4.ahod2.obstacle.Obstacle;

import java.util.Random;


public class ObstacleScreen extends AHODScreen {
    /***
     * new
     * where obstacle display and show the corresponding effect to the player, player have a chance to escape
     */
    Obstacle obstacle;
    GameInstance gameInstance;
    public ObstacleScreen(GameInstance gameInstance, Obstacle obstacle) {
        super(new Stage(new ScreenViewport(), new SpriteBatch()),
                new Texture(Gdx.files.internal("images/screen/encounter/" + obstacle.getBackground())));
        this.gameInstance = gameInstance;
        this.obstacle = obstacle;

        createObstacleInfo();
    }

    @Override
    public void renderInner(float delta) {

    }

    /***
     * new
     * create the obstacle info display to the user
     */
    public void createObstacleInfo(){
        Table table = new Table();
        table.setFillParent(true);
        table.top();

        Label obstacleText = new Label(obstacle.getText(), StyleManager.generateLabelStyle(65, Color.BLACK));
        table.add(obstacleText).expandX().padTop(Gdx.graphics.getHeight() / 4);
        String text = "TRY TO ESCAPE" + "\n\n" + "IF FAIL lOSE " + -obstacle.getHealth() + " HEALTH";
        TextButton tb = new TextButton(text,StyleManager.generateTBStyle(30, Color.BLACK, Color.GRAY));
        tb.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Random random = new Random();
                Double escape = random.nextDouble();
                System.out.println(escape);
                System.out.println(obstacle.getEscapeChance());
                if (escape > obstacle.getEscapeChance()){
                    Player player = gameInstance.getPlayer();
                    player.getShip().setHealth(player.getShip().getHealth() + obstacle.getHealth());
                    if(player.getShip().getHealth() <= 0){
                        gameInstance.fadeSwitchScreen(new EndScreen(gameInstance, false));
                    }else{
                        gameInstance.fadeSwitchScreen(gameInstance.getSailScreen());
                    }
                }else {
                    gameInstance.fadeSwitchScreen(gameInstance.getSailScreen());
                }
            }
        });
        table.row();
        table.add(tb).padTop(Gdx.graphics.getHeight() / 8);

        getStage().addActor(table);
    }

}
