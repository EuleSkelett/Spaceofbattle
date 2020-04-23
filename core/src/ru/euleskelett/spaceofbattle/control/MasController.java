package ru.euleskelett.spaceofbattle.control;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

import ru.euleskelett.spaceofbattle.view.GameScreen;

public class MasController {
    private float speed, velosity = 0.2f, speedMax = 3f;
    private float rotationSpeed = 1f;

    private Polygon masBounds;
    public MasController(Polygon masBounds){
        this.masBounds = masBounds;
    }
// все что связанно со скоростью


    public void handle(){
        // движение вперед назад
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            speed += velosity* GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            speed -= velosity* GameScreen.deltaCff;
        else
            downSpeed();

        speed = sliceSpeed();
        //
        // отвечает за повороты
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            masBounds.rotate(rotationSpeed * GameScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            masBounds.rotate(-rotationSpeed * GameScreen.deltaCff);


        masBounds.setPosition(masBounds.getX() + MathUtils.cosDeg(masBounds.getRotation() + 90) * speed * GameScreen.deltaCff,
                masBounds.getY() + MathUtils.sinDeg(masBounds.getRotation() + 90) * speed * GameScreen.deltaCff);
    }
// гасим скорость
    private void downSpeed() {
        if (speed > velosity* GameScreen.deltaCff)
            speed -= velosity* GameScreen.deltaCff;
        if (speed < -velosity* GameScreen.deltaCff)
            speed += velosity* GameScreen.deltaCff;
        else
            speed = 0f;
    }
// Ограничеваем скорость
    private float sliceSpeed(){
        if (speed > speedMax)
            return speedMax;
        if (speed < -speedMax)
            return -speedMax;
        return speed;
    }
}
