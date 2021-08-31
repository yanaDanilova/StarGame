package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;

public class MenuScreen extends BaseScreen {


    private static final float V_LENGTH = 0.3f;
    private Texture background;
    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Vector2 tmp;

    @Override
    public void show() {
        super.show();
        background = new Texture("background.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        v = new Vector2();
        touch = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        tmp.set(touch);
        if(tmp.sub(pos).len()>V_LENGTH) {
           pos.add(v);
        }
        else{
            pos.set(touch);
        }
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(img,pos.x,pos.y);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v = touch.cpy().sub(pos).setLength(V_LENGTH);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

}
