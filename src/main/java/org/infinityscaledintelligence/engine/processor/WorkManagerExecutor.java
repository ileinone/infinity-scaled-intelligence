package org.infinityscaledintelligence.engine.processor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openinfinity.core.exception.ApplicationException;
import org.openinfinity.core.exception.SystemException;
import org.openinfinity.core.util.ExceptionUtil;

/**
 * This classes responsibilities are:
 * <ul>
 * <li>
 * </ul>
 *
 * @author Ilkka Leinonen / HiCon Software / Date: 7.9.2008 / Time: 8:27:12
 */

/**
 * @author Ilkka Leinonen / HiCon Software
 *         Date: 2.9.2007 10:46:34
 */
public class WorkManagerExecutor implements WorkManager {

    private static String LOGGER = WorkManagerExecutor.class.getName();
    
    private static ExecutorService POOL;
    private static WorkManagerExecutor INSTANCE;

    static {
    	POOL = Executors.newCachedThreadPool();
    }
    
    public synchronized static WorkManagerExecutor getInstance() {
        if(INSTANCE == null) {
        	INSTANCE = new WorkManagerExecutor();
            POOL = Executors.newCachedThreadPool();
        }
        return INSTANCE;
    }

    
    public void submit(Runnable r) {
        POOL.submit(r); 
    }

    public Object submit(Callable<?> callable) {
    	Object result = null;
    	try {
    		Future<?> future = POOL.submit(callable);
        	result = future.get();
		} catch (Throwable throwable) {
			ExceptionUtil.throwSystemException(throwable);
		} 
		return result;
    }

}