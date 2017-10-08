package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Game.main.Game;
import com.Game.main.GameObject;
import com.Game.main.HUD;
import com.Game.main.Handler;
import com.Game.main.ID;

public class Player1 extends GameObject{
	public static int speed = 5;
	Handler handler;
	boolean Hit = true;
	public Player1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler =  handler;
	}
	public Rectangle getbounds() {
		return new Rectangle(x, y, 32, 32);
	}
	public void tick() {
		x += velX;
		y += velY;
		x = Game.clamp(x, 0, Game.WIDTH - 49);
		y = Game.clamp(y, 0, Game.HEIGHT - 72);
		collision();
	}
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy){
				if(getbounds().intersects(tempObject.getbounds()))
					//collision code
					HUD.P1HEALTH -= 2;
			}
		}
	}
	//default size is 32
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, getSizeX(), getSizeY());
	}
}
