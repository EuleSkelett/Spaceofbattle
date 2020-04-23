package ru.euleskelett.spaceofbattle.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.euleskelett.spaceofbattle.control.MasController;


public class Mas extends GameObject{

    private MasController masController;
    public Mas(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        masController = new MasController(bouds);
    }
    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
        masController.handle();
    }
}
