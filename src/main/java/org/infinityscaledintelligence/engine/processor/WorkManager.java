package org.infinityscaledintelligence.engine.processor;

import java.util.concurrent.Callable;

import org.openinfinity.core.exception.ApplicationException;
import org.openinfinity.core.exception.SystemException;

public interface WorkManager {
	
	public void submit(Runnable runnable) throws SystemException, ApplicationException;
	
	public Object submit(Callable<?> callable) throws SystemException, ApplicationException;
	
}