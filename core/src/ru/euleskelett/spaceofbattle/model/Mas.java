package ru.euleskelett.spaceofbattle.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.euleskelett.spaceofbattle.control.MasController;


public class Mas extends GameObject{

    private MasController masController;
    public Mas(TextureRegion textureRegion, float x, float y, float width, float height) {
        super(textureRegion, x, y, width, height);
        masController = new MasController(bouds);
    }
    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
        masController.handle();
    }
}
