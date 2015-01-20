package test.java.ic.doc.camera;

import main.java.ic.doc.camera.Camera;
import main.java.ic.doc.camera.MemoryCard;
import main.java.ic.doc.camera.Sensor;

import org.jmock.Expectations;
import org.jmock.States;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    protected final Sensor sensor=context.mock(Sensor.class);
    protected Camera camera = new Camera();
    protected final MemoryCard memoryCard=context.mock(MemoryCard.class);
    final States SensorUpOrDown=context.states("UpOrDown").startsAs("down");
    
    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
    	camera.sensor=this.sensor;
    	//expectations
    	Expectations expectation=new Expectations(){{
    		oneOf(sensor).powerUp();
    		when(SensorUpOrDown.is("down"));
    		then(SensorUpOrDown.is("up"));
    	}};
    	context.checking(expectation);
    	//execution
    	camera.powerOn();
    	context.assertIsSatisfied();
    }
    
    @Test
    public void switchingTheCameraOnPowersDownTheSensor() {
    	camera.sensor=this.sensor;
    	context.checking(new  Expectations(){{
    		oneOf(sensor).powerDown();
    		when(SensorUpOrDown.is("up"));
    		then(SensorUpOrDown.is("down"));
    	}});
    	camera.powerOff();
    	context.assertIsSatisfied();
    }
    
    @Test
    public void PressingShutter() {
    	camera.memoryCard=this.memoryCard;
    	context.checking(new Expectations(){{
    		
    		context.assertIsSatisfied();
    	}});
    }
}
