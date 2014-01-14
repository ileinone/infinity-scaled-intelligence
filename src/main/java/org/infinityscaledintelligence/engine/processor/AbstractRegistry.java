package org.infinityscaledintelligence.engine.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.openinfinity.core.util.ExceptionUtil;

import com.infinityscaledintelligence.registry.Registry;

public abstract class AbstractRegistry<T extends Object> implements Registry<T> {

	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(Boolean.TRUE);
	private ReadLock readLock = readWriteLock.readLock();
	private WriteLock writeLock = readWriteLock.writeLock();
	
	private ArrayList<T> cachedObjects = new ArrayList<T>();
		
	public void setServiceActivators(ArrayList<T> cachedObjects) {
		try {
			writeLock.lock();
			this.cachedObjects = cachedObjects;
		} finally {
			writeLock.unlock();
		}
	}
	
	public int getSize() {
		try {
			readLock.lock();
			return this.cachedObjects.size();
		} finally {
			readLock.unlock();
		}
	}

	public T load(String className) {
		try {
			readLock.lock();
			for(T cachedObject : cachedObjects) {
				if(className.equalsIgnoreCase(cachedObject.getClass().getName())) {
					return cachedObject;
				}
			}
			ExceptionUtil.throwSystemException("Object does not exist in the memory:" + className);
			return null;
		} finally {
			readLock.unlock();
		}
	}

	public Collection<T> loadAll() {
		try {
			readLock.lock();
			return cachedObjects;
		} finally {
			readLock.unlock();
		}
	}

	public void store(T cachedObject) {
		try {
			writeLock.lock();
			boolean containsObject = false;
			for(T co : cachedObjects) {
				if(cachedObject.getClass().getName().equalsIgnoreCase(co.getClass().getName())) {
					containsObject = true;
					ExceptionUtil.throwSystemException("Memory contains allready object: " + cachedObject.getClass().getName());
				}
			}
			if(!containsObject) {
				this.cachedObjects.add(cachedObject);
			}
		} finally {
			writeLock.unlock();
		}
	}

}
