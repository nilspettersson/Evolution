import java.util.ArrayList;

import org.joml.Vector4f;

import niles.lwjgl.loop.Game;
import niles.lwjgl.loop.Layer;

public class Main extends Game {
	
	public static void main(String[] args) {
		new Main();
	}
	
	ArrayList<Animal> animals;
	Layer animalLayer;
	
	ArrayList<Food> food;
	Layer foodLayer;
	
	@Override
	public void setup() {
		addLayer(100000, false);
		
		animals = new ArrayList<Animal>();
		animalLayer = getLayer(0);
		for(int i = 0; i < 10; i++) {
			animalLayer.addEntity((float) (Math.random() * 800)-400, (float) (Math.random() * 800)-400, 10, 10, new Vector4f(1), 0);
			animals.add(new Animal(i));
		}
		
		
		addLayer(100000, false);
		food = new ArrayList<Food>();
		foodLayer = getLayer(1);
		for(int i = 0; i < 200; i++) {
			foodLayer.addEntity((float) (Math.random() * 800)-400, (float) (Math.random() * 800)-400, 10, 10, new Vector4f(1, 0, 0, 1), -1);
			food.add(new Food(i));
		}
		
	}

	@Override
	public void update() {
		
		for(int i = 0; i < animalLayer.size(); i++) {
			animalLayer.setX(i, animalLayer.getX(i) + animals.get(i).getXVel());
			animalLayer.setY(i, animalLayer.getY(i) + animals.get(i).getYVel());
			animals.get(i).update(animalLayer, animals, foodLayer, food);
		}
		
		for(int i = 0; i < foodLayer.size(); i++) {
			food.get(i).update(foodLayer, food);
		}
		
		render(1, true);
		render(0, true);
		
		
		setFpsCap(120);
		System.out.println(getFps());
	}
	
	

}
