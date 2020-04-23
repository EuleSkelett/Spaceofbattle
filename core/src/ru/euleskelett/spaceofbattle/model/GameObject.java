package ru.euleskelett.spaceofbattle.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    private Rectangle bouds;
    private Sprite object;
    public GameObject(Texture texture, float x, float y, float width, float height){
        bouds = new Rectangle(x, y, width, height);
        object = new Sprite(texture);
    }
    public void draw(SpriteBatch batch){
        object.setBounds(bouds.getX(), bouds.getY(), bouds.getWidth(), bouds.getHeight());
        object.draw(batch);
    }
}
