package com.Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.Game.main.Game.STATE;

import objects.BasicEnemy;
import objects.Player1;
import objects.Player2;

public class Menu extends MouseAdapter
{
	private Game game;
	private Handler handler;
	Random r = new Random();
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e)
	{
		if(game.gameState == STATE.Menu)
		{
			int mx = e.getX();
			int my = e.getY();
			if(mouseOver(mx, my, Game.WIDTH / 2 - 100, 150, 200, 64)){
				game.gameState = STATE.Game;
				System.out.println("GameState Switched: Game");
				handler.addObject(new Player2(Game.WIDTH/2-32 + 50, Game.HEIGHT/2-32, ID.Player2, handler));
				handler.addObject(new Player1(Game.WIDTH/2-32 - 50, Game.HEIGHT/2-32, ID.Player1, handler));
				for(int i = 0; i < 10; i ++)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 35), r.nextInt(Game.HEIGHT - 55), ID.BasicEnemy));				
				}
			}
			else if(mouseOver(mx, my, Game.WIDTH / 2 - 100, 250, 200, 64))
			{
				game.gameState = STATE.Options;
			}
			else if(mouseOver(mx, my, Game.WIDTH / 2 - 100, 350, 200, 64))
			{
				System.exit(1);
			}
		}

	}
	
	
	public void mouseRelesed(MouseEvent e)
	{
		
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
	
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		if(game.gameState == STATE.Menu)
		{
			Font fnt  = new Font("arial", 1, 70);
			Font btnFnt = new Font("arial", 1, 40);
			g.setFont(fnt);
			g.setColor(Color.BLACK);
			g.drawString("MENU", Game.WIDTH / 2 - 105, 100);
			g.drawRect(Game.WIDTH / 2 - 100, 150, 200, 64);
			g.drawRect(Game.WIDTH / 2 - 100, 250, 200, 64);
			g.drawRect(Game.WIDTH / 2 - 100, 350, 200, 64);
			g.setFont(btnFnt);
			g.drawString("Play", Game.WIDTH / 2 - 38, 195);
			g.drawString("Options", Game.WIDTH / 2 - 73, 295);
			g.drawString("Quit", Game.WIDTH / 2 - 38, 395);
		}else if(game.gameState == STATE.P1Wins)
		{
			Font fnt  = new Font("arial", 1, 70);
			g.setFont(fnt);
			g.setColor(Color.BLACK);
			g.drawString("Player 1 Wins!", 85, 225);
			
			game.gameState = STATE.Menu;

		}
	}
}
