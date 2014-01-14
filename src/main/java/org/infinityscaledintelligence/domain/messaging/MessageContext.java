package org.infinityscaledintelligence.domain.messaging;

public class MessageContext {
	
	private static String PROTOCOL_DELIMITER = ":";
	
	private String protocolId;
	
	private String pin;
	
	private String value;

	public MessageContext(String fromProtocolMessage) {
		String[] protocolMessage = fromProtocolMessage.split(PROTOCOL_DELIMITER);
		String protocolId = protocolMessage[0];
		String pin = protocolMessage[1];
		String value = protocolMessage[2];
		this.protocolId = protocolId;
		this.pin = pin;
		this.value = value;
	}
	
	public MessageContext() {
	}
	
	public String getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(String protocolId) {
		this.protocolId = protocolId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toProtocolMessage() {
		return protocolId + PROTOCOL_DELIMITER + pin + PROTOCOL_DELIMITER + value;
 	}
	
}
