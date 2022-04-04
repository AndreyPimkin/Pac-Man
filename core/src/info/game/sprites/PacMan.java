package info.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import info.game.PacManGame;

public class PacMan {
    private Vector3 position;
    private Texture pacMan;

    public PacMan(int x, int y) {
        position = new Vector3(PacManGame.WIDTH / 2 - 35 / 2, 208, 0);
        pacMan = new Texture("Picture/pacMan.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPacMan() {
        return pacMan;
    }

    public void update(float dt) {
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > PacManGame.WIDTH - 35) {
            position.x = PacManGame.WIDTH - 35;
        }
        if (position.y < 0) {
            position.y = 0;
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
