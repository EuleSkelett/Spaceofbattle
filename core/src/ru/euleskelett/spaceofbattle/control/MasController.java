package ru.euleskelett.spaceofbattle.control;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

import ru.euleskelett.spaceofbattle.view.GameScreen;

public class MasController {
    private float masSpeed, velosity = 10f, speedMax = 10f;
    private float rotationSpeed = 30f;

    private Polygon masBounds;
    public MasController(Polygon masBounds){
        this.masBounds = masBounds;
    }
// все что связанно со скоростью


    public void handle(){
        // движение вперед назад
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            masSpeed += velosity* GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            masSpeed -= velosity* GameScreen.deltaCff;
        else
            downSpeed();

        masSpeed = sliceSpeed();
        //
        // отвечает за повороты
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            masBounds.rotate(rotationSpeed * masSpeed * GameScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            masBounds.rotate(-rotationSpeed * masSpeed * GameScreen.deltaCff);


        masBounds.setPosition(masBounds.getX() + MathUtils.cosDeg(masBounds.getRotation() + 90) * masSpeed * GameScreen.deltaCff,
                masBounds.getY() + MathUtils.sinDeg(masBounds.getRotation() + 90) * masSpeed * GameScreen.deltaCff);
    }
// гасим скорость
    private void downSpeed() {
        if (masSpeed > velosity* GameScreen.deltaCff)
            masSpeed -= velosity* GameScreen.deltaCff;
       else if (masSpeed < -velosity* GameScreen.deltaCff)
            masSpeed += velosity* GameScreen.deltaCff;
        else
            masSpeed = 0f;
    }
// Ограничеваем скорость
    private float sliceSpeed(){
        if (masSpeed > speedMax)
            return speedMax;
        if (masSpeed < -speedMax)
            return -speedMax;
        return masSpeed;
    }
}
