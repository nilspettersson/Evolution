import java.util.ArrayList;

import org.joml.Vector4f;

import niles.lwjgl.loop.Layer;

public class Animal {
	
	double angle;
	double speed = 1;
	
	double timeAlive;
	
	int index;
	
	public Animal(int index) {
		this.index = index;
		angle = (Math.random() * Math.PI * 2);
		timeAlive = 0;
	}
	
	public void update(Layer animalLayer, ArrayList<Animal> animals) {
		angle+=0.01;
		timeAlive++;
		
		if(timeAlive > 100) {
			animalLayer.addEntity(animalLayer.getX(index), animalLayer.getY(index), 10, 10, new Vector4f(1), 0);
			animals.add(new Animal(animals.size()));
			
			timeAlive = 0;
		}
	}
	
	public float getXVel() {
		return (float) (Math.cos(angle) * speed);
	}
	public float getYVel() {
		return (float) (Math.sin(angle) * speed);
	}

}
