package com.example.test_libgdxintoandroid.Screens.GameVertical;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.test_libgdxintoandroid.LibGDXLaunchers.GameVertical;

public class GameOverScreenVertical implements Screen {
    private Viewport viewport;
    private Stage stage;
    private Game game;

    public GameOverScreenVertical(Game game){
        this.game = game;
        viewport = new FitViewport(GameVertical.V_WIDTH, GameVertical.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((GameVertical) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);


        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label gameOverLabel = new Label("GAME OVER", font);
        Label playAgainLabel = new Label("Vous avez encore UNE chance pour rejouer", font);

        table.add(gameOverLabel).expandX();
        table.row();
        table.add(playAgainLabel).expandX().padTop(10f);

        Image DefeatImg = new Image(new Texture("Skull_Defeat.png"));
        DefeatImg.setSize(50, 50);
        table.row().pad(30, 5, 5, 5);;
        table.add(DefeatImg).size(DefeatImg.getWidth(), DefeatImg.getHeight());

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreenVertical((GameVertical) game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
