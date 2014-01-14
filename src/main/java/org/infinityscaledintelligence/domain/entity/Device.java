package org.infinityscaledintelligence.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Device<DeviceType> {
	
	public Device() {}
	
	private int id;
	
	private String name;
	
	private DeviceType deviceType;
	
	private Collection<Condition> conditions = Collections.synchronizedList(new ArrayList<Condition>());

	public void addCondition(Condition condition) {
		this.conditions.add(condition);
	}
	
	public Collection<Condition> getConditions() {
		return conditions;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public DeviceType getDeviceType() {
		return deviceType;
	}
	
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
