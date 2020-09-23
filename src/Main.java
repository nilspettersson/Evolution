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

	@Override
	public void setup() {
		addLayer(400000, false);
		
		animals = new ArrayList<Animal>();
		animalLayer = getLayer(0);
		for(int i = 0; i < 10; i++) {
			animalLayer.addEntity((float) (Math.random() * 800)-400, (float) (Math.random() * 800)-400, 10, 10, new Vector4f(1), 0);
			animals.add(new Animal(i));
		}
		
	}

	@Override
	public void update() {
		
		for(int i = 0; i < animalLayer.size(); i++) {
			animalLayer.setX(i, animalLayer.getX(i) + animals.get(i).getXVel());
			animalLayer.setY(i, animalLayer.getY(i) + animals.get(i).getYVel());
			animals.get(i).update(animalLayer, animals);
		}
		
		
		render(0, true);
		
	}
	
	

}
