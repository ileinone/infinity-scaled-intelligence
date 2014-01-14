package org.infinityscaledintelligence.domain.entity.type;

public enum DeviceType {

	LIGHTNING ("device.type.lightning"),
	
	HEATING ("device.type.heating"),
	
	MOTION ("device.type.motion");
	
	private String localizedDevice;
	
	private DeviceType(String typeIdentifier) {
		this.localizedDevice = typeIdentifier;
	}
	
	public String getLocalizedDevice() {
		return this.localizedDevice;
	}
	
}
