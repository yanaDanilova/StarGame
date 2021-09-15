package com.mygdx.game.Pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Base.SpritePool;
import com.mygdx.game.Sprite.Explosion;

public class ExplosionPool extends SpritePool <Explosion>{

    private final TextureAtlas atlas;
    private final Sound explosionSound;

    public ExplosionPool(TextureAtlas atlas, Sound explosionSound) {
        this.atlas = atlas;
        this.explosionSound = explosionSound;
    }


    @Override
    protected Explosion newObject() {
       return new Explosion(atlas,explosionSound);
    }
}
