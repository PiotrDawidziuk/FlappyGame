package com.piotrdawidziuk.flappygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyGame extends ApplicationAdapter {
	SpriteBatch batch;

	Texture background;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.end();


	}
}