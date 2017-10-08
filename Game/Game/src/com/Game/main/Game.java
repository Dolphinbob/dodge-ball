package com.Game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import objects.BasicEnemy;
import objects.Player1;
import objects.Player2;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 6396124708959442078L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Menu menu;
	private Options options;
	private boolean displayFPS = true;
	public static boolean isEnemySpeedRandom = true;
	//if the enemy speed is random the enemy speed X/Y is the max random number
	//Will default to 1 if it is equal to 0
	public static int enemySpeedX = 10;
	public static int enemySpeedY = 10;
	
	public enum STATE
	{
		Menu,
		Options,
		CountDown,
		P1Wins,
		P2Wins,
		Game;
	}

	public STATE gameState = STATE.P1Wins;

	public Game()
	{
		handler = new Handler();
		menu = new Menu(this, handler);
		options = new Options(this, handler);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseListener(options);
		new Window(WIDTH, HEIGHT, "Doge Ball",this);
		hud = new HUD(this, handler);
		r = new Random();
		if(gameState == STATE.Game)
		{
			handler.addObject(new Player2(WIDTH/2-32 + 50, HEIGHT/2-32, ID.Player2, handler));
			handler.addObject(new Player1(WIDTH/2-32 - 50, HEIGHT/2-32, ID.Player1, handler));
			for(int i = 0; i < 10; i ++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 35), r.nextInt(HEIGHT - 55), ID.BasicEnemy));				
			}
		}
	}
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				if(displayFPS == true)
				{
					System.out.println("FPS: " + frames);
				}
				frames = 0;
			}
		}
		stop();
	}
	private void tick()
	{
		handler.tick();
		if(gameState == STATE.Game)
		{
			hud.tick();
		}
		else if(gameState == STATE.Menu || gameState == STATE.P1Wins || gameState == STATE.P2Wins)
		{
			menu.tick();
		}else if(gameState == STATE.Options)
		{
			options.tick();
		}
	}
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if(gameState == STATE.Game)
		{
		hud.render(g);
		}
		else if(gameState == STATE.Menu || gameState == STATE.P1Wins || gameState == STATE.P2Wins)
		{
			menu.render(g);
		}
		else if(gameState == STATE.Options)
		{
			options.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var, int min, int max)
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	public static void main(String[] args) 
	{
		new Game();
	}

}
