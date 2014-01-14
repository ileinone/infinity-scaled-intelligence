package org.infinityscaledintelligence.engine.processor;

import java.util.concurrent.Callable;

import org.infinityscaledintelligence.domain.entity.Device;
import org.infinityscaledintelligence.domain.messaging.MessageContext;

public class InboundMessageProcessingUnit implements Callable<Device<?>> {

	private MessageContext messageContext;

	public InboundMessageProcessingUnit(MessageContext messageContext) {
		this.messageContext = messageContext;
	}
	
	public Device<?> call() throws Exception {
		WorkManager workManager = WorkManagerExecutor.getInstance();
		return null;
		//return workManager.submit(callable);
	}

}
