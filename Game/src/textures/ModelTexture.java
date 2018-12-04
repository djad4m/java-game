package textures;

public class ModelTexture {

	private int textureID;
	
	private float shineDamper = 1;
	private float reflectifity = 0;
	
	private int numberOfRows = 1;
	
	public ModelTexture(int id) {
		
		this.textureID = id;
		
	}
	
	public int getID() {
		
		return this.textureID;
		
	}

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public void setReflectifity(float reflectifity) {
		this.reflectifity = reflectifity;
	}

	public float getShineDamper() {
		return shineDamper;
	}

	public float getReflectifity() {
		return reflectifity;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

}
