package info.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ghost {

    private Texture ghostOne;
    private Vector2 posGhostOne;
    private Rectangle ghostOneCube;

    public Texture getGhostOne() {
        return ghostOne;
    }

    public Vector2 getPosGhostOne() {
        return posGhostOne;
    }

    public Ghost(float x, float y){
        ghostOne = new Texture("Picture/ghostOne.png");
        posGhostOne = new Vector2(x, y);

        ghostOneCube = new Rectangle(posGhostOne.x, posGhostOne.y, ghostOne.getWidth(), ghostOne.getHeight());
    }

    public void  reposition(){
       if(posGhostOne.y <= 348){
           posGhostOne.y += 0.01;
        }
       if(posGhostOne.y >= 348 && posGhostOne.x >262){
           posGhostOne.x -= 0.01;
       }
       else if(posGhostOne.y >= 132 && posGhostOne.x < 262){
           posGhostOne.y -= 0.02;
       }
       else if(posGhostOne.y <= 132 && posGhostOne.x > 50){
           posGhostOne.x -= 0.02;
       }
       ghostOneCube.setPosition(posGhostOne.x, posGhostOne.y);
    }

    public boolean collides(Rectangle player){
        return  player.overlaps((ghostOneCube));
    }

    public void dispose() {
        ghostOne.dispose();

    }
}
