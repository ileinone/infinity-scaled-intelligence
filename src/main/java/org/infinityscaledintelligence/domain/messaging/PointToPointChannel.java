package org.infinityscaledintelligence.domain.messaging;

import org.openinfinity.core.exception.SystemException;

public interface PointToPointChannel<MessageContext> extends MessageChannel<PointToPointChannel> {

    public void send(MessageContext messageContext) throws SystemException;

    public MessageContext peek() throws SystemException;

    public MessageContext receive() throws SystemException;

    public String getEndpointId();
    
	public Integer getConsumerSize();
	
}