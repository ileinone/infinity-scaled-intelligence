package org.infinityscaledintelligence.domain.messaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.infinityscaledintelligence.domain.messaging.consumer.EventDrivenConsumer;
import org.openinfinity.core.exception.SystemException;
import org.openinfinity.core.util.ExceptionUtil;

public class SocketClientMessageChannel implements PointToPointChannel<MessageContext> {

private Socket socket;
	
	private boolean connected = false;
	
	private PrintWriter output;

	private BufferedReader input;
    
	public SocketClientMessageChannel(String hostName, int portNumber) {
		try {
			this.socket = new Socket(hostName, portNumber);
			this.output = new PrintWriter(socket.getOutputStream(), true);
		    this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    this.connected = true;
		} catch (Throwable throwable) {
			ExceptionUtil.throwSystemException("Exception occurred while connecting to server.", throwable);
		}
	}
	
	public void addConsumer(EventDrivenConsumer eventDrivenConsumer)
			throws SystemException {
		// TODO Auto-generated method stub
		
	}

	public void removeConsumer(EventDrivenConsumer eventDrivenConsumer)
			throws SystemException {
		// TODO Auto-generated method stub
		
	}

	public Integer getMaximumChannelSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMaximumChannelSize(Integer maximumQueueSize) {
		// TODO Auto-generated method stub
		
	}

	public Integer getChannelSoftLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChannelSoftLimit(Integer limit) {
		// TODO Auto-generated method stub
		
	}

	public int getChannelSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void removeAllChannelAdapters() {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void send(MessageContext messageContext) throws SystemException {
		this.output.write(messageContext.toProtocolMessage());
		
	}

	public MessageContext peek() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageContext receive() throws SystemException {
		try {
			String message = input.readLine();
			MessageContext messageContext = new MessageContext(message);
			return messageContext;
		} catch (IOException e) {
			throw new SystemException(e);
		}
	}

	public String getEndpointId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getConsumerSize() {
		// TODO Auto-generated method stub
		return null;
	}

}
