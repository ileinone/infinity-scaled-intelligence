package org.infinityscaledintelligence.engine.processor;

import org.infinityscaledintelligence.domain.messaging.MessageContext;
import org.infinityscaledintelligence.domain.messaging.PointToPointChannel;
import org.infinityscaledintelligence.domain.messaging.consumer.AbstractEventDrivenConsumer;
import org.openinfinity.core.exception.ApplicationException;
import org.openinfinity.core.exception.SystemException;

public class MessageProcessor extends AbstractEventDrivenConsumer<MessageContext>{

	public MessageProcessor(String sessionId, PointToPointChannel<MessageContext> pointToPointChannel) {
		super(sessionId, pointToPointChannel);
	}

	@Override
	public void process() throws SystemException, ApplicationException {
		MessageContext messageContext = getPointToPointChannel().receive();
		
	}
	
}
