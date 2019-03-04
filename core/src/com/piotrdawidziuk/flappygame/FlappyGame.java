package com.piotrdawidziuk.flappygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class FlappyGame extends ApplicationAdapter {
	SpriteBatch batch;

	Texture background;

	Texture[] birds;
	int flapState =0;
	float birdY = 0;
	float velocity=0;

	int gamestate = 0;
	float gravity = 2;

	Texture topTube;
	Texture bottomTube;
	float gap = 400;

	float maxTubeOffset;
	Random randomGenerator;
	float tubeOffset;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2-birds[flapState].getHeight()/2;

		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");

		maxTubeOffset = Gdx.graphics.getHeight()/-gap/2-100;
		randomGenerator = new Random();
	}

	@Override
	public void render() {

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());



		if (gamestate!=0) {

			if (Gdx.input.justTouched()){
				velocity = -30;
				tubeOffset = (randomGenerator.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-gap);
			}

			batch.draw(topTube,Gdx.graphics.getWidth()/2-topTube.getWidth()/2,Gdx.graphics.getHeight()/2+gap/2 );
			batch.draw(bottomTube,Gdx.graphics.getWidth()/2-bottomTube.getWidth()/2,Gdx.graphics.getHeight()/2-gap/2-bottomTube.getHeight());


			if (birdY > 0 || velocity <0) {
				velocity = velocity + gravity;
				birdY -= velocity;
			}

		}else{

			if (Gdx.input.justTouched()){
				gamestate=1;
			}

		}

		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}


		batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2, birdY);
		batch.end();
	}
}