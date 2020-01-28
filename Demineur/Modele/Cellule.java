package Modele;

public class Cellule {
	
	private boolean visible;
	private boolean bomb;
	private boolean flag;
	private Position position;
	
	public Cellule(Position position) {
		this.bomb = false;
		this.visible = false;
		this.flag = false;
		this.position = position;
	}
	
	public boolean isBomb() {
		return this.bomb;
	}
	
	public boolean isVisible() {
		return this.visible;
	}

	public boolean isFlag() {
		return this.flag;
	}

	public Position getPosition() {
		return position;
	}
	
	public void setBomb() {
		this.bomb = true;
	}
	
	public void changeFlag() {
		if (!isVisible())
			this.flag = !flag;
	}
	
	public void makeVisible() {
		if (!isFlag())
			this.visible = true;
	}
	
}
