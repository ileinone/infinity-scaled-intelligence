package org.infinityscaledintelligence.domain.messaging.consumer;

import org.infinityscaledintelligence.domain.messaging.PointToPointChannel;
import org.openinfinity.core.exception.ApplicationException;
import org.openinfinity.core.exception.SystemException;

/**
 * This classes responsibilities are:
 * <ul>
 * <li>
 * </ul>
 *
 * @author Ilkka Leinonen / HiCon Software / Date: 7.9.2008 / Time: 9:48:33
 */
public interface EventDrivenConsumer<MessageContext> extends Runnable {

    public void process() throws SystemException, ApplicationException;

    public void interrupt();

    public void setSessionId(String sessionId);

    public String getSessionId();

    public void setConsumerId(String consumerId);

    public String getConsumerId();

    public boolean isConsumerAlive();

    public boolean isProcessing();

    public PointToPointChannel<MessageContext> getPointToPointChannel();

}
