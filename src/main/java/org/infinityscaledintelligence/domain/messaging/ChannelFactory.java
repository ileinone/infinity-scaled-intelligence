package org.infinityscaledintelligence.domain.messaging;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ChannelFactory {

	private static ReentrantReadWriteLock REENTRANT_READ_WRITE_LOCK = new ReentrantReadWriteLock(true);
	private static ReadLock READ_LOCK = REENTRANT_READ_WRITE_LOCK.readLock();
	private static WriteLock WRITE_LOCK = REENTRANT_READ_WRITE_LOCK.writeLock();
	
	private static Map<String, PointToPointChannel<MessageContext>> POINT_TO_POINT_CHANNEL_CACHE = Collections.synchronizedMap(new HashMap<String, PointToPointChannel<MessageContext>>());
    
	public static PointToPointChannel<MessageContext> getPointToPointChannel(ChannelType channelType, String channelIdentifier) {
		if (POINT_TO_POINT_CHANNEL_CACHE.containsKey(channelIdentifier)) {
			try {
				READ_LOCK.lock();
				return POINT_TO_POINT_CHANNEL_CACHE.get(channelIdentifier);	
			} finally {
				READ_LOCK.unlock();
			}
		} else {
			try {
				WRITE_LOCK.lock();
				PointToPointChannel<MessageContext> pointToPointChannel = null;
				switch (channelType) {
					case INTERNAL_INBOUND: pointToPointChannel = new BlockingPointToPointChannel<MessageContext>(channelIdentifier);
					case INTERNAL_OUTBOUND: pointToPointChannel = new SocketClientMessageChannel("192.168.1.200", 9000);
				}
				POINT_TO_POINT_CHANNEL_CACHE.put(channelIdentifier, pointToPointChannel);
				return pointToPointChannel;
			} finally {
				WRITE_LOCK.unlock();
			}
		}
	}
	
}