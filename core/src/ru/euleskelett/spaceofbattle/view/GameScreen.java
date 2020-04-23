package ru.euleskelett.spaceofbattle.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.euleskelett.spaceofbattle.model.Mas;

public class GameScreen implements Screen {
    private Texture masTexture;
    private SpriteBatch batch;
    private Mas mas;
    private OrthographicCamera camera;

    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        masTexture = new Texture(Gdx.files.internal("mas.png"));
        masTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        mas = new Mas(masTexture, 0, 0, 1f, 1f * 1.34f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mas.draw(batch);
        batch.end();
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
        masTexture.dispose();
        batch.dispose();
    }
}
