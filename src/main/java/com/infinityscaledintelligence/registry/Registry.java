package com.infinityscaledintelligence.registry;

import java.util.Collection;

public interface Registry<T> {
	
	public void store(T object);
	
	public T load(String id);
	
	public Collection<T> loadAll();
	
	public int getSize();

}
