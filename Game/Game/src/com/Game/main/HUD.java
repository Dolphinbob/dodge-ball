package com.Game.main;

import java.awt.Color;
import java.awt.Graphics;

import com.Game.main.Game.STATE;

public class HUD {
	private Game game;
	private Handler handler;
	public HUD(Game game, Handler handler){
		this.handler = handler;
		this.game = game;
	}
	public static int P1HEALTH = 100;
	public static int P2HEALTH = 100;
	private int greenValue1 = 255;
	private int greenValue2 = 255;

	public void tick(){
		P1HEALTH = Game.clamp(P1HEALTH, 0, 100);
		P2HEALTH = Game.clamp(P2HEALTH, 0, 100);
		greenValue1 = Game.clamp(greenValue1, 0, 255);
		greenValue1 = P1HEALTH * 2;
		greenValue2 = Game.clamp(greenValue2, 0, 255);
		greenValue2 = P2HEALTH * 2;
		if(P1HEALTH <= 0)
		{
			P1HEALTH = 100;
			P2HEALTH = 100;
			handler.clearAll();
			game.gameState = STATE.Menu;
		}
		else if(P2HEALTH <= 0)
		{
			P1HEALTH = 100;
			P2HEALTH = 100;
			handler.clearAll();
			game.gameState = STATE.Menu;
		}
	}

	
	public void render(Graphics g){
		
		g.setColor(Color.black);
		g.fillRect(15, 15, 200, 32);
		g.fillRect(410, 15, 200, 32);
		g.drawRect(14, 14, 201, 33);
		g.drawRect(409, 14, 201, 33);
		g.setColor(new Color(75, greenValue1, 0));
		g.fillRect(15, 15, P1HEALTH * 2, 32);
		g.setColor(new Color(75, greenValue2, 0));
		g.fillRect(410, 15, P2HEALTH * 2, 32);
		

	}


	
}

