package org.infinityscaledintelligence.domain.entity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.infinityscaledintelligence.domain.entity.type.ConditionType;
import org.infinityscaledintelligence.domain.entity.type.PinType;
import org.openinfinity.core.util.ExceptionUtil;

public class Condition {
	
	private PinType pinType;
	
	private ConditionType conditionType;
	
	private Socket socket;
	
	private boolean connected = false;
	
	private Device<?> device;
	
	public Device<?> getDevice() {
		return device;
	}

	public void setDevice(Device<?> device) {
		this.device = device;
	}

	private PrintWriter output;
    private BufferedReader input;
    
	public Condition(PinType pinType, String pinId, Number value) throws Throwable {
		this.pinType = pinType;
		this.pinId = pinId;
		this.value = value;
		//initSocket(hostName, portNumber);
	}

	private void initSocket(String hostName, int portNumber) {
		try {
			this.socket = new Socket(hostName, portNumber);
			this.output = new PrintWriter(socket.getOutputStream(), true);
		    this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    this.connected = true;
		} catch (Throwable throwable) {
			ExceptionUtil.throwSystemException("Exception occurred while connecting to server.", throwable);
		}
	}
	
	private String pinId;
	
	private Number value;

	public String getPin() {
		return pinId;
	}

	public void setPin(String pin) {
		this.pinId = pin;
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}

	public PinType getPinType() {
		return pinType;
	}

	public void setPinType(PinType pinType) {
		this.pinType = pinType;
	}

	public String getPinId() {
		return pinId;
	}

	public void setPinId(String pinId) {
		this.pinId = pinId;
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public void send(String value) throws Throwable {
		this.output.write(value);
	}
	
	public String read() throws Throwable {
		String value = input.readLine();
		return value;
	}
	
	public ConditionType getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}
	
}