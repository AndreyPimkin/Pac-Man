package info.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.game.PacManGame;
import info.game.sprites.Ghost;
import info.game.sprites.PacMan;

public class PlayState extends State {

    private PacMan pacMan;
    private Texture bg;
    private Ghost ghost;
    private String pacManOrin = "RIGHT";
    public static final int GHOST_MOVE = 10;



    public PlayState(GameStateManager gsm) {
        super(gsm);
        pacMan = new PacMan(825,25); // позиция
        bg = new Texture("Picture/playBackground.jpg");
        ghost = new Ghost(PacManGame.WIDTH/2 -35/2, 275);
       // camera.setToOrtho(false, 25, 25);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pacManOrin = "LEFT";
            pacMan.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            pacManOrin = "RIGHT";
            pacMan.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            pacManOrin = "UP";
            pacMan.moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pacManOrin = "DOWN";
            pacMan.moveDown();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        pacMan.update(dt);

        for(int i = 0; i < 100; i++){
            ghost.reposition();

        }


    }

    @Override
    public void render(SpriteBatch sb) {
       // sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, 0, 0); // фон для второго экрана
        switch (pacManOrin) {
            case "RIGHT":
                sb.draw(pacMan.getPacManRight(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
            case "LEFT":
                sb.draw(pacMan.getPacManLeft(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
            case "UP":
                sb.draw(pacMan.getPacManUp(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
            case "DOWN":
                sb.draw(pacMan.getPacManDown(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
        }



        sb.draw(ghost.getGhostOne(), ghost.getPosGhostOne().x, ghost.getPosGhostOne().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
