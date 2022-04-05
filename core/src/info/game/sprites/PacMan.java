package info.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.game.PacManGame;
import info.game.states.PlayState;

public class PacMan {
    private Vector3 position;
    private Texture pacManRight;
    private Texture pacManLeft;
    private Texture pacManUp;
    private Texture pacManDown;
    private Rectangle pacManCube;

    public Texture getPacManLeft() {
        return pacManLeft;
    }

    public Texture getPacManUp() {
        return pacManUp;
    }

    public Texture getPacManDown() {
        return pacManDown;
    }

    public PacMan(int x, int y) {
        position = new Vector3(PacManGame.WIDTH / 2 - 35 / 2, 208, 0);
        pacManRight = new Texture("Picture/pacManRight.png");
        pacManLeft = new Texture("Picture/pacManLeft.png");
        pacManUp = new Texture("Picture/pacManUp.png");
        pacManDown = new Texture("Picture/pacManDown.png");
        pacManCube = new Rectangle(PacManGame.WIDTH / 2 - 35 / 2, 208,35, 35);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPacManRight() {
        return pacManRight;
    }

    public void update(float dt) {
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > PacManGame.WIDTH - 35) {
            position.x = PacManGame.WIDTH - 35;
        }
        if (position.y < 111) {
            position.y = 111;
        }
        if (position.y > PacManGame.HEIGHT - 35) {
            position.y = PacManGame.HEIGHT - 35;
        }


        if (position.y > 242 && position.x < 523 && position.x > 267 && position.y < 277) {
            position.y = 277;
        }
        else if (position.y < 242 && position.x < 523 && position.x > 267 & position.y > 207) {
            position.y = 207;
        }

        if (position.y < 343 && position.y > 208 && position.x > 266 && position.x < 348) {
            position.x = 265;
        }
        else if (position.y < 343 && position.y > 208 && position.x < 524 && position.x > 477) {
            position.x = 525;
        }
        pacManCube.setPosition(position.x, position.y);

    }
    public Rectangle getPacManCube(){
        return pacManCube;
    }

    public void moveLeft() {
        position.x -= PacManGame.SPEED;
    }

    public void moveRight() {
        position.x += PacManGame.SPEED;
    }

    public void moveUp() {
        position.y += PacManGame.SPEED;
    }

    public void moveDown() {
        position.y -= PacManGame.SPEED;
    }


}
