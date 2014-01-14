package org.infinityscaledintelligence.domain.messaging;

import org.infinityscaledintelligence.domain.messaging.consumer.EventDrivenConsumer;
import org.openinfinity.core.exception.SystemException;

/**
 * This classes responsibilities are:
 * <ul>
 * <li>
 * </ul>
 *
 * @author Ilkka Leinonen / HiCon Software / Date: 9.9.2008 / Time: 18:35:34
 */
public interface MessageChannel<Channel> {

    public void addConsumer(EventDrivenConsumer eventDrivenConsumer) throws SystemException;

    public void removeConsumer(EventDrivenConsumer eventDrivenConsumer) throws SystemException;

    public Integer getMaximumChannelSize();

    public void setMaximumChannelSize(Integer maximumQueueSize);

    public Integer getChannelSoftLimit();

    public void setChannelSoftLimit(Integer limit);

    public int getChannelSize();

    public void removeAllChannelAdapters();

    public void clear();

}
