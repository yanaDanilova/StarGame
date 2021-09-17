package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Base.BaseButton;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Screen.GameScreen;

public class NewGameButton extends BaseButton {
    private static final float HEIGHT = 0.05f;
    private static final float TOP_MARGIN = -0.012f;

    private GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setTop(TOP_MARGIN);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
