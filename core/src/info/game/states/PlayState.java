package info.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.game.sprites.PacMan;

public class PlayState extends State {

    private PacMan pacMan;
    private Texture bg;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        pacMan = new PacMan(825,25); // позиция
        bg = new Texture("Picture/playBackground.jpg");
       // camera.setToOrtho(false, 25, 25);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pacMan.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            pacMan.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            pacMan.moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pacMan.moveDown();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        pacMan.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
       // sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, 0, 0); // фон для второго экрана
        sb.draw(pacMan.getPacMan(), pacMan.getPosition().x,pacMan.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
