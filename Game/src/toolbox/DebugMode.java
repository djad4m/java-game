package toolbox;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class DebugMode {


	public static void CheckForDebugMode() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_V)) {

				GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);

		}

		if(Keyboard.isKeyDown(Keyboard.KEY_B)) {
			
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		
		}
		
	}
	
}
