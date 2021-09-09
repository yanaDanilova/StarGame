package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.Sprite.Logo;

public class MenuScreen extends BaseScreen {



    private Texture bg;
    private Texture img;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("background.jpg");
        img = new Texture("badlogic.jpg");
        background = new Background(bg);
        logo = new Logo(img);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
       draw();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch,pointer,button);
        return false;
    }

    @Override
    public void resize(Rect worldBound) {
        super.resize(worldBound);
        background.resize(worldBound);
        logo.resize(worldBound);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();

    }
    public void update(float delta){
        logo.update(delta);
    }

    public void draw(){
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

}
