package com.runnershigh;

import android.graphics.Rect;

public class Obstacle extends RHDrawable {
	private Rect ObstacleRect;
	public char ObstacleType; //s=slow, j=jumper //b=bonus
	public boolean didTrigger;
	
	
	public Obstacle(float _x, float _y, float _z, float _width, float _height, char type){
		super((int)_x, (int)_y, (int)_z, (int)_width, (int)_height);
		
		ObstacleType=type;
		ObstacleRect = new Rect ((int)x, (int)y, (int)x+(int)width, (int)y+(int)height);
		
		float textureCoordinates[] = { 0.0f, 1.0f, //
				1.0f, 1.0f, //
				0.0f, 0.0f, //
				1.0f, 0.0f, //
		};

		short[] indices = new short[] { 0, 1, 2, 1, 3, 2 };

		float[] vertices = new float[] { 0, 0, 0, width, 0, 0.0f, 0, height,
				0.0f, width, height, 0.0f };

		setIndices(indices);
		setVertices(vertices);
		setTextureCoordinates(textureCoordinates);
		didTrigger=false;
	}
	
	public Obstacle(Obstacle GivenObstacle){
		super((int)GivenObstacle.getX(), (int)GivenObstacle.getY(), (int)GivenObstacle.z, GivenObstacle.getWidth(), GivenObstacle.getHeight());
		x = GivenObstacle.getX();
		y = GivenObstacle.getY();
		width = GivenObstacle.getWidth();
		height = GivenObstacle.getHeight();
		ObstacleRect = GivenObstacle.getObstacleRect();
		ObstacleType = GivenObstacle.getType();
		
		float textureCoordinates[] = { 0.0f, 1.0f, //
				1.0f, 1.0f, //
				0.0f, 0.0f, //
				1.0f, 0.0f, //
		};

		short[] indices = new short[] { 0, 1, 2, 1, 3, 2 };

		float[] vertices = new float[] { 0, 0, 0, width, 0, 0.0f, 0, height,
				0.0f, width, height, 0.0f };

		setIndices(indices);
		setVertices(vertices);
		setTextureCoordinates(textureCoordinates);
	}
	public int getWidth(){
		return (int)width;
	}
	public int getHeight(){
		return (int)height;
	}
	public char getType(){
		return ObstacleType;
	}
	public void setType(char type){
		ObstacleType = type;
	}
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(int _x){
		x=_x;
	}
	public void setY(int _y){
		y=_y;
	}
	public void setObstacleRect(int l, int r, int top, int bottom){
		ObstacleRect.left=l;
		ObstacleRect.right=r;
		ObstacleRect.top=top;
		ObstacleRect.bottom=bottom;
	}
	public void setObstacleRectRight(int r){
		ObstacleRect.right=r;
	}
	public Rect getObstacleRect(){
		return ObstacleRect;
	}
	public void updateObstacleRect(int levelPosition){
		ObstacleRect.left -= levelPosition;
		ObstacleRect.right -= levelPosition;
	}
	public boolean isClicked(float clickX, float clickY){
		if(clickX <= x+width && clickX > x){
			if(clickY <= y+height && clickY > y){
				return true;
			}
		}
		return false;
	}
}
