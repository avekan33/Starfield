import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] stars;
public void setup()
{
	size(700,700);
	stars = new Particle[1000];
	for(int i=0;i<stars.length-2;i++)
	{
		stars[i] = new NormalParticle();
	}
	stars[stars.length-1] = new OddballParticle();
	stars[stars.length-2] = new JumboParticle();

}
public void draw()
{
	background(0);
	for(int i=0;i<stars.length;i++)
	{
		stars[i].move();
		stars[i].show();
		stars[i].speedup();
		stars[i].reset();
	}
}
class NormalParticle implements Particle
{
	int pColor,siz;
	double x,y,speed,angle;
	NormalParticle()
	{
		x = 325+(int)(Math.random()*50);
		y = 325+(int)(Math.random()*50);
		speed = Math.random()*4;	
		angle = Math.random()*2*Math.PI;
		pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
		siz = 5;
	}
	public void move()
	{
		x += Math.cos(angle)*speed;
		y += Math.sin(angle)*speed;

	}
	public void show()
	{
		fill(pColor);
		ellipse((float)x,(float)y,siz,siz);
	}
	public void speedup()
	{
		if(mousePressed)
		{
			if(mouseButton == LEFT)
			{
				speed += 1;
			}
			else if(mouseButton == RIGHT)
			{
				speed -= 1;
			}
		}
	}
	public void reset()
	{
		if(key == 'r')
		{
			x = 0+(int)(Math.random()*700);
			y = 0+(int)(Math.random()*700);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
		}
		else if(key == 't')
		{
			x = 340+(int)(Math.random()*5);
			y = 340+(int)(Math.random()*5);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));			
		}
		else if(key == 'b')
		{
			x = 325+(int)(Math.random()*50);
			y = 325+(int)(Math.random()*50);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
		}
	}
}
interface Particle
{
	//your code here
	public void move();
	public void show();
	public void speedup();
	public void reset();
		
	
}
class OddballParticle implements Particle
{
	//your code here
	int pColor;
	double x,y,speed,angle;
	OddballParticle()
	{
		x = 325+(int)(Math.random()*50);
		y = 325+(int)(Math.random()*50);
		speed = Math.random()*4;	
		angle = Math.random()*2*Math.PI;
		pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
	}
	public void move()
	{
		x += Math.cos(angle)*speed/2;
		y += Math.sin(angle)*speed/2;

	}
	public void show()
	{
		fill(pColor);
		rect((float)x,(float)y,8,8);
	}
	public void speedup()
	{
		if(mousePressed)
		{
			if(mouseButton == LEFT)
			{
				speed += 1;
			}
			else if(mouseButton == RIGHT)
			{
				speed -= 1;
			}
		}
	}
	public void reset()
	{
		if(key == 'r')
		{
			x = 0+(int)(Math.random()*700);
			y = 0+(int)(Math.random()*700);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
		}
		else if(key == 't')
		{
			x = 340+(int)(Math.random()*5);
			y = 340+(int)(Math.random()*5);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));			
		}
		else if(key == 'b')
		{
			x = 325+(int)(Math.random()*50);
			y = 325+(int)(Math.random()*50);
			speed = Math.random()*4;	
			angle = Math.random()*2*Math.PI;
			pColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));	
		}
	}
}
class JumboParticle extends NormalParticle
{
	JumboParticle()
	{
		siz = 20;
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
