package com.mygdx.game.Pool;


import com.mygdx.game.Base.SpritePool;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Sprite.EnemyShip;

public class EnemyPool extends SpritePool<EnemyShip> {

    private final ExplosionPool explosionPool;
    private final BulletPool bulletPool;
    private final Rect worldBounds;

    public EnemyPool(ExplosionPool explosionPool, BulletPool bulletPool, Rect worldBounds) {
        this.explosionPool = explosionPool;
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, explosionPool,worldBounds);
    }
}
