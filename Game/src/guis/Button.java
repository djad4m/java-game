package guis;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import renderEngine.DisplayManager;

public class Button {

	public static float MOUSE_X;
	public static float MOUSE_Y;
	public static Vector2f MOUSE_POS;
	
	public static boolean DetectCollision(GuiTexture gui) {
		
		MOUSE_X =  (2f * Mouse.getX()) / DisplayManager.WIDTH - 1;
		MOUSE_Y =  (2f * Mouse.getY()) / DisplayManager.HEIGHT - 1f;
	
		MOUSE_POS = new Vector2f(MOUSE_X, MOUSE_Y);
		
		Vector2f VERT1 = new Vector2f(gui.getPosition().x + gui.getScale().x, gui.getPosition().y + gui.getScale().y);
		Vector2f VERT2 = new Vector2f(gui.getPosition().x - gui.getScale().x, gui.getPosition().y);
		
		if(MOUSE_POS.x < VERT1.x && MOUSE_POS.y < VERT1.y && MOUSE_POS.x > VERT2.x && MOUSE_POS.y > VERT2.y) {
		
			return true;
			
		}
		
		return false;
		
	}
	
}
