package main.java.ic.doc.camera;

public class Camera {
	public int isOn=0;//0 stands for off
	                  //1 stands for on
	public Sensor sensor;
	public MemoryCard memoryCard;
    public void pressShutter() {
        // not implemented
    	if(isOn==0);
    	else if(isOn==1)
    		memoryCard.write(sensor.readData());
    }

    public void powerOn() {
        // not implemented
    	sensor.powerUp();
    	isOn=1;
    }

    public void powerOff() {
       // not implemented
    	sensor.powerDown();
    	isOn=0;
    }
}

