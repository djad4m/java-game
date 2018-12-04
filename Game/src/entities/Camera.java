package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private float distanceFromPlayer = 25;
	private float angleAroundPlayer = 0;
	
	private Vector3f position = new Vector3f(0, 1,0);
	private Vector3f rotation = new Vector3f(0, 0, 0);
	private float pitch;
	private float roll;
	private float yaw = 0;
	
	private Player player;
	
	
	public Camera(Player player) {
		
		this.player = player;
		
	}
	
	public void Move() {
		
		calculateZoom();
		calculatePitch();
		calculateAngleAroundPlayer();
		float horizontalDistance = calculateHorizontalDistance();
		float verticalDistance = calculateVerticalDistance();
		calculateCameraPosition(horizontalDistance, verticalDistance);
		this.yaw = 180 - (player.getRotY() + angleAroundPlayer);
		resetAngle();
		checkExit();
		
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public Vector3f getRotation() {
		return rotation;
	}
	
	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public void setRoll(float roll) {
		
		this.roll = roll;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	private void calculateCameraPosition(float horizDistance, float verticDistance) {
		
		float theta = player.getRotY() + angleAroundPlayer;
		float offsetX = (float) (horizDistance * Math.sin(Math.toRadians(theta)));
		float offsetZ = (float) (horizDistance * Math.cos(Math.toRadians(theta)));
		position.x = player.getPoisition().x - offsetX;
		position.z = player.getPoisition().z - offsetZ;
		position.y = player.getPoisition().y + verticDistance;
		
	}
	
	private float calculateHorizontalDistance() {
		
		return (float) (distanceFromPlayer * Math.cos(Math.toRadians(pitch)));
		
	}
	
	private float calculateVerticalDistance() {
		
		return (float) (distanceFromPlayer * Math.sin(Math.toRadians(pitch))+6);
		
	}
	
	private void calculateZoom() {
		
		float zoomLevel = Mouse.getDWheel() * 0.05f;
		if(distanceFromPlayer>=1.5f && distanceFromPlayer<=50) {
			distanceFromPlayer -= zoomLevel;
		}else if(distanceFromPlayer<1.5f) {
			distanceFromPlayer = 1.6f;
		}else {
			distanceFromPlayer = 50f;
		}
	}

	private void calculatePitch() {
		
		if(Mouse.isButtonDown(1)) {
			
			float pitchChange = Mouse.getDY() * 0.1f;
			if(this.pitch<45 && this.pitch>10){
				pitch -= pitchChange;
			}else if (this.pitch>45){
				pitch = pitch - 0.2f;
			}else {
				pitch = pitch + 0.2f;
			}
			
		}
		
	}

	private void calculateAngleAroundPlayer() {
		
		if(Mouse.isButtonDown(0)) {
			
			float angleChange = Mouse.getDX() * 0.3f;
			angleAroundPlayer -= angleChange;
			
		}
		
	}
	
	private void resetAngle() {
		
		if(Mouse.isButtonDown(2)) {
			
			pitch = 20;
			roll = 0;
			distanceFromPlayer = 30;
			angleAroundPlayer = 0;
			
		}
		
	}

	public float getDistanceFromPlayer() {
		return distanceFromPlayer;
	}

	private void checkExit() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			
			Display.destroy();

		}
		
	}
	
	/*
	
	public void move() {s
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			
			position.z-= 0.02f * Math.sin(Math.toRadians(90-yaw));
			position.x+= 0.02f * Math.cos(Math.toRadians(90-yaw));
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			
			position.z+= 0.02f * Math.sin(Math.toRadians(90-yaw));
			position.x-= 0.02f * Math.cos(Math.toRadians(90-yaw));
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			
			position.x-= 0.02f * Math.sin(Math.toRadians(90-yaw));
			position.z+= 0.02f * Math.cos(Math.toRadians(90-yaw));
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			
			position.x+= 0.02f * Math.sin(Math.toRadians(90-yaw));
			position.z-= 0.02f * Math.cos(Math.toRadians(90-yaw));
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			
			position.y+=0.02f;
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_CAPITAL)) {
			
			position.y-=0.02f;
			
		}
		
		if(Mouse.isButtonDown(0)) {
			
			yaw-=0.6f;
			
		}
		
		if(Mouse.isButtonDown(1)) {
			
			yaw+=0.6f;
			
		}
		
	}
	
	*/
	
}