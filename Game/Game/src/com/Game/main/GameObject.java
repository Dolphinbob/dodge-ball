package com.Game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected int sizeY = 32;
	protected int sizeX = 32;

	

	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getbounds();
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
	public void setSizeX(int SizeX){
		this.sizeX = SizeX;
	}
	
	public void setSizeY(int sizeY){
		this.sizeY = sizeY;
	}
	
	public int getSizeX(){
		return sizeX;
	}
	
	public int getSizeY(){
		return sizeY;
	}
	

}
