package info.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.TreeMap;

import info.game.states.GameStateManager;
import info.game.states.MenuState;

public class PacManGame extends ApplicationAdapter {
	public static final int WIDTH = 825;
	public static final int HEIGHT = 525;
	public static final int SPEED = 2;
	public static final String TITLE = "Pac-Man";
	public static final String ICON = "Picture/icon.png";
	private GameStateManager gsm;
	private SpriteBatch batch;


	@Override
	public void create(){
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1,0,0,1);
		gsm.push(new MenuState(gsm));
	}
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime()); // обновляет экран в секундах
		gsm.render(batch); // отрисовка верхнего экрана в стеке


	}

}

