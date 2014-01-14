package org.infinityscaledintelligence.domain.messaging;

public interface MessageMapper<FROM, TO> {
	
	public TO serialize(FROM from);
	
	public FROM  deSerialize(TO to);
	
}
