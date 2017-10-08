package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.Game.main.Game;
import com.Game.main.GameObject;
import com.Game.main.Handler;
import com.Game.main.ID;

public class BasicEnemy extends GameObject{
	int SizeX = 16;
	int SizeY = 16;
	Handler handler;
	

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		Random r = new Random();

		if(Game.isEnemySpeedRandom == true){
			velX = r.nextInt(Game.enemySpeedX + 1);
			velY = r.nextInt(Game.enemySpeedY + 1);
		}else{		
			velX = Game.enemySpeedX;
			velY = Game.enemySpeedY;
		}
		
		if(velX <= 0){
			velX = 1;
		}
		if(velY <= 0){
			velY = 1;
		}
		System.out.println("velX = " + velX);
		System.out.println("velY = " + velY);


	}
	
	public Rectangle getbounds() {
		return new Rectangle(x, y, SizeX, SizeY);
	}
	
	


	
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 51) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, SizeX, SizeY);
	}
	

	
	
	
	

}
