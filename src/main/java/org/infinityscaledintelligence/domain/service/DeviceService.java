package org.infinityscaledintelligence.domain.service;

import org.infinityscaledintelligence.domain.entity.Condition;
import org.infinityscaledintelligence.domain.entity.Device;
import org.infinityscaledintelligence.domain.entity.type.ConditionType;
import org.infinityscaledintelligence.domain.entity.type.DeviceType;

public interface DeviceService {
	
	public void store(Device<DeviceType> device);
	
	public void setCondition(Device<DeviceType> device, Condition condition);
	
	public void load(String deviceId);
	
	public Condition getCondition(String deviceId);
	
}
