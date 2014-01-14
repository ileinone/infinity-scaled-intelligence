package org.infinityscaledintelligence.domain.messaging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import org.infinityscaledintelligence.domain.messaging.consumer.EventDrivenConsumer;
import org.openinfinity.core.exception.SystemException;

/**
 * This classes responsibilities are:
 * <ul>
 * <li>
 * </ul>
 *
 * @author Ilkka Leinonen Date: 7.9.2008 / Time: 9:29:08
 */
@SuppressWarnings("rawtypes")
public class BlockingPointToPointChannel<MessageContext> implements PointToPointChannel<MessageContext>, Comparable {

    private Integer maximumChannelSize = Integer.MAX_VALUE;
    private Integer channelSoftLimit = Integer.MAX_VALUE;
    private LinkedBlockingQueue<MessageContext> channel = new LinkedBlockingQueue<MessageContext>();
    private Collection<EventDrivenConsumer> eventDrivenConsumers = new ArrayList<EventDrivenConsumer>();
	private String endpointId;

    public BlockingPointToPointChannel(String endpointId, Integer channelSoftLimit, Integer maximumChannelSize) {
        this.endpointId = endpointId;
        this.channelSoftLimit = channelSoftLimit;
        this.maximumChannelSize = maximumChannelSize;
    }

    public BlockingPointToPointChannel(String endpointId) {
    	this.endpointId = endpointId;
    }

    public Integer getChannelSoftLimit() {
        return this.channelSoftLimit;
    }

    public void setChannelSoftLimit(Integer queueSoftLimit) {
        this.channelSoftLimit = queueSoftLimit;
    }

    public Integer getMaximumChannelSize() {
        return maximumChannelSize;
    }

    public void setMaximumChannelSize(Integer maximumChannelSize) {
        this.maximumChannelSize = maximumChannelSize;
    }

    public void send(MessageContext messageContext) throws SystemException {
        if(messageContext != null) {
            if(this.channel.size() == this.maximumChannelSize) {
            	SystemException qee = new SystemException("PointToPointChannel maximum size achieved!" );
                throw qee;
            } else if(this.channel.size() == this.channelSoftLimit) {
                try {
                    Random r = new Random();
                    // TODO make sure that the sleeptime is always positive. Otherwise memory may leak..
                    int sleepTime = 10 + r.nextInt(20);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {}
                this.channel.add(messageContext);
            } else {
                this.channel.add(messageContext);
            }
        }
    }

    public MessageContext peek() throws SystemException {
        return this.channel.peek();
    }

    public MessageContext receive() throws SystemException {
        try {
            return this.channel.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SystemException("Interrupted with force");
        }
    }

    public synchronized int getChannelSize() {
        return this.channel.size();
    }

    public void addConsumer(EventDrivenConsumer eventDrivenConsumer) throws SystemException {
        if (!this.eventDrivenConsumers.contains( eventDrivenConsumer ) )
            this.eventDrivenConsumers.add( eventDrivenConsumer );
        else
            throw buildException( "Consumer allready exists" );
    }

    private synchronized SystemException buildException(String cause) {
    	SystemException qee = new SystemException(cause);
        return qee;
    }

    public synchronized void removeConsumer(EventDrivenConsumer eventDrivenConsumer) throws SystemException {
        if( this.eventDrivenConsumers.contains( eventDrivenConsumer ) )
            this.eventDrivenConsumers.remove( eventDrivenConsumer );
        else
            throw buildException("Consumer does not exist");
    }

    public synchronized void removeAllChannelAdapters() {
        this.eventDrivenConsumers.clear();
    }

    public synchronized void clear() {
        this.channel.clear();
    }

    public boolean equals(Object obj) {
        BlockingPointToPointChannel blockingPointToPointChannel = (BlockingPointToPointChannel)obj;
        return blockingPointToPointChannel.getEndpointId().equals(this.getEndpointId());
    }

	public Integer getConsumerSize() {
		return this.eventDrivenConsumers.size();
	}

	public String getEndpointId() {
		return this.endpointId;
	}

	public int compareTo(Object o) {
	      BlockingPointToPointChannel blockingPointToPointChannel = (BlockingPointToPointChannel)o;
	      return blockingPointToPointChannel.getEndpointId().equals(this.getEndpointId())?0:1;
	}

}