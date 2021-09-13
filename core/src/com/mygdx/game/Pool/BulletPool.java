package com.mygdx.game.Pool;


import com.mygdx.game.Base.SpritePool;
import com.mygdx.game.Sprite.Bullet;

public class BulletPool extends SpritePool <Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }


}
