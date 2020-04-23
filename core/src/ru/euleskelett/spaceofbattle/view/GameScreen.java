package ru.euleskelett.spaceofbattle.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.euleskelett.spaceofbattle.model.Mas;
import ru.euleskelett.spaceofbattle.utils.UI;

public class GameScreen implements Screen {

    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private Mas mas;
    private OrthographicCamera camera;
    private UI ui;

    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        mas = new Mas(textureAtlas.findRegion("0"), 0, 0, 1f, 1f * 1.34f);
        ui = new UI();
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mas.draw(batch);
        batch.end();
        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRation = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRation);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        ui.dispose();
    }
}
