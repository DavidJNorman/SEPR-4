package uk.ac.york.sepr4.ahod2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uk.ac.york.sepr4.ahod2.GameInstance;
import uk.ac.york.sepr4.ahod2.io.FileManager;

/***
 * NEW
 * class used to make crew selection
 */
public class CrewSelectionScreen extends AHODScreen {

    private GameInstance gameInstance;
    private Texture crewOne;
    private TextureRegion crewOneRegion;
    private TextureRegionDrawable crewOneRegDraw;
    private Texture crewTwo;
    private TextureRegion crewTwoRegion;
    private TextureRegionDrawable crewTwoRegDraw;
    private Texture crewThree;
    private TextureRegion crewThreeRegion;
    private TextureRegionDrawable crewThreeRegDraw;
    public CrewSelectionScreen(GameInstance gameInstance){
        super(new Stage(new ScreenViewport()), FileManager.menuScreenBG);

        this.gameInstance = gameInstance;
        setStatsHUD(gameInstance);
        createSelectionTable();
    }

    /***
     * method used to display crew selection ui to player
     */
    public void createSelectionTable(){


        crewOne = new Texture(Gdx.files.internal("OneTest.png"));
        crewOneRegion = new TextureRegion(crewOne);
        crewOneRegDraw = new TextureRegionDrawable(crewOneRegion);

        crewTwo = new Texture(Gdx.files.internal("TwoTest.png"));
        crewTwoRegion = new TextureRegion(crewTwo);
        crewTwoRegDraw = new TextureRegionDrawable(crewTwoRegion);

        crewThree = new Texture(Gdx.files.internal("ThreeTest.png"));
        crewThreeRegion = new TextureRegion(crewThree);
        crewThreeRegDraw = new TextureRegionDrawable(crewThreeRegion);

        Table selectionTable = new Table();
        selectionTable.setFillParent(true);
        selectionTable.top();
        selectionTable.debug();



        ImageButton choiceOne = new ImageButton(crewOneRegDraw);
        ImageButton choiceTwo = new ImageButton(crewTwoRegDraw);
        ImageButton choiceThree = new ImageButton(crewThreeRegDraw);

        choiceOne.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent ev, float x, float y) {
                gameInstance.getPlayer().crew[0] = gameInstance.getPlayer().crew[0] +1;
                gameInstance.getMessageHUD().addCrewMessages(0, 1);
                gameInstance.advanceLevel();
            }
        });
        choiceTwo.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent ev, float x, float y) {
                gameInstance.getPlayer().crew[1] = gameInstance.getPlayer().crew[1] +1;
                gameInstance.getMessageHUD().addCrewMessages(1, 1);
                gameInstance.advanceLevel();
            }
        });
        choiceThree.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent ev, float x, float y) {
                gameInstance.getPlayer().crew[2] = gameInstance.getPlayer().crew[2] +1;
                gameInstance.getMessageHUD().addCrewMessages(2, 1);
                gameInstance.advanceLevel();
            }
        });
        selectionTable.add(choiceOne);
        selectionTable.add(choiceTwo);
        selectionTable.add(choiceThree);
        getStage().addActor(selectionTable);
    }

    @Override
    public void renderInner(float delta) {
    }
}
