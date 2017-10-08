package com.Game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import objects.Player1;
import objects.Player2;

public class KeyInput extends KeyAdapter
{
	

	private Handler handler;
	
	
	
		

	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player1)
			{
				//key events for Player
				if(key == KeyEvent.VK_W) tempObject.setVelY(-Player1.speed);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-Player1.speed);
				if(key == KeyEvent.VK_S) tempObject.setVelY(Player1.speed);
				if(key == KeyEvent.VK_D) tempObject.setVelX(Player1.speed);	
			}
			
			if(tempObject.getId() == ID.Player2)
			{
				//key events for Player
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-Player2.speed);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-Player2.speed);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(Player2.speed);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(Player2.speed);
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player1){
				//key events for Player1
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);

			}
			
			if(tempObject.getId() == ID.Player2){
				//key events for Player2
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);	
			}

		}
	}
}