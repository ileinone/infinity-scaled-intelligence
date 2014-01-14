package org.infinityscaledintelligence.domain.messaging.consumer;

import org.infinityscaledintelligence.domain.messaging.MessageContext;

public interface MessageConsumer {

	public void onEvent(MessageContext messageContext);
	
}
