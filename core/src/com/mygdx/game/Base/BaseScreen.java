package com.mygdx.game.Base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Math.MatrixUtils;
import com.mygdx.game.Math.Rect;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch batch;

    private Rect screenBound;
    private Rect worldBound;
    private Rect glBound;

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;

    private Vector2 touch;


    public void show() {
        batch = new SpriteBatch();

        screenBound = new Rect();
        worldBound = new Rect();
        glBound = new Rect(0,0,1f,1f);

        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();

        touch  = new Vector2();

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0.7f, 0.53f, 0.6f, 1);

    }

    @Override
    public void resize(int width, int height) {

        screenBound.setSize(width,height);
        screenBound.setLeft(0);
        screenBound.setBottom(0);

        float aspect = width/height;

        worldBound.setHeight(1f);
        worldBound.setWidth(1f*aspect);

        MatrixUtils.calcTransitionMatrix(worldToGl,worldBound,glBound);
        batch.setProjectionMatrix(worldToGl);
        resize(worldBound);

        MatrixUtils.calcTransitionMatrix(screenToWorld,screenBound,worldBound);

    }
    public void resize(Rect worldBound){

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBound.getHeight()-screenY).mul(screenToWorld);
        touchDown(touch, pointer, button);
        return false;
    }

    public boolean touchDown(Vector2 touch,int pointer, int button){
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, worldBound.getHeight()- screenY).mul(screenToWorld);
        touchUp(touch, pointer, button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, worldBound.getHeight()- screenY).mul(screenToWorld);
        touchDragged(touch,pointer);
        return false;
    }


    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}