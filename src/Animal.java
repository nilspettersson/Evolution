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
	
	public void update(Layer animalLayer, ArrayList<Animal> animals, Layer foodLayer) {
		angle+=0.01;
		timeAlive++;
		
		if(timeAlive > 1000) {
			animalLayer.addEntity(animalLayer.getX(index), animalLayer.getY(index), 10, 10, new Vector4f(1), 0);
			animals.add(new Animal(animals.size()));
			
			timeAlive = 0;
		}
		
		foodLayer.setColor(findClosestFood(animalLayer, animals, foodLayer), new Vector4f(0, 1, 0, 1));
		
	}
	
	public int findClosestFood(Layer animalLayer, ArrayList<Animal> animals, Layer foodLayer) {
		
		float minDist = 1000000;
		int closest = 0;
		for(int i = 0; i < foodLayer.size(); i++) {
			float Xdif = animalLayer.getX(index) - foodLayer.getX(i);
			float Ydif = animalLayer.getY(index) - foodLayer.getY(i);
			
			float dis = (float) Math.sqrt(Xdif * Xdif + Ydif * Ydif);
			
			if(dis < minDist) {
				minDist = dis;
				closest = i;
			}
		}
		
		return closest;
		
	}
	
	public float getXVel() {
		return (float) (Math.cos(angle) * speed);
	}
	public float getYVel() {
		return (float) (Math.sin(angle) * speed);
	}

}
