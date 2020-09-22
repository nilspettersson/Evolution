
public class Animal {
	
	double angle = 0;
	double speed = 1;
	
	public Animal() {
		
	}
	
	public void update() {
		angle+=0.01;
	}
	
	public float getXVel() {
		return (float) (Math.cos(angle) * speed);
	}
	public float getYVel() {
		return (float) (Math.sin(angle) * speed);
	}

}
