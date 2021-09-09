package com.mygdx.game.Sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.Math.Rect;

public class MainShip extends Sprite {

    private boolean pressedLeft;
    private boolean pressedRight;

    private final Vector2 v0 = new Vector2(0.5f,0);
    private final Vector2 v = new Vector2();

    private static final float HEIGHT = 0.15f;
    private static final float BOTTOM_MARGIN = 0.05f;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"),1,2,2);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + BOTTOM_MARGIN);
    }
    public boolean keyDown(int keycode){
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = true;
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = true;
                moveRight();
                break;
        }
        return false;
    }


    public boolean keyUp(int keycode){
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = false;
                if (pressedRight) {
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = false;
                if (pressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
        }
        return false;
    }

    private void moveRight(){
        v.set(v0);
    }

    private void moveLeft(){
        v.set(v0).rotateDeg(180);
    }

    private void stop(){
        v.setZero();
    }
}
