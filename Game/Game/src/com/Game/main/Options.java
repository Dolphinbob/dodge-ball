package com.Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.Game.main.Game.STATE;

public class Options extends MouseAdapter{

	private Game game;
	private Handler handler;
	public Options(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(20, 20, 130, 50);
		Font btnFnt = new Font("arial", 1, 40);
		Font Fnt = new Font("arial", 1, 90);
		g.setFont(btnFnt);
		g.drawString("Back", 36, 60);
		g.setFont(Fnt);
		g.drawString("Coming Soon", 20, 250);
	}
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(mouseOver(mx, my, 20, 20, 130, 50)){
			game.gameState = STATE.Menu;
		}
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

}
