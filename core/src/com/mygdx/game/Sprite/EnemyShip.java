package com.mygdx.game.Sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Ship;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Pool.BulletPool;

import com.mygdx.game.Pool.ExplosionPool;


public class EnemyShip extends Ship {


    private static final Vector2 START_V = new Vector2(0,-0.3f);
    public EnemyShip(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.bulletV = new Vector2();
        this.bulletPos = new Vector2();
        this.explosionPool = explosionPool;
    }

    @Override
    public void update(float delta) {
        if(getTop() < worldBounds.getTop()){
            v.set(v0);
        }else {
            reloadTimer = 0.8f * reloadInterval;
        }
        super.update(delta);
        this.bulletPos.set(pos.x, pos.y - getHalfHeight());
        if(getBottom() < worldBounds.getBottom()){
            destroy();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int bulletDamage,
            float reloadInterval,
            Sound bulletSound,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(bulletV);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.bulletSound = bulletSound;
        setHeightProportion(height);
        this.hp = hp;
        v.set(START_V);
        reloadTimer=0;
    }



    public boolean isCollision(Rect rect) {
        return !(
                rect.getRight() < getLeft()
                        || rect.getLeft() > getRight()
                        || rect.getBottom() > getTop()
                        || rect.getTop() < pos.y
        );
    }
}
