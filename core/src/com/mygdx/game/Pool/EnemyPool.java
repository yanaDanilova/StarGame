package com.mygdx.game.Pool;


import com.mygdx.game.Base.SpritePool;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Sprite.EnemyShip;

public class EnemyPool extends SpritePool<EnemyShip> {

    private final BulletPool bulletPool;
    private final Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, worldBounds);
    }
}
