package com.mygdx.game.Base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Math.Rect;

public class Sprite extends Rect {

    protected float angle;
    protected float scale = 1;

    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region) {
         regions = new TextureRegion[1];
         regions[0] = region;
    }

    public void resize(Rect worldBound){

    }

    public void update(float deltaTime){

    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void draw(SpriteBatch batch){
        batch.draw(
                regions[frame],getLeft(),getBottom(),
                halfWidth,halfHeight,getWidth(),getHeight(),
                scale,scale,angle
        );

    }

    public boolean touchDown(Vector2 touch, int pointer, int button){
        return false;
    }

    public boolean touchUp(Vector2 touch,int pointer, int button){
        return false;
    }

    public void setHeightProportion(float height){
        setHeight(height);
        float aspect = regions[frame].getRegionWidth()/(float) regions[frame].getRegionHeight();
        setWidth(height*aspect);
    }
}
