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
		animals = new ArrayList<Animal>();
		
		addLayer(100, false);
		
		animalLayer = getLayer(0);
		
		animalLayer.addEntity(0, 0, 100, 100, new Vector4f(1), 0);
		animals.add(new Animal());
	}

	@Override
	public void update() {
		
		for(int i = 0; i < animalLayer.size(); i++) {
			animalLayer.setX(i, animalLayer.getX(i) + animals.get(i).getXVel());
			animalLayer.setY(i, animalLayer.getY(i) + animals.get(i).getYVel());
			animals.get(i).update();
		}
		
		
		render(0, true);
		
	}

}
