package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.Math.Rect;

public class Logo extends Sprite {

    private static final float HEIGHT = 0.3f;
    private static final float V_LENGTH = 0.01f;
    private Vector2 v;
    private Vector2 touch;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        v = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void update(float deltaTime) {
        if(touch.dst(pos) > V_LENGTH){
            pos.add(v);
        } else{
            pos.set(touch);
        }

    }

    @Override
    public void resize(Rect worldBound) {
        setHeightProportion(HEIGHT);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
    this.touch = touch;
    v.set(touch.cpy().sub(pos).setLength(V_LENGTH));
    return false;
    }
}
