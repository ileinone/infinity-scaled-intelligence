package org.infinityscaledintelligence.domain.messaging.consumer;

import java.util.Random;

import org.infinityscaledintelligence.domain.messaging.PointToPointChannel;
import org.openinfinity.core.exception.ApplicationException;
import org.openinfinity.core.exception.SystemException;

/**
 * This classes responsibilities are:
 * <ul>
 * <li>
 * </ul>
 *
 * @author Ilkka Leinonen / HiCon Software / Date: 24.10.2008 / Time: 11:28:55
 */
public abstract class AbstractEventDrivenConsumer<MessageContext> implements EventDrivenConsumer<MessageContext> {

	protected static String LOGGER = AbstractEventDrivenConsumer.class.getName();
    private String sessionId;
    private String consumerId;
    private String channelId;
    private boolean consumerAlive;
    private boolean processing;
    private PointToPointChannel<MessageContext> pointToPointChannel;

    public AbstractEventDrivenConsumer(String sessionId, PointToPointChannel<MessageContext> pointToPointChannel) {
        this.sessionId = sessionId;
        this.pointToPointChannel = pointToPointChannel;
    }

    public void run() {
        while(isConsumerAlive()) {
           try {
                process();
           } catch (ApplicationException e) {
                System.out.println("AbstractEventDrivenConsumer.run(): ApplicationException occurred: " + e.toString());
                e.printStackTrace();
           } catch (SystemException e) {
                System.out.println("AbstractEventDrivenConsumer.run(): SystemException occurred: " + e.toString());
                e.printStackTrace();
           } catch(Throwable t) {
                System.out.println("AbstractEventDrivenConsumer.run(): Unknown exception occurred: " + t.toString());
                t.printStackTrace();
            } finally {
            	long start = System.currentTimeMillis();
            	Thread.yield();
            	System.out.println("Yielding took: " + (System.currentTimeMillis()-start)); 
            }
        }
    }
    

    public void finalize() {
        this.waitForProcessing();
        try {
            getPointToPointChannel().removeConsumer(this);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void setPointToPointChannel(PointToPointChannel<MessageContext> pointToPointChannel) {
        this.pointToPointChannel = pointToPointChannel;
    }

    public String getChannelId() {
        return channelId;
    }

    public PointToPointChannel<MessageContext> getPointToPointChannel() {
        return pointToPointChannel;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getConsumerId() {
        return this.consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public boolean equals(Object obj) {
        EventDrivenConsumer<MessageContext> eventDrivenConsumer = (EventDrivenConsumer<MessageContext>)obj;
        return eventDrivenConsumer.getSessionId().equals(this.getSessionId())
                &&
                eventDrivenConsumer.getConsumerId().equals(this.getConsumerId());
    }

    public boolean isConsumerAlive() {
        return consumerAlive;
    }

    public void setConsumerAlive(boolean consumerAlive) {
        this.consumerAlive = consumerAlive;
    }

    public boolean isProcessing() {
        return this.processing;
    }

    public void waitForProcessing() {
        while(isProcessing()) {
            Random r = new Random();
            int pollInterval = r.nextInt(100);
            try { Thread.sleep( pollInterval ); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }

    public void interrupt() {
        this.setProcessing(Boolean.FALSE);
        this.waitForProcessing();
        this.setConsumerAlive(Boolean.FALSE);
        Thread.interrupted();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ EventDrivenConsumer, sessionId [").append(this.sessionId).append("], ");
        stringBuilder.append("consumerId [").append(this.consumerId).append("], ");
        stringBuilder.append("consumerAlive [").append(this.consumerAlive).append("], ");
        stringBuilder.append("processing [").append(this.processing).append("], ");
        stringBuilder.append("pointToPointChannel endpoint [").append(this.pointToPointChannel.getEndpointId()).append("] }");
        return stringBuilder.toString();
    }

    public abstract void process() throws SystemException, ApplicationException;

}