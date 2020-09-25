import java.util.ArrayList;

import org.joml.Vector4f;

import niles.lwjgl.loop.Layer;

public class Food {
	
	private boolean done;
	
	int index;
	
	public Food(int index) {
		this.index = index;
		done = true;
	}
	
	public void update(Layer FoodLayer, ArrayList<Food> food) {
		
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	

}
