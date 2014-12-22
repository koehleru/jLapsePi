package de.koehleru.jLapsePi;

public class DataModel {

	private Integer frames = 0;
	
	private Integer currentFrame = 0;
	
	private Integer interval = 0;
	
	public Integer getFrames() {
		return frames;
	}
	
	public void setFrames(Integer frames) {
		this.frames = frames;
	}
	
	public Integer getCurrentFrame() {
		return currentFrame;
	}
	
	public void setCurrentFrame(Integer currentFrame) {
		this.currentFrame = currentFrame;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}
}
