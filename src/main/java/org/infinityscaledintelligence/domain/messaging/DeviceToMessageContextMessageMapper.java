package org.infinityscaledintelligence.domain.messaging;

import java.util.ArrayList;
import java.util.Collection;

import org.infinityscaledintelligence.domain.entity.Condition;
import org.infinityscaledintelligence.domain.entity.Device;
import org.infinityscaledintelligence.domain.entity.type.DeviceType;
import org.infinityscaledintelligence.domain.entity.type.PinType;

public class DeviceToMessageContextMessageMapper implements MessageMapper<Device<?>, Collection<MessageContext>> {

	public Collection<MessageContext> serialize(Device<?> device) {
		Collection<MessageContext> messageContextCollection = new ArrayList<MessageContext>();
		Collection<Condition> conditions = device.getConditions();
		for (Condition condition : conditions) {
			MessageContext messageContext = new MessageContext();
			messageContext.setPin(condition.getPinId());
			messageContext.setProtocolId("insert");
			messageContextCollection.add(messageContext);
		}
		return messageContextCollection;
	}

	public Device<?> deSerialize(Collection<MessageContext> messages) {
		Device<DeviceType> device = new Device<DeviceType>();
		for (MessageContext messageContext : messages) {
			Condition condition = null;
			if (messageContext.getPin().startsWith("A")) {
				try {
					condition = new Condition(PinType.AI, messageContext.getPin(), new Integer(messageContext.getValue()));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			} else {
				try {
				condition = new Condition(PinType.DI, messageContext.getPin(), new Integer(messageContext.getValue()));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			device.addCondition(condition);
		}
		return device;
	}

}
