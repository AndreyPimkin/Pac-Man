package info.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    private Animation pacManAnimation;



    public TextureRegion getPacManLeft() {
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManRight() {
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManUp() {
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManDown() {
        return pacManAnimation.getFrame();
    }

    public PacMan(int x, int y) {
        position = new Vector3(x/ 2 - 35 / 2, 208, 0);
        pacManLeft = new Texture("Picture/leftFullPacMan.png");
        pacManRight = new Texture("Picture/rightFullPacMan.png");
        pacManUp = new Texture("Picture/upFullPacMan.png");
        pacManDown = new Texture("Picture/downFullPacMan.png");

        switch (PlayState.pacManOrin) {
            case "LEFT":
                pacManAnimation =new Animation(new TextureRegion(pacManLeft), 3, 0.5f);
                break;
            case "RIGHT":
                pacManAnimation =new Animation(new TextureRegion(pacManRight), 3, 0.5f);
                break;
            case "UP":
                pacManAnimation =new Animation(new TextureRegion(pacManUp), 3, 0.5f);
                break;
            case "DOWN":
                pacManAnimation =new Animation(new TextureRegion(pacManDown), 3, 0.5f);
                break;
        }
        pacManCube = new Rectangle(x/ 2 - 35 / 2, 208,35, 35);
    }

    public Vector3 getPosition() {
        return position;
    }
    public Rectangle getPacManCube(){
        return pacManCube;
    }


    public void update(float dt) {
        pacManAnimation.update(dt);

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
//////////////

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

//hjjjjjjjjjjjjjjjjjjjjjjj 178
        if (position.y > 150 && position.x < 523 && position.x > 267 && position.y < 205) {
            position.y = 205;
        }
        else if (position.y < 150 && position.x < 523 && position.x > 267 & position.y > 207) {
            position.x = 524;
        }
        if (position.y < 205 && position.y > 150 && position.x > 266 && position.x < 348) {
            position.x = 265;
        }
        else if (position.y < 205 && position.y > 150 && position.x < 524 && position.x > 477) {
            position.x = 525;
        }
//из-за чего не робит
        if (position.y > 177 && position.x < 523 && position.x > 267 && position.y < 205) {
            position.y = 205;
        }
        else if (position.y < 110 && position.x < 523 && position.x > 267 & position.y > 207) {
            position.x = 524;
        }


        pacManCube.setPosition(position.x, position.y);

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


    public void dispose() {
        pacManLeft.dispose();
        pacManRight.dispose();
        pacManUp.dispose();
        pacManDown.dispose();
    }
}
